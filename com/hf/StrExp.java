package com.hf;

public class StrExp {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char[] ch) {
        str = "hello";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StrExp exp = new StrExp();
        exp.change(exp.str, exp.ch);
        System.out.println(exp.str);
        System.out.println(exp.ch);
    }
}
