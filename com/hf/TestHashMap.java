package com.hf;

import com.hf.sorttest.Fastsort;

import java.util.Arrays;
import java.util.HashMap;

public class TestHashMap {
    public void test() {
        HashMap map = new HashMap();
    }

    public static void main(String[] args) {
        int[] nums = {4,6,0, 23,11, 2, 9, 14};
        TestHashMap obj = new TestHashMap();
//        obj.fast(nums, 0, nums.length-1);
//        obj.fastV2(nums, 0, nums.length-1);
//        obj.insert(nums);
        obj.mergeSort(nums, 0, nums.length-1);
        for (int i=0; i<nums.length; i++) {
//            System.out.print(nums[i]+" ");
        }

    }

    /**
     *
     * @param nums
     * @param lo
     * @param hi
     */
    public void fast(int[] nums, int lo, int hi)
    {
        if (lo >= hi || hi < 0 || lo < 0) { return;}
        if (nums.length == 0) return;
        //找基准值
        int flag = nums[hi];
        int start = lo;
        int end = hi-1;
        //拆分
        while(true) {
            while (nums[start] < flag) {
                if (start >= hi) {
                    break;
                }
                start++;
            }

            while (nums[end] > flag) {
                if (end <= lo) {
                    break;
                }
                end--;
            }

            if (start >= end) {
                break;
            }
            //交换两个
            swap(nums, start, end);
        }
        //此处是跟start 还是end交换，取决于基准值取的是最高位还是最低为
        swap(nums, start, hi);

        fast(nums, lo, start-1);
        fast(nums, start+1, hi);
    }


    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void fastV2(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int flag = nums[hi];
        int i, j;
        for (i=lo, j=lo; j<hi; j++) {
            if (nums[j] < flag) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, hi);

        fastV2(nums, lo, i-1);
        fastV2(nums, i+1, hi);
    }

    public void insert(int[] nums) {
        for (int i=1,j; i<nums.length; i++) {
            int current = nums[i];
            //每次需要初始化
            j = i-1;
            while (j >=0 && nums[j] > current ) {
                nums[j+1] = nums[j];
               j--;
            }

            nums[j+1] = current;
        }
    }

    public void mergeSort(int[] nums, int lo, int hi)
    {
        if (lo >= hi) return;
        int index = lo + (hi - lo)/2;
        mergeSort(nums, lo, index);
        mergeSort(nums, index+1, hi);
        merge(nums, lo, index, hi);
    }

    public void merge(int[] nums, int lo, int mid, int hi) {
        //在原数组上操作，需要克隆一个数组
        int[] copy = nums.clone();
        //i是左边排好序的起始位置，j是右边排好序的起始位置
        int k=lo, i=lo, j=mid+1;
        //把两边排好序的数据合并到nums中，k是nums排序的指针位
        while(k<=hi) {
            //边界值判断放前面，否则超过边界值也会做替换操作。
            //左边右边各拿一个元素比较，小的存到nums[k],小的那边指针往后移一位
            if (i > mid) {
                //左边已经遍历完了，右边的本来就是有序的，所以就把右边的每个元素拷贝到nums[k]中
                nums[k++] = copy[j++];
            } else if (j > hi) {
                //右边已经遍历完了，左边本来就是有序的，所以就把左边的每个元素拷贝到nums[k]中
                nums[k++] = copy[i++];
            } else if (copy[j] < copy[i]) {
                nums[k++] = copy[j++];
            } else if(copy[j] >= copy[i]) {
                nums[k++] = copy[i++];
            }
        }
    }
}
