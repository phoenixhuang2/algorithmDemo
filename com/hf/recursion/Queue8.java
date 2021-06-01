package com.hf.recursion;

public class Queue8 {
    private static final int max = 8;
    //记录行的位置，第几个元素代表第几行，数值为该元素在该行的列书
    private static int[] array = new int[max];
    private static int count = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
    }

    private void check(int n) {
        if (n == max) {
            print();
            count++;
            return;
        }

        for (int i=0; i<max; i++) {
            array[n] = i;
            if (judge(n)) {
                //如果n的第i个位置符合要求，就跳到下一层找下一个合理的位置，。。。直到最后一行为止
                //找到之后此递归就返回了，返回后不做任何处理，
                // 继续判断i++的情况，直到每一行的每一种情况都遍历一遍
                check(n+1);
            }
        }
    }


    /**
     * 判断第n个皇后与前n-1个皇后是否符合要求，不符合返回false，符合返回true
     * @param n
     * @return
     */
    private boolean judge(int n) {
        for (int i=0; i<n; i++) {
            //在同一列上
            if (array[i] == array[n]) {
                return false;
            } else if (Math.abs(i - n) == Math.abs(array[i] - array[n])) {//等腰直角三角形的两个顶点上
                return false;
            }
        }
        return true;
    }
    /**
     * 打印结果
     */
    private void print() {
        for (int i=0; i< array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
