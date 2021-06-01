package com.hf;

import java.util.concurrent.TimeUnit;

/**
 * @Author huangfeng
 * @Date: Created in 4:00 下午 2020/11/27
 * @Description
 **/
public class ThreadLocalTest {
    ThreadLocal threadLocal = new ThreadLocal();
    public int i = 0;

    public void add() {
        threadLocal.set(i++);
    }

    public void get() {
        System.out.println(Thread.currentThread().getName()+" "+threadLocal.get());
    }

    public static void main(String[] args) {
//        ThreadLocal threadLocal = new ThreadLocal();
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                try {
                    if (temp%2 == 0) {
                        TimeUnit.SECONDS.sleep(1);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                threadLocalTest.add();


//                threadLocalTest.add();
//                threadLocal.set(threadLocalTest.i);
////                threadLocalTest.add();

                threadLocalTest.get();
            }, "thread"+i).start();
        }


    }
}
