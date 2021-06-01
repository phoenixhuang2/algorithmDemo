package com.hf.sorttest;

public class Fastsortv3 {

    public void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        //初始值的i可能==hi
        int i = lo+1, j = hi;
        int flag = nums[lo];
        while(true) {
            while (nums[i] < flag) {
                if (i == hi) {
                    break;
                }
                i++;
            }

            while (nums[j] > flag) {
                if (j == lo) {
                    break;
                }
                j--;
            }

            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        sort(nums, lo, j-1);
        sort(nums, j+1, hi);
    }

    public int[] swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
        return nums;
    }

    public static void main(String[] args) {
//        int[] data = {21,1,12, 4, 5, 20, 32, 54, 10, 18, 6, 20, 4, 9, 17};
        int[] data = {5, 4, 8, 7, 4, 2};
        Fastsortv3 obj = new Fastsortv3();
        obj.sort(data, 0, data.length-1);
        for (int i = 0; i< data.length; i++) {
            System.out.print(data[i]+" ");
        }
    }
}
