package com.hf.atguigu;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int []arr = {8,9,1,7,2,3,5,4,6,0};

//        shellSort(arr);
        shellSort2(arr);
    }

    public static void shellSort(int[] arr) {
//        int gap = arr.length/2;
        for (int gap = arr.length/2; gap>0; gap = gap/2) {
            for (int i=gap; i<arr.length; i++) {
                for (int j=i-gap; j>=0; j-=gap) {
                    if (arr[j] > arr[j+gap]) {
                        swap(arr, j, j+gap);
                    }
                }
            }

            System.out.println("步长为"+gap+"的排序："+Arrays.toString(arr));
        }

//        for (int i=5; i<arr.length; i++) {
//            for (int j=i-5; j>=0; j-=5) {
//                if (arr[j] > arr[j+5]) {
//                    swap(arr, j, j+5);
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(arr));
//
//
//        for (int i=2; i<arr.length; i++) {
//            for (int j=i-2; j>=0; j-=2) {
//                if (arr[j] > arr[j+2]) {
//                    swap(arr, j, j+2);
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(arr));
//
//        for (int i=1; i<arr.length; i++) {
//            for (int j=i-1; j>=0; j-=1) {
//                if (arr[j] > arr[j+1]) {
//                    swap(arr, j, j+1);
//                }
//            }
//        }
//
//        System.out.println(Arrays.toString(arr));



    }


    public static void shellSort2(int[] arr) {
        for (int gap=arr.length/2; gap>0; gap /=2) {
            for (int i=gap; i<arr.length; i++) {
                //当前待插入值的索引
                int insertIndex = i;
                //待插入的值
                int insert = arr[i];
                //如果值已经比同组的前一个值大，就不做处理，只有比前一个小的情况下才做处理
                if (insert < arr[insertIndex-gap]) {
                    //因为需要把当前值与前一个值比较，所以临界条件都是判断前一个是否会越界
                    while (insertIndex -gap >= 0 && insert < arr[insertIndex - gap]) {
                        arr[insertIndex] = arr[insertIndex - gap];
                        insertIndex -= gap;
                    }
                    //当前位置就是要插入的位置
                    arr[insertIndex] = insert;
                }
            }
            System.out.println(Arrays.toString(arr));
        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
