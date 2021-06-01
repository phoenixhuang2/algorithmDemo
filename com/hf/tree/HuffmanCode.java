package com.hf.tree;

import java.util.*;

public class HuffmanCode {
    //存储全部的编码
    private static StringBuilder stringBuilder = new StringBuilder();
    //存储字符对应的编码
    private static Map<Byte, String> byteHuffmanCode = new HashMap<>();
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        Node huffmanTreeRoot = getHuffmanTree(str);
//        System.out.println(huffmanTreeRoot.getWeight());
//        HuffmanTree.preOrder(huffmanTreeRoot);
        getHuffmanTreeByteCode(huffmanTreeRoot);
        byte[] result = getHuffmanCode(str.getBytes(), byteHuffmanCode);
        System.out.println(Arrays.toString(result));
    }

    //给一个字符串，获取赫夫曼树
    private static Node getHuffmanTree(String str) {
        byte[] contentBytes = str.getBytes();
        Map<Byte, Integer> byteCountMap = new HashMap<>();
        ArrayList<Node> arrayList = new ArrayList<>();

        for (byte value: contentBytes) {
            Integer tempNum = byteCountMap.get(value);
            if (tempNum == null) {
                byteCountMap.put(value, 1);
            } else {
                byteCountMap.put(value, tempNum+1);
            }
        }
        for (Map.Entry<Byte, Integer> val : byteCountMap.entrySet()) {
            arrayList.add(new Node(val.getValue(), val.getKey()));
        }
        return HuffmanTree.createHuffmanTree(arrayList);
    }


    private static void getHuffmanTreeByteCode(Node root) {
        if (root == null) {
            System.out.println("赫夫曼树为空");
        } else {
             getCodes(root.getLeft(), 0, stringBuilder);
             getCodes(root.getRight(), 1, stringBuilder);
        }
        System.out.println(byteHuffmanCode);
    }

    private static void getCodes(Node node, int code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node != null) {
            if (node.getContent() == null) {
                getCodes(node.getLeft(), 0, stringBuilder1);
                getCodes(node.getRight(), 1, stringBuilder1);
            } else {
                byteHuffmanCode.put(node.getContent(), stringBuilder1.toString());
            }
        }
    }

    private static byte[] getHuffmanCode(byte[] bytes, Map<Byte, String> byteHuffmanCode) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte value:bytes) {
            stringBuilder.append(byteHuffmanCode.get(value));
        }
        System.out.println(stringBuilder.toString());

        //计算长度
        int len;
        if (stringBuilder.length() % 8 == 0) {
            len = stringBuilder.length() / 8;
        } else {
            len = stringBuilder.length() / 8 + 1;
        }

        byte[] resultByte = new byte[len];
        int index = 0;
        for (int i=0; i<stringBuilder.length(); i+=8) {
            if (i+8 <= stringBuilder.length()) {
                resultByte[index] = (byte) Integer.parseInt(stringBuilder.substring(i, i + 8), 2);
            } else {
                resultByte[index] = (byte) Integer.parseInt(stringBuilder.substring(i), 2);
            }
            index++;
        }
        return resultByte;
    }

}
