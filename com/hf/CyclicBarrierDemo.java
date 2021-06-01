package com.hf;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author huangfeng
 * @Date: Created in 4:40 下午 2020/12/1
 * @Description
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, ()->{
            System.out.println("集齐7颗龙珠，召唤神龙*******");
        });
        for (int i = 1; i <= 7; i++) {
            int tmp = i;
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"集齐第"+tmp+"颗龙珠");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
