package com.hf.sorttest;

import java.util.Arrays;

/**
 * 快速排序
 * 思路1：
 * 1）、找基准值
 * 2）、两个方向搜索，i从小到大找，大于基准值的；j从大到小找，小于基准值的；交换二者的位置
 * 3）、最后基准值的位置确定：如果是最高位做基准值，那就取i交换；如果是最低位做基准值，就取j交换
 *      因为i搜索的是大于基准值的，基准值的位置在最高，是要大于基准值的才可以
 *      低位同理
 * 4）、一轮下来确定了基准值的位置为i后，把数组拆分成了3个部分 a[0,...,i-1] a[i] a[i+1,...,lenght-1]
 * 5）、再分别对两个子数组进行排序
 *
 * 注意：边界条件的确定
 * 0、基准值所在的位置不包括在指针遍历的范围内；初始化需要考虑这个点
 * 1、i不能超过最大值，否则中断查找 （这两点一定注意，不然数组会越界）
 * 2、j不能超过最小值，否则中断查找
 * 3、i大于等于j，说明两个指针相碰了，中断查找，没有必要了，因为后面都是重复的了，都是已经确认过的值
 */
public class Fastsort {
    /**
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    public void fsort(int[] a, int start, int end) {
        if (start >= end) return;
        int j=partition(a, start, end);
        fsort(a, start, j-1);
        fsort(a, j+1, end);
        return;
    }

    /**
     * 最低位做基准值：升序
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public int partition(int[] a, int lo, int hi) {
        int i=lo, j=hi+1;
        int v = a[lo];

        while(true) {
            //找出大于等于v的值所在位置i
            while(a[++i] < v) {
                //在元素个数很少的情况下，有可能越界，边界值判断
                //==最大值就需要退出了，因为是++i，如果等于不退出，下一个循环++i就会越界
                if (i==hi) {
                    break;
                }
            }
            //找出小于等于v的值所在的位置j
            while(a[--j] > v) {
                //==最小值就需要退出了，因为是--j，如果不退出，下一个循环--j就会越界
                if (j==lo) {
                    break;
                }
            }
            //如果i超过了j说明后续的已经判断过了，符合条件了，不需要交换，直接退出
            if (i>=j) {
                break;
            }
            a = swap(a, i, j);
        }
        //j当前所在位置就是小于基准值的，
        // 为什么不能用i?因为i可能已经越过j了，i的值会大于基准值，再交换就不符合要求了，
        // 基准值是在最低位，需要用小的值交换位置
        // 基准值的插入位置为j
        swap(a, lo, j);
        return j;
    }


    public int[] swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
        return nums;
    }

    public static void main(String[] args) {
        int[] data = {21,1,12, 4, 5, 20, 32, 54, 10, 18, 6, 20, 4, 9, 17};
        Fastsort obj = new Fastsort();
        obj.fsort(data, 0, data.length-1);
        System.out.println(Arrays.toString(data));
    }
}
