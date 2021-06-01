package com.hf;

/**
 * 查找最小元素
 */
public class FindMinOne {
    public int minOne(int[] data)
    {
        int min = data[0];
        /**
         * foreach 与 for 的区别
         * 如果需要返回index就没那么方便
         */
        for (int item:data) {
            if (item < min) {
                min = item;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        FindMinOne obj = new FindMinOne();
        int[] data = {17, 23, 11, 2, 4, 592, 24, 8, 74, 0, 73};
        int min = obj.minOne(data);
        System.out.println(min);
    }
}
