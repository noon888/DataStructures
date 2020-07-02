package com.atguigu.tree.ThreadedBinaryTree;

import java.util.Objects;

/**
 * @Author: Administrator
 * @DATE:2020/6/26 14:12
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "卢俊义");
        HeroNode node3 = new HeroNode(3, "吴用");
        HeroNode node4 = new HeroNode(4, "公孙胜");
        HeroNode node5 = new HeroNode(5, "林冲");
        HeroNode node6 = new HeroNode(6, "武松");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(root);
        threadedBinaryTree.threadedBinaryTree();
//        System.out.println(node5.getLeft());
//        System.out.println(node5.getRight());
        threadedBinaryTree.threadBinaryTreeOrder();
    }
}

class ThreadedBinaryTree {
    private HeroNode root;
    private HeroNode pre;

    public ThreadedBinaryTree(HeroNode root) {
        this.root = root;
    }

    public void threadedBinaryTree() {
        threadedBinaryTree(this.root);
    }

    private void threadedBinaryTree(HeroNode root) {
        if (Objects.isNull(root)) {
            return;
        }
        threadedBinaryTree(root.getLeft());
        if (Objects.isNull(root.getLeft())) {
            root.setLeft(pre);
            root.setLeftType(1);
        }
        if (Objects.nonNull(pre) && Objects.isNull(pre.getRight())) {
            pre.setRight(root);
            pre.setRightType(1);
        }
        pre = root;
        threadedBinaryTree(root.getRight());
    }

    public void preOrder () {
        if (Objects.nonNull(root)) {
            root.preOrder();
        }
    }

    public void midOrder () {
        if (Objects.nonNull(root)) {
            root.midOrder();
        }
    }

    public void postOrder () {
        if (Objects.nonNull(root)) {
            root.postOrder();
        }
    }

    public HeroNode preSearch (int id) {
        return root.preSearch(id);
    }

    public HeroNode midSearch(int id) {
        return root.midSearch(id);
    }

    public HeroNode postSearch(int id) {
        return root.postSearch(id);
    }

    public void delNode(int id) {
        if (Objects.nonNull(root)) {
            if (root.getId() == id) {
                root = null;
            } else {
                root.delNode(id);
            }
        } else {
            System.out.println("null tree");
        }
    }

    public void threadBinaryTreeOrder() {
        HeroNode node = root;
        while (Objects.nonNull(node)) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }
}

class HeroNode {
    private final int id;
    private final String name;
    private HeroNode left;
    private HeroNode right;
    // leftType == 0表示指向的是左子树，== 1表示指向的是前驱节点
    // rightType == 0表示指向的是右子树，== 1表示指向的是后继节点
    private int leftType;
    private int rightType;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode getLeft() {
        return left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void preOrder () {
        System.out.print(this.id + " ");
        if (Objects.nonNull(this.left)) {
            this.left.preOrder();
        }
        if (Objects.nonNull(this.right)) {
            this.right.preOrder();
        }
    }

    public void midOrder () {
        if (Objects.nonNull(this.left)) {
            this.left.midOrder();
        }
        System.out.print(this.id + " ");
        if (Objects.nonNull(this.right)) {
            this.right.midOrder();
        }
    }

    public void postOrder () {
        if (Objects.nonNull(this.left)) {
            this.left.postOrder();
        }
        if (Objects.nonNull(this.right)) {
            this.right.postOrder();
        }
        System.out.print(this.id + " ");
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public HeroNode preSearch (int id) {
        System.out.println("统计查找次数，放在id比较前面");
        if (this.id == id) {
            return this;
        }
        HeroNode HeroNode = null;
        if (this.left != null) {
            HeroNode = this.left.preSearch(id);
        }
        if (Objects.nonNull(HeroNode)) {
            return HeroNode;
        }
        if (this.right != null) {
            return this.right.preSearch(id);
        }
        return null;
    }

    public HeroNode midSearch(int id) {
        HeroNode heroNode = null;
        if (Objects.nonNull(this.left)) {
            heroNode = this.left.midSearch(id);
        }
        if (Objects.nonNull(heroNode)) {
            return heroNode;
        }
        System.out.println("统计查找次数，放在id比较前面");
        if (this.id == id) {
            return this;
        }
        if (Objects.nonNull(this.right)) {
            return this.right.midSearch(id);
        }
        return null;
    }

    public HeroNode postSearch(int id) {
        HeroNode HeroNode = null;
        if (Objects.nonNull(this.left)) {
            HeroNode = this.left.postSearch(id);
        }
        if (Objects.nonNull(HeroNode)) {
            return HeroNode;
        }
        if (Objects.nonNull(this.right)) {
            HeroNode = this.right.postSearch(id);
        }
        if (Objects.nonNull(HeroNode)) {
            return HeroNode;
        }
        System.out.println("统计查找次数，放在id比较前面");
        if (this.id == id) {
            return this;
        }
        return null;
    }

    public void delNode(int id) {
        if (Objects.nonNull(this.left)) {
            if (this.left.getId() == id) {
                this.left = null;
                return;
            }
            this.left.delNode(id);
        }
        if (Objects.nonNull(this.right)) {
            if (this.right.getId() == id) {
                this.right = null;
                return;
            }
            this.right.delNode(id);
        }
    }
}
