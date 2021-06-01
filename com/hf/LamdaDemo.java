package com.hf;


import javax.swing.*;

/**
 * @Author huangfeng
 * @Date: Created in 7:18 下午 2020/12/1
 * @Description
 **/
public class LamdaDemo {
    public static void main(String[] args) {
        LamdaDemo.add("a", "B", String::compareToIgnoreCase);
//        var timer = new Timer(1000, System.out::println);

//        new Thread(()->{
//            System.out.println(Thread.currentThread().getName()+" runnable run接口的实现");
//        }).start();

    }

    public static void add(String x, String y, LamdaTest lamdaTest) {
        System.out.println(lamdaTest.add(x, y));
    }
}


interface LamdaTest {
    public int add(String x, String y);
}


