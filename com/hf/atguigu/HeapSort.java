package com.hf.atguigu;

import java.util.Arrays;

/**
 * 堆排序
 *
 */
public class HeapSort {
    public static void main(String[] args) {
//        int[] arr = {4,6,8,5,9};
        int[] arr = {9,8,7,6,5,4,3,2,1};
        heapSort(arr);
    }

    /**
     * 第一步：先构建大顶堆
     * 第二步：把arr[0]与arr[length-1]的元素交换，对接下来的元素进行大顶堆调整
     * @param arr
     */
    public static void heapSort(int[] arr) {
        //构建大顶堆
        for (int i=arr.length/2-1; i>=0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));
        //把堆顶的元素跟最后一个元素（已经确认过的不需要再处理）交换位置；所以是从后往前遍历
        //交换好后重新调整堆使其成为大顶堆
        for (int j=arr.length-1; j>0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void adjustHeap(int[] arr, int pos, int length) {
        int temp = arr[pos];
        for (int i=2*pos+1; i<length; i=i*2+1) {
            //比较pos的左右节点，取其中较大的值
            if (i+1 < length && arr[i] < arr[i+1]) {
                i = i+1;
            }
            if (arr[i] > temp) {
                //直接交换
                arr[pos] = arr[i];
                arr[i] = temp;
                pos = i;
            } else {
                //是通过上浮来构建大顶堆的，前提就是当前节点的左右子树均已经是大顶堆了
                //所以最先进行上浮操作的元素会是length/2 + 1，第一个非叶子节点，叶子节点默认已经是大顶堆了
                break;
            }
        }
    }
}
