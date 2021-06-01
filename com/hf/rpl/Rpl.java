package com.hf.rpl;

import java.util.Stack;

public class Rpl {
    public int evalRPN(String[] tokens) {
        //借用栈来解决
        Stack<String> stack = new Stack<>();
        for (String item: tokens) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                switch(item) {
                    case "+":
                        res = num2 + num1;
                        stack.push(res+"");
                        break;
                    case "-":
                        res = num2 - num1;
                        stack.push(res+"");
                        break;
                    case "*":
                        res = num2 * num1;
                        stack.push(res+"");
                        break;
                    case "/":
                        res = num2 / num1;
                        stack.push(res+"");
                        break;
                    default:
                        throw new RuntimeException("运算符不正确");
                }
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public int evalRPN2(String[] tokens) {
        int[] nums = new int[tokens.length];
        int index = 0;
        for (String num: tokens) {
            switch (num) {
                case "+":
                    nums[index-2] += nums[index-1];
                    index--;
                    break;
                case "-":
                    nums[index-2] -= nums[index-1];
                    index--;
                    break;
                case "*":
                    nums[index-2] *= nums[index-1];
                    index--;
                    break;
                case "/":
                    nums[index-2] /= nums[index-1];
                    index--;
                    break;
                default:
                    nums[index++] = Integer.parseInt(num);
            }
        }
        return nums[0];
    }
}
