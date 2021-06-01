package com.hf;

import java.util.concurrent.*;

/**
 * @Author huangfeng
 * @Date: Created in 2:25 下午 2020/12/1
 * @Description
 **/
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService myThreadPool = new ThreadPoolExecutor(
                2,
                5,
                2,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                new ThreadPoolExecutor.DiscardPolicy()//都是ThreadPoolExecutor的内部类
                );

        try{
            for (int i = 1; i <= 10; i++) {
                int tmp = i;
                myThreadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" 办理业务 "+tmp );
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }finally {
            myThreadPool.shutdown();
        }
    }
    public static void test() {
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 20; i++) {
                int tmp = i;
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" 接待了 " );
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            threadPool.shutdown();
        }


    }
}
