package com.atguigu.huffmancode;

import java.util.*;

/**
 * @Author: Administrator
 * @DATE:2020/7/13 15:17
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();
        byte[] zipBytes = zip(bytes);
        System.out.println(Arrays.toString(zipBytes));
    }

    private static byte[] zip(byte[] bytes) {
        // 字节数组转node节点集合
        List<Node> list = byteToNode(bytes);
        // node节点组成赫夫曼树
        Node root = transHuffmanTree(list);
        // 生成字节编码表
        Map<Byte, String> map = codingTable(root);
        // 返回压缩后的字节数组
        return toNewbytes(bytes, map);
    }

    private static byte[] toNewbytes(byte[] bytes, Map<Byte, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Byte b : bytes) {
            stringBuilder.append(map.get(b));
        }
        int length = (stringBuilder.length() + 7) / 8;
        byte[] byte1 = new byte[length];
        int index = 0;
        for (int i=0; i<stringBuilder.length(); i+=8) {
            if (i + 8 > stringBuilder.length()) {
                byte1[index++] = (byte) Integer.parseInt(stringBuilder.substring(i), 2);
            } else {
                byte1[index++] = (byte) Integer.parseInt(stringBuilder.substring(i, i + 8), 2);
            }
        }
        return byte1;
    }

    private static Map<Byte, String> codingTable(Node root) {
        Map<Byte, String> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();
        if (Objects.nonNull(root)) {
            codingTable(root.getLeft(), "0", stringBuilder, map);
            codingTable(root.getRight(), "1", stringBuilder, map);
        }
        return map;
    }

    private static void codingTable(Node root, String code, StringBuilder stringBuilder, Map<Byte, String> map) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        if (Objects.nonNull(root)) {
            stringBuilder1.append(code);
            if (Objects.isNull(root.getB())) {
                codingTable(root.getLeft(), "0" , stringBuilder1, map);
                codingTable(root.getRight(), "1", stringBuilder1, map);
            } else {
                map.put(root.getB(), stringBuilder1.toString());
            }
        }
    }

    private static Node transHuffmanTree(List<Node> list) {
        while (list.size() > 1) {
            Collections.sort(list);
            Node parent = new Node();
            parent.setPriority(list.get(0).getPriority() + list.get(1).getPriority());
            parent.setLeft(list.get(0));
            parent.setRight(list.get(1));
            list.remove(0);
            list.remove(0);
            list.add(parent);
        }
        return list.get(0);
    }

    private static List<Node> byteToNode(byte[] bytes) {
        List<Node> list = new ArrayList<>();
        Map<Byte, Integer> map = new HashMap<>();
        for (Byte b : bytes) {
            if (Objects.isNull(map.get(b))) {
                map.put(b, 1);
            } else {
                map.put(b, map.get(b)+1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            Node node = new Node();
            node.setB(entry.getKey());
            node.setPriority(entry.getValue());
            list.add(node);
        }
        return list;
    }
}

class Node implements Comparable<Node>{
    private int priority;
    private Byte b;
    private Node left;
    private Node right;

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Byte getB() {
        return b;
    }

    public void setB(Byte b) {
        this.b = b;
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

    public void preOrder() {
        System.out.println(this);
        if (Objects.nonNull(this.left)) {
            this.left.preOrder();
        }
        if (Objects.nonNull(this.right)) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "priority=" + priority +
                ", b=" + b +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.priority - o.priority;
    }
}
