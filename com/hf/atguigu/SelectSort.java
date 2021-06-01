package com.hf.atguigu;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 99, 124, 12};
        sort(arr);
//        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {

        for (int i=0; i<arr.length-1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = 1 + i; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println(Arrays.toString(arr));
        }

    }
}
