package com.atguigu.tree;

/**
 * @Author: Administrator
 * @DATE:2020/6/23 21:35
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        Emp root = new Emp(1, "宋江");
        Emp emp2 = new Emp(2, "卢俊义");
        Emp emp3 = new Emp(3, "吴用");
        Emp emp4 = new Emp(4, "公孙胜");
        Emp emp5 = new Emp(5, "林冲");
        Emp emp6 = new Emp(6, "关胜");
        root.setLeft(emp2);
        root.setRight(emp3);
        emp2.setRight(emp4);
        emp3.setLeft(emp5);
        emp3.setRight(emp6);
        BinaryTree binaryTree = new BinaryTree(root);
        binaryTree.preOrder();
        System.out.println();
        binaryTree.midOrder();
        System.out.println();
        binaryTree.postOrder();
    }
}
