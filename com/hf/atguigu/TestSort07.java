package com.hf.atguigu;

import java.util.Arrays;

public class TestSort07 {

    public static void main(String[] args) {
//        int []arr = {23,2, 3, 12, 34, 9};
//        bubbleSort(arr);
//        selectSort(arr);
//        insertSort(arr);
        int []arr = {8, 9,1,7,2,3,5,4,6,0};
//        shellSort(arr);
//        shellSort2(arr);

//        quickSort(arr, 0, arr.length-1);
//        System.out.println(Arrays.toString(arr));
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
        System.out.println(Arrays.toString(arr));
    }
    //冒泡
    public static void bubbleSort(int[] arr) {
        boolean flag = false;
        //第一个元素
        for (int j = 0; j<arr.length-1; j++) {
            for (int i = 0; i < arr.length - 1 -j; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    flag = true;
                }
            }
            if (flag == true) {
                flag = false;
            } else {
                break;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    //选择
    public static void selectSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] < min) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            arr[minIndex] = arr[i];
            arr[i] = min;
            System.out.println(Arrays.toString(arr));
        }
    }

    //插入排序
    public static void insertSort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
//            int insertIndex = i;
//            int insertValue = arr[i];
//            while (insertIndex-1 >= 0 && insertValue < arr[insertIndex-1]) {
//                arr[insertIndex] = arr[insertIndex-1];
//                insertIndex--;
//            }
//            arr[insertIndex] = insertValue;
//            System.out.println(Arrays.toString(arr));

            int insertIndex = i-1;
            int insertValue = arr[i];
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1] = insertValue;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //希尔排序:交换法
    //int []arr = {8, 9,1,7,2,3,5,4,6,0};
    public static void shellSort(int[] arr) {
        for (int gap=arr.length/2; gap>0; gap/=2) {
            for (int i = gap; i<arr.length; i++) {
                for (int j=i-gap; j>=0; j -=gap) {
                    if (arr[j] > arr[j+gap]) {
                        swap(arr, j, j+gap);
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
        }


//        //第一轮
//        int gap = arr.length/2;
//        for (int i = gap; i<arr.length; i++) {
//            for (int j=i-gap; j>=0; j -=gap) {
//                if (arr[j] > arr[j+gap]) {
//                    swap(arr, j, j+gap);
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
//
//        //第二轮
//        gap = gap/2;
//        for (int i = gap; i<arr.length; i++) {
//            for (int j=i-gap; j>=0; j -=gap) {
//                if (arr[j] > arr[j+gap]) {
//                    swap(arr, j, j+gap);
//                }
//            }
//        }
//        System.out.println(Arrays.toString(arr));
    }

    //希尔排序：移步法，插入排序
    public static void shellSort2(int[] arr) {
        for (int gap=arr.length/2; gap>0; gap/=2) {
            for (int i = gap; i<arr.length; i++) {
//                for (int j=i-gap; j>=0; j -=gap) {
//                    if (arr[j] > arr[j+gap]) {
//                        swap(arr, j, j+gap);
//                    }
//                }

                int insertIndex = i - gap;
                int insertValue = arr[i];
                while(insertIndex >= 0 && insertValue < arr[insertIndex]) {
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                arr[insertIndex+gap] = insertValue;


            }
            System.out.println(Arrays.toString(arr));
        }
    }

    //快速排序
    //int []arr = {8, 9,1,7,2,3,5,4,6,0};
    public static void quickSort(int[] arr, int left, int right) {

        if (left >= right) return;
        int index = partition(arr, left, right);
        quickSort(arr, left, index-1);
        quickSort(arr, index+1, right);

    }

    private static int partition(int[] arr, int left, int right) {
        //最低位做基准值
        int flagV = arr[left];
        //两个指针，分别从小到大，从大到小，依次取出数据与基准值做比较
        int i = left;
        int j = right+1;

        while (true) {
           while(arr[++i] < flagV) {
               if (i == right) {
                   break;
               }
           }

           while (arr[--j] > flagV) {
               if (j == left) {
                   break;
               }
           }

           if (i >= j) {
               break;
           }

           swap(arr, i, j);
        }

        swap(arr, left, j);
        return j;
    }

    //基数排序
    public static void radixSort(int[] arr) {

    }

    //归并排序
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid+1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid+1;
        int k = 0;
        while (i<=mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                k++;
                i++;
            } else {
                temp[k] = arr[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            temp[k] = arr[i];
            k++;
            i++;
        }


        while (j <= right) {
            temp[k] = arr[j];
            k++;
            j++;
        }


        k = 0;
        int q = left;
        while (q <= right) {
            arr[q] = temp[k];
            q++;
            k++;
        }
    }
}
