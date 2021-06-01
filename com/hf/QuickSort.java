package com.hf;

import java.util.ArrayList;

/**
 * 快速排序
 * 小到大，升序
 */
public class QuickSort {
    /**
     * 犯错：没有把基准值排除在外，导致陷入死循环
     * 实现时用基础类型数组没有成功，数组的处理语法不熟？参考网上的实现时用什么类型处理的。
     * @param data
     * @return
     */
    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        //基线条件
        if (data.size() < 2) {
            return data;
        }
        //基准值：中间位置
        int level = (int)Math.floor(data.size()/2);
        int sortTag = data.get(level);
        //空间换取时间
        ArrayList<Integer> min = new ArrayList();
        ArrayList<Integer> max = new ArrayList();

        //递归条件
        for (int i = 0; i < data.size(); i++) {
            //位置相同就不做处理，会陷入死循环
            if (i == level) {
                continue;
            }
            if (data.get(i) < sortTag) {
                min.add(data.get(i));
            } else {
                max.add(data.get(i));
            }
        }
        min = sort(min);
        min.add(sortTag);
        min.addAll(sort(max));
        return min;
    }

    /**
     * 原址重排
     * 采用交换位置的方式，达到排序的目的
     * left往大的方向搜索：大于基准值的数
     * right往小的方向搜索：小于基准值的数
     * 找到就交换二者的位置
     * 最后一个坑为基准值的位置
     * @return
     */
    public int[] sortV2(int[] data, int left, int right)
    {
        if (left > right) {
            return data;
        }
        if (left == right) {
            return data;
        }
        //取最高为基准值
        int sortTag = data[right];
        int i = left;
        //最高位是基准位，不做处理
        int j = right-1;

        //i有可能大于j
        while (true) {
            //找出大于等于sortTag的值
            while (i <= right && data[i] < sortTag) {
                i++;
            }
            //找出小于等于sortTag的值
            while (j >= left && data[j] > sortTag) {
                j--;
            }
            //i越过j了，说明已经碰撞了，不需要进行下去了
            if (i >= j) {
                break;
            }
            //交换
            data = swap(data, i, j);
        }
        //基准值取的最高位，所以要用去交换位置，i找到的是大于基准值的，j找到的是小于基准值的
        data = swap(data, i, right);

        sortV2(data, left, i-1);
        sortV2(data, i+1, right);
        return data;
    }

    public int[] swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
        return data;
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
//        ArrayList<Integer> data = new ArrayList<>();
//        data.add(21);
//        data.add(1);
//        data.add(10);
//        data.add(7);
//        data.add(9);
//        data.add(9);
//        data.add(23);
//
//        ArrayList<Integer> result = obj.sort(data);
//        System.out.println(result);
        int[] data = {21,1,12, 4, 5, 20, 32, 54, 10, 18, 6, 20, 4, 9, 17};
//        int[] data = {1,2,6,4,5,4};
        int[] result = obj.sortV2(data, 0, data.length-1);
        for (int i = 0; i< result.length; i++) {
            System.out.print(result[i]+" ");
        }

    }
}
