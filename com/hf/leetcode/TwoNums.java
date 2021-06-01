package com.hf.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoNums {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i=0; i<nums.length; i++) {
            for (int j = i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        throw new IllegalArgumentException("no two nums solution");
    }

    public static void main(String[] args) {
        int[] nums = {-3,4,3,90};
        int target = 0;
        TwoNums obj = new TwoNums();
        int[] result = obj.twoSum(nums, target);
        for (int i =0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
