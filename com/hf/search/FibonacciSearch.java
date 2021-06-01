package com.hf.search;

import java.util.Arrays;

public class FibonacciSearch {
    private static final int MAXSIZE = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89};
        int resultIndex = search(arr, 89);
        System.out.println("resultIndex = "+resultIndex );
        if (resultIndex != -1) {
            System.out.println(" arr["+resultIndex+"] = "+arr[resultIndex]);
        }
    }

    public static int[] fibonacci() {
        int[] arr = new int[MAXSIZE];
        arr[0] = 1;
        arr[1] = 1;
        for (int i=2; i<MAXSIZE; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
//        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static int search(int[] arr, int findVal) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;
        int mid = 0;
        int[] fib = fibonacci();

        //获取k的值
        while(high > fib[k]-2) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, fib[k] - 1);
        if (fib[k] > high) {
            for (int i = high+1; i<temp.length; i++) {
                temp[i] = arr[high];
            }
        }
        while(low <= high) {
            mid = low + fib[k-1] -1;
            if (findVal < temp[mid]) {
                high = mid-1;
                k = k-1;
            } else if (findVal > temp[mid]) {
                low = mid+1;
                k = k - 2;
            } else {
                //有可能mid指向了补充的数据，会超过数组的长度
                if (mid < high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
