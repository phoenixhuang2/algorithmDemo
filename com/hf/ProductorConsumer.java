package com.hf;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author huangfeng
 * @Date: Created in 7:41 下午 2020/11/27
 * @Description
 **/
public class ProductorConsumer {
    public static void main(String[] args) throws InterruptedException {
        ShareData shareData = new ShareData();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                shareData.increment();
            }
        }).start();

        new Thread(()->{

            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                shareData.decrement();
            }
        }).start();


//        SynchronousQueue synchronousQueue = new SynchronousQueue();
//
//        new Thread(()->{
//            try {
//                System.out.println(Thread.currentThread().getName()+" 生产a");
//                synchronousQueue.put("a");
//                System.out.println(Thread.currentThread().getName()+" 生产b");
//                synchronousQueue.put("b");
//                System.out.println(Thread.currentThread().getName()+" 生产c");
//                synchronousQueue.put("c");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "thread1").start();
//
//        new Thread(()->{
//            try {
//                TimeUnit.SECONDS.sleep(5);
//                System.out.println(Thread.currentThread().getName()+"消费了"+synchronousQueue.take());
//                TimeUnit.SECONDS.sleep(5);
//                System.out.println(Thread.currentThread().getName()+"消费了"+synchronousQueue.take());
//                TimeUnit.SECONDS.sleep(5);
//                System.out.println(Thread.currentThread().getName()+"消费了"+synchronousQueue.take());
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, "thread2").start();
    }
}


class ShareData {
    private AtomicInteger i = new AtomicInteger();
    private SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();

    public void increment() {
        try {
            System.out.println(Thread.currentThread().getName()+"生产者生产了"+i);
            synchronousQueue.put(i.getAndIncrement());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void decrement() {

        try {
            int res = synchronousQueue.take();
            System.out.println(Thread.currentThread().getName()+"消费者消费了"+res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}