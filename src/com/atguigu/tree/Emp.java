package com.atguigu.tree;

import java.util.Objects;

/**
 * @Author: Administrator
 * @DATE:2020/6/24 10:12
 */
public class Emp {
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

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
