package com.hf;

/**
 * 阶乘的递归
 */
public class Factorial {
    public int testFactorial(int x)
    {
        //递归一定要有基线条件
        if (x == 1) {
            return 1;
        } else {
            //递归调用自己
            return x * testFactorial(x-1);
        }
    }

    public static  void main(String[] args) {
        Factorial obj = new Factorial();
        int result = obj.testFactorial(1);
        System.out.println(result);
    }
}
