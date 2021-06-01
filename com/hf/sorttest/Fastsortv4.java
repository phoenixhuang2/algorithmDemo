package com.hf.sorttest;

import java.util.Arrays;

/**
 * 思路：
 * 1、找基准值
 * 2、从头到尾遍历，两个指针i,j，j一个遍历，i一个记录最低位置
 * 3、j遍历指针找到比基准值小的就与i低位指针交换，
 * 4、基准值放在低位指针i+1的位置,最低位指针是最后一个小于基准值的值
 * 5、一遍后，数组被拆分成3部分a[0,...,i-1] a[i] a[i+1,...,length-1]
 *
 * 这种更好处理，简洁，边界值问题更少一点
 */
public class Fastsortv4 {

    public int partition(int[] nums, int lo, int hi) {
        //j负责遍历，i记录最低位置
        int i, j;
        //最高位做基准值
        int flag = nums[hi];

        for (i = lo, j=lo; j < hi; j++) {
            if (nums[j] < flag) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, hi);
        return i;
    }

    public void sort(int[] nums, int i, int j)
    {
        if (i >= j) return;
        int f = partition(nums, i, j);
        sort(nums, i, f-1);
        sort(nums, f+1, j);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Fastsortv4 obj = new Fastsortv4();
        int[] data = {21,1,12, 4, 5, 20, 32, 54, 10, 18, 6, 20, 4, 9, 17};
//        int[] data = {5, 4, 8, 7, 4, 2};
        obj.sort(data, 0, data.length-1);
        System.out.println(Arrays.toString(data));
    }
}
