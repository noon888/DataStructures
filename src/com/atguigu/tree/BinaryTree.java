package com.atguigu.tree;

import java.util.Objects;

/**
 * @Author: Administrator
 * @DATE:2020/6/24 10:47
 */
public class BinaryTree {
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
}
