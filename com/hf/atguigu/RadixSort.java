package com.hf.atguigu;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr) {
        //算出最大值的位数,决定循环的次数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        //存放个十百千万。。。位，算出的数据，个数是确定的10个，因为每位就10种可能0-9，深度又数组长度确定
        int[][] bucket = new int[10][arr.length];
        //存放每个桶的插入标识位，循环利用前记得清空
        int[] bucketCount = new int[10];
        //最大值的位数控制循环次数
        for (int m = 0, n = 1; m < maxLength; m++, n *= 10) {
            //把数据依次放入各个桶中
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i]/n % 10;
                bucket[num][bucketCount[num]] = arr[i];
                bucketCount[num]++;
            }
            int t = 0;
            //把桶中的数据取出来依次放回数组中
            for (int j = 0; j < 10; j++) {
                if (bucketCount[j] > 0) {
                    for (int k = 0; k < bucketCount[j]; k++) {
                        arr[t++] = bucket[j][k];
                    }
                }
                //清空桶计数器
                bucketCount[j] = 0;
            }
            System.out.println(Arrays.toString(arr));

        }
    }
}
