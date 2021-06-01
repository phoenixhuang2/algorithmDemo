package com.hf.stack;

import java.util.ArrayList;

public class ArrayStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
        minStack.list();
//        minStack.min();
//        minStack.list();
//        minStack.pop();
//        minStack.list();
//        minStack.top();
//        minStack.list();
//        minStack.min();

    }
}

class MinStack {
    ArrayList<Integer> data;
    int top;
    /** initialize your data structure here. */
    public MinStack() {
        this.data = new ArrayList<>();
        top = -1;
    }

    public void push(int x) {
        top++;
        this.data.add(top, x);

    }

    public void pop() {
        if (top == -1) {
            return;
        }
        int x = this.data.get(top);
        top--;
    }

    public int top() {
        if (top == -1) {
            return 0;
        }
        return this.data.get(top);
    }

    public void list() {
        if (top == -1) {
            return;
        }
        for (int i=top; i>-1; i--) {
           System.out.println(this.data.get(i));
        }
        System.out.println("=========");
    }

    public int min() {
        int cur = top();
        for (int i=top; i>-1; i--) {
            if (this.data.get(i) < cur) {
                cur = this.data.get(i);
            }
        }
        return cur;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
