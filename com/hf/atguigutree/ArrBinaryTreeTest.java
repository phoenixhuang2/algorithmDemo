package com.hf.atguigutree;

public class ArrBinaryTreeTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.postOrder(0);
    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     *
     * @param index
     */
    public void preOrder(int index) {
        if (this.arr == null || arr.length == 0) {
            System.out.println("该二叉树为空");
            return;
        }

        System.out.println(this.arr[index]);
        if (2*index+1 < arr.length) {
            preOrder(2*index + 1);
        }

        if (2*index+2 < arr.length) {
            preOrder(2*index + 2);
        }
    }

    public void inifixOrder(int index) {
        if (this.arr == null || this.arr.length == 0) {
            System.out.println("该二叉树为空");
            return;
        }
        int left = 2*index+1;
        int right = 2*index+2;
        if (left < arr.length) {
            inifixOrder(left);
        }
        System.out.println(arr[index]);
        if (right < arr.length) {
            inifixOrder(right);
        }
    }


    public void postOrder(int index) {
        if (this.arr == null || this.arr.length == 0) {
            System.out.println("该二叉树为空");
            return;
        }
        int left = 2*index+1;
        int right = 2*index+2;
        if (left < arr.length) {
            postOrder(left);
        }

        if (right < arr.length) {
            postOrder(right);
        }

        System.out.println(arr[index]);
    }
}