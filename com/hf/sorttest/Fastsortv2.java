package com.hf.sorttest;

/**
 * 快速排序
 *
 */
public class Fastsortv2 {
    /**
     *
     * @param a
     * @param start
     * @param end
     * @return
     */
    public void fsort(int[] a, int start, int end) {
        if (start >= end) return;
        int j=partition(a, start, end);
        fsort(a, start, j-1);
        fsort(a, j+1, end);
        return;
    }

    /**
     * 最高位做基准值：升序
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public int partition(int[] a, int lo, int hi) {
        int i=lo-1, j=hi;
        int v = a[hi];

        while(true) {
            while(a[++i] < v) {
                if (i==hi) {
                    break;
                }
            }

            while(a[--j] > v) {
                if (j==lo) {
                    break;
                }
            }
            if (i>=j) {
                break;
            }
            a = swap(a, i, j);
        }

        swap(a, hi, i);
        return i;
    }


    public int[] swap(int[] nums, int lo, int hi) {
        int tmp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = tmp;
        return nums;
    }

    public static void main(String[] args) {
        int[] data = {21,1,12, 4, 5, 20, 32, 54, 10, 18, 6, 20, 4, 9, 17};
//        int[] data = {5, 4, 8, 7, 4, 2};
        Fastsortv2 obj = new Fastsortv2();
        obj.fsort(data, 0, data.length-1);
        for (int i = 0; i< data.length; i++) {
            System.out.print(data[i]+" ");
        }
    }
}
