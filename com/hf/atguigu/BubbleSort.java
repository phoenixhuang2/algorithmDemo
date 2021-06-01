package com.hf.atguigu;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, 6, 1, 5, 10};
        new BubbleSort().sort(arr);
//        System.out.println(Arrays.toString(arr));

    }

    public void sort(int[] arr) {
        //总共要进行arr.length-1轮排序；当arr.length-1个元素都确定了位置，
        //最后一个元素也就确定了位置，所以是length-1次
        //标记是否有发生交换，如果没有说明可以提前退出排序
        boolean flag = true;
        for (int i=0; i<arr.length-1; i++) {
            //比较相邻两个元素的大小，做交换处理，把倒数第i个元素的位置确定
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    flag = false;
                    swap(arr, j, j + 1);
                }
            }
            System.out.println("第"+(i+1)+"次排序："+Arrays.toString(arr));

            if (flag == true) {
                break;
            } else {
                flag = true;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
