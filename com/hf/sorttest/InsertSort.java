package com.hf.sorttest;

/**
 * 插入排序
 */
public class InsertSort {

    public void insertionSort(int[] nums)
    {
        for (int i=1, j, current; i< nums.length; i++) {
             current = nums[i];
            for (j=i-1; j>=0; j--) {
                //current比当前值小，则把当前值往后挪一位，腾出current的位置
                if (current < nums[j]) {
                    nums[j+1] = nums[j];
                } else {
                    //找到第一个比current小的值，它的后一位就是current应该插入的位置
                    break;
                }
            }
            //最终的
            nums[j+1] = current;
        }
    }

    public static void main(String[] args) {
        InsertSort obj = new InsertSort();
        int[] nums = {8,4,2,5,7,2,1,6};
        obj.insertionSort(nums);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

}
