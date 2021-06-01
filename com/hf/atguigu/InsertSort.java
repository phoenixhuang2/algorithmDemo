package com.hf.atguigu;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {103, 23, 34, 84, 1};
        sort(arr);
    }

    public static void sort(int[] arr) {
        //默认第0个位置的数据是有序的，所以i从1开始遍历
        for (int i=1; i<arr.length; i++) {
            int insert = arr[i];
            int insertIndex = i - 1;

            //insertIndex >= 0：insert是从前一个位置向前找，所以要确保inserIndex不越界
            //insert <= arr[insertIndex]：如果当前待插入的值已经比前面一个位置的值大了，说明不需要再往前找了
            while (insertIndex >= 0 && insert <= arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //
            arr[insertIndex + 1] = insert;
            System.out.println(Arrays.toString(arr));
        }
    }
}
