package com.atguigu.tree;

import java.util.Objects;

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
//        binaryTree.midOrder();
//        System.out.println();
//        binaryTree.postOrder();
//        System.out.println(binaryTree.preSearch(5));
//        System.out.println(binaryTree.midSearch(4));
//        System.out.println(binaryTree.postSearch(5));
        binaryTree.delNode(6);
        binaryTree.preOrder();
    }
}
class BinaryTree {
    private Emp root;

    public BinaryTree(Emp root) {
        this.root = root;
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

    public Emp preSearch (int id) {
        return root.preSearch(id);
    }

    public Emp midSearch(int id) {
        return root.midSearch(id);
    }

    public Emp postSearch(int id) {
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
}

class Emp {
    private final int id;
    private final String name;
    private Emp left;
    private Emp right;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
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

    public void setLeft(Emp left) {
        this.left = left;
    }

    public void setRight(Emp right) {
        this.right = right;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Emp preSearch (int id) {
        System.out.println("统计查找次数，放在id比较前面");
        if (this.id == id) {
            return this;
        }
        Emp emp = null;
        if (this.left != null) {
            emp = this.left.preSearch(id);
        }
        if (Objects.nonNull(emp)) {
            return emp;
        }
        if (this.right != null) {
            return this.right.preSearch(id);
        }
        return null;
    }

    public Emp midSearch(int id) {
        Emp emp = null;
        if (Objects.nonNull(this.left)) {
            emp = this.left.midSearch(id);
        }
        if (Objects.nonNull(emp)) {
            return emp;
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

    public Emp postSearch(int id) {
        Emp emp = null;
        if (Objects.nonNull(this.left)) {
            emp = this.left.postSearch(id);
        }
        if (Objects.nonNull(emp)) {
            return emp;
        }
        if (Objects.nonNull(this.right)) {
            emp = this.right.postSearch(id);
        }
        if (Objects.nonNull(emp)) {
            return emp;
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

