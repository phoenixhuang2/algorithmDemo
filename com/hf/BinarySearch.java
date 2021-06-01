package com.hf;

import java.lang.*;
import java.util.Arrays;

public class BinarySearch {
    /**
     * 二分查找
     * @param data
     * @param dest
     * @return
     */
    public int search(int[] data, int dest)
    {
        int level = (int)Math.floor(data.length / 2);
        if (data.length == 0) {
            return 0;
        }
        //基线条件
        if (data[level] == dest) {
            return data[level];
        } else if (data[level] > dest) {
            //直接缩小数组的做法？？
            //参考其他实现：数组不变，把start end 范围当作参数传入
            int[] newData = Arrays.copyOfRange(data, 0, level);
            return search(newData, dest);
        } else {
            int[] newData = Arrays.copyOfRange(data, level, data.length);
            return search(newData, dest);
        }
    }

    /***
     * 数组需要先排序
     * @param args
     */
    public static void main(String[] args)
    {
        int[] data = {2,5,6,7,8,16,19,20,22,26,27,30};
        BinarySearch obj = new BinarySearch();
        int index = obj.search(data, 6);
        System.out.println(index);
    }

}