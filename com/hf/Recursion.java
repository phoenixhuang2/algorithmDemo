package com.hf;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 递归案例
 */
public class Recursion {
    /**
     * 数组求和，递归实现
     * @param data
     * @return
     */
    public int sum(int[] data) {
        //基线条件：数组只剩下一个元素
        if (data.length == 1) {
            return data[0];
        } else if (data.length == 0) {
            //极端情况，不报错
            return 0;
        }
        //copyOfRange  不包括to
        return data[0]+sum(Arrays.copyOfRange(data, 1, data.length));
    }

    /**
     * 递归计算数组元素个数
     * @param data
     * @return
     */
    public int count(int[] data) {
        if (data.length == 1) {
            return 1;
        } else if (data.length == 0) {
            return 0;
        }
        return 1+count(Arrays.copyOfRange(data, 1, data.length));
    }

    /**
     * 查找数组中最大的数
     * @param data
     * @return
     */
    public int max(int[] data) {
        //基线条件
        if (data.length == 1) {
            return data[0];
        } else if (data.length == 0) {
            return 0;
        }

        //递归条件，缩小范围
        if (data[0] > data[1]) {
            data[1] = data[0];
        }
        return max(Arrays.copyOfRange(data, 1, data.length));
    }



    public static void main(String[] args) {
        Recursion obj = new Recursion();
        int[] data = {3, 34, 4, 12, 2, 5,171};
//        int result = obj.sum(data);
//        int result = obj.count(data);
        int result = obj.max(data);
        System.out.println(result);
    }
}
