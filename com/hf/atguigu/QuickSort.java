package com.hf.atguigu;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {23, 1, 2, 10, 8, 23, 2, 5};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int position = partition(arr, left, right);
        quickSort(arr, left, position -1);
        quickSort(arr, position+1, right);
    }

    /**
     * 找基准值的位置
     * @param arr
     * @param left
     * @param right
     */
    public static int partition(int[] arr, int left, int right) {
        //定义两个指针，分别从最左边，最右边寻找目标位
        int l = left;
        int r = right+1;
        //最低位做基准值ß
        int pivot = arr[left];

        while(true) {
            while (arr[++l] < pivot) {
                if (l >= right) {
                    break;
                }
            }

            while(arr[--r] > pivot) {
                if (r <= left) {
                    break;
                }
            }

            if (l >= r) {
                break;
            }
            swap(arr, l, r);
        }

        swap(arr, left, r);
        return r;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
