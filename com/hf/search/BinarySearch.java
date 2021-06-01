package com.hf.search;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-4, 2, 5, 56, 75, 234};
        int resultIndex = binarySearch(arr, 0, arr.length-1, 75);
        System.out.println("result index = "+resultIndex);
    }

    public static int  binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (findVal > midVal) {
            return binarySearch(arr, mid+1, right,findVal);
        } else if (findVal < midVal) {
            return binarySearch(arr, left, mid-1, findVal);
        } else {
            return mid;
        }
    }
}
