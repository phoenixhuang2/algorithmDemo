package com.hf.sorttest;

/**
 * 冒泡排序法
 * 外循环控制每个元素都要遍历
 * 内循环控制相邻元素做比较，大的冒上去
 * flag标记当前元素是否有交换，没有说明已经有序了
 */
public class BubbleSort {
    public void sort(int[] nums) {
        if (nums.length == 0) return;

        for (int i=0; i<nums.length-1; i++) {
            boolean flag = true;
            for (int j=0; j<nums.length-1-i; j++) {
                if (nums[j+1] < nums[j]) {
                    swap(nums, j+1, j);
                    flag = false;
                }
            }
            if (flag == true) {
                break;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        BubbleSort obj = new BubbleSort();
        int[] nums = {4, 25, 1, 4, 9, 12, 15, 6, 8};
        obj.sort(nums);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

}
