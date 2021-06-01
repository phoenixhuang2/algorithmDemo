package com.hf;
import java.util.concurrent.CountDownLatch;

/**
 * @Author huangfeng
 * @Date: Created in 4:45 下午 2020/12/1
 * @Description
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) {
        Country s = Enum.valueOf(Country.class, "ONE");
        System.out.println(s.getName());
        return;
//        CountDownLatch countDownLatch = new CountDownLatch(6);
//        for (int i = 1; i < 7; i++) {
//            final int tmp = i;
//            new Thread(()->{
//                System.out.println(Thread.currentThread().getName()+"被秦国灭了");
//                countDownLatch.countDown();
//            }, Country.getEnumCountryByIndex(tmp).getName()).start();
//        }
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("秦灭六国，一统华夏");
    }
}

enum Testenum {
    A("a"), B("b");
    private String name;
    Testenum(String name) {
        this.name = name;
    }
}


enum Country {
    ONE(1, "齐国"), TWO(2, "燕国"), THREE(3, "楚国"), FOUR(4, "赵国"),
    FIVE(5, "魏国"), SIX(6, "韩国");

    private String name;
    private int id;

    Country(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Country getEnumCountryByIndex(int index) {
        Country[] countries = Country.values();
        for (Country e: countries) {
            if (e.id == index) {
                return e;
            }
        }
        return null;
    }
}
