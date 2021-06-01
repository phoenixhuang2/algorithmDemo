package com.hf;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,4,5,6,7,8};
        int[] arr2;
        arr2 = arr1;
//        for (int i=0; i<arr2.length; i++) {
//            arr2[i] = i*2;
//        }

        System.out.println(Arrays.toString(arr1));

        int[] arr3 = new int[arr1.length];
        for (int i=0; i< arr1.length; i++) {
            arr3[i] = arr1[i];
        }
        System.out.println(Arrays.toString(arr3));

        for (int i=0; i<arr3.length; i++) {
            arr3[i] = i*2;
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr3));
        while (true) {
            int[] arr4 = new int[20*1024*1024];

        }
    }
}
