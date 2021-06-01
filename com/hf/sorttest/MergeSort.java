package com.hf.sorttest;

import com.hf.TestHashMap;

public class MergeSort {
    public void sort(int[] nums, int lo, int hi)
    {
        if (lo >= hi) return;
        int index = lo + (hi - lo)/2;
        sort(nums, lo, index);
        sort(nums, index+1, hi);
        merge(nums, lo, index, hi);
    }

    public void merge(int[] nums, int lo, int mid, int hi) {
        //在原数组上操作，需要克隆一个数组
        int[] copy = nums.clone();
        //i是左边排好序的起始位置，j是右边排好序的起始位置
        int k=lo, i=lo, j=mid+1;
        //把两边排好序的数据合并到nums中，k是nums排序的指针位
        while(k<=hi) {
            //边界值判断放前面，否则超过边界值也会做替换操作。
            //左边右边各拿一个元素比较，小的存到nums[k],小的那边指针往后移一位
            if (i > mid) {
                //左边已经遍历完了，右边的本来就是有序的，所以就把右边的每个元素拷贝到nums[k]中
                nums[k++] = copy[j++];
            } else if (j > hi) {
                //右边已经遍历完了，左边本来就是有序的，所以就把左边的每个元素拷贝到nums[k]中
                nums[k++] = copy[i++];
            } else if (copy[j] < copy[i]) {
                nums[k++] = copy[j++];
            } else if(copy[j] >= copy[i]) {
                nums[k++] = copy[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,6,2, 23,11, 2, 9, 14};
        MergeSort obj = new MergeSort();
        obj.sort(nums, 0, nums.length-1);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
