package com.atguigu.huffmantree;

import java.util.*;

/**
 * @Author: Administrator
 * @DATE:2020/7/5 20:20
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);
        preOrder(root);
    }

    private static void preOrder(Node root) {
        if (Objects.nonNull(root)) {
            root.preOrder();
        }
    }

    private static Node createHuffmanTree(int[] arr) {
        List<Node> list = new ArrayList<>();
        for (int num : arr) {
            list.add(new Node(num));
        }
        while (list.size() > 1) {
            Collections.sort(list);
            Node parentNode = new Node(list.get(0).getValue() + list.get(1).getValue());
            parentNode.setLeftNode(list.get(0));
            parentNode.setRightNode(list.get(1));
            list.remove(list.get(0));
            list.remove(list.get(0));
            list.add(parentNode);
        }
        return list.get(0);
    }
}
class Node implements Comparable<Node> {
    private final int value;
    private Node leftNode;
    private Node rightNode;

    public Node(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }


    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node node) {
        return this.value - node.value;
    }

    public void preOrder(Node node) {
        System.out.print(node.value + " ");
        if (Objects.nonNull(node.leftNode)) {
            preOrder(node.leftNode);
        }
        if (Objects.nonNull(node.rightNode)) {
            preOrder(node.rightNode);
        }
    }

    public void preOrder() {
        preOrder(this);
    }
}