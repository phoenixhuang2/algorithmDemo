package com.hf.binarysort;

/**
 * @Author huangfeng
 * @Date: Created in 10:50 上午 2020/11/27
 * @Description  二叉排序树
 **/
public class BinarySortTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
//    public static void main(String[] args) {
//
//    }

    public void add(Node node) {
        if (this.root == null) {
            this.root = node;
        } else {
            this.root.add(node);
        }
    }

    public void inifixOrder() {
        if (this.root == null) {
            System.out.println("二叉排序树为空。。。");
        } else {
            this.root.inifixOrder();
        }
    }

    public static void main(String[] args) {
        //4,8,1,3,9,23,6,2
        int[] arr = new int[]{4,8,1,3,9,23,6,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.inifixOrder();
    }

}




class Node {
    private int value;
    private Node left;
    private Node right;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    //二叉排序树
    public void add(Node node) {
        if (node.getValue() < this.getValue()) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }
    //中序遍历
    public void inifixOrder() {
        if (this.left != null) {
            this.left.inifixOrder();
        }
        System.out.println(this.value);
        if (this.right != null) {
            this.right.inifixOrder();
        }
    }
}

