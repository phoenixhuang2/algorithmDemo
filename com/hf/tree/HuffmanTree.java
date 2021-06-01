package com.hf.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HuffmanTree {
    public static void main(String[] args) {
//        int[] arr = new int[]{13,7,8,3,29,6,1};
        int[] arr = new int[]{1,1,1,2,2,2,4,4,4,5,5,9};
        ArrayList<Node> arrayList = new ArrayList<>();
        for (int value: arr) {
            arrayList.add(new Node(value));
        }

        Node root = createHuffmanTree(arrayList);
        preOrder(root);
    }
    public static Node createHuffmanTree(ArrayList<Node> arrayList) {


        while (arrayList.size() > 1) {
            Collections.sort(arrayList);
            Node left = arrayList.get(0);
            Node right = arrayList.get(1);
//            Node parent = new Node(left.getNo() + right.getNo());
            Node parent = new Node(left.getWeight() + right.getWeight(), null);
            parent.setLeft(left);
            parent.setRight(right);

            arrayList.add(parent);
            arrayList.remove(left);
            arrayList.remove(right);

        }
        return arrayList.get(0);
    }

    public static void preOrder(Node node) {
        if (node == null) {
            System.out.println("哈夫曼树为空");
        } else {
            node.preOrder(node);
        }
    }
}

class Node implements Comparable<Node>{
    private int no;
    private int weight;
    private Byte content;
    private Node left;
    private Node right;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Byte getContent() {
        return content;
    }

    public void setContent(Byte content) {
        this.content = content;
    }

    public Node(int no) {
        this.no = no;
    }

    public Node(int weight, Byte content) {
        this.weight = weight;
        this.content = content;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return " [node weight="+this.weight+" content="+this.content+"] ";
    }


    public void preOrder(Node node) {
//        System.out.println(node.getNo());
        System.out.println(node.getWeight());
        if (node.getLeft() != null) {
            preOrder(node.getLeft());
        }

        if (node.getRight() != null) {
            preOrder(node.getRight());
        }
    }
}
