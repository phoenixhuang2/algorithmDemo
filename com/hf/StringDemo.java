package com.hf;

/**
 * @Author huangfeng
 * @Date: Created in 12:57 下午 2020/12/2
 * @Description
 **/
public class StringDemo {
//    public static void main(String[] args) {
//        Person2 p1 = new Person2(); p1.name = "atguigu";
//        Person2 p2 = new Person2(); p2.name = "atguigu";
//        System.out.println(p1.name .equals( p2.name)); //
//        System.out.println(p1.name == p2.name); //
//        System.out.println(p1.name == "atguigu"); //
//        String s1 = new String("bcde");
//        String s2 = new String("bcde"); System.out.println(s1==s2); //



//    }
    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };
    public void change(String str, char ch[]) { str = "test ok";
        ch[0] = 'b'; }
    public static void main(String[] args) {
//        StringDemo ex = new StringDemo(); ex.change(ex.str, ex.ch); System.out.print(ex.str + " and ");
//        System.out.println(ex.ch);


        String str = null;
        StringBuffer sb = new StringBuffer();
        //null当作字符串加入了，所以长度是4
        sb.append(str);
        System.out.println(sb.length());
        System.out.println(sb);//
        //构造函数不接收null字符串，会调用str.length()方法，抛异常
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);//
    }
}

class Person2 {
    public String name;
}
