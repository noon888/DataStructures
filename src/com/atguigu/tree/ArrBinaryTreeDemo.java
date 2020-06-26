package com.atguigu.tree;

import java.util.Objects;

/**
 * @Author: Administrator
 * @DATE:2020/6/25 20:43
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}
class ArrBinaryTree {
    private final int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        if (Objects.isNull(arr) || arr.length == 0) {
            System.out.println("arr is null");
        }
        preOrder(0);
    }

    private void preOrder(int index) {
        System.out.print(arr[index] + " ");
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}
