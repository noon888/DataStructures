package com.atguigu.binarysorttree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author: Administrator
 * @DATE:2020/7/16 15:55
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9,13};
        BinarySortTree binarySortTree = binarySortTree(arr);
        binarySortTree.delNode(3);
        binarySortTree.midOrder();
    }

    private static BinarySortTree binarySortTree(int[] arr) {
        List<Node> list = new ArrayList<>();
        for (int value : arr) {
            list.add(new Node(value));
        }
        BinarySortTree binarySortTree = new BinarySortTree();
        for (Node node : list) {
            binarySortTree.addNode(node);
        }
        return binarySortTree;
    }
}

class BinarySortTree {
    private Node root;

    public Node searchParent(int value) {
        if (Objects.nonNull(root)) {
            return root.searchParent(value);
        }
        return null;
    }

    public Node searchTarget(int value) {
        if (Objects.nonNull(root)) {
            return root.searchTarget(value);
        }
        return null;
    }
    public void delNode(int value) {
        // 根节点为空
        if (Objects.isNull(root)) {
            return;
        }
         Node parentNode = searchParent(value);
         Node targetNode = searchTarget(value);
         // 没有对应的目标节点
         if (Objects.isNull(targetNode)) {
             return;
         }
         // 删除叶子节点
         if (Objects.isNull(targetNode.getLeft()) && Objects.isNull(targetNode.getRight())) {
             // 只有一个目标根节点
             if (Objects.isNull(parentNode)) {
                 root = null;
                 return;
             }
             if (Objects.nonNull(parentNode.getLeft()) && parentNode.getLeft().getValue() == value) {
                 parentNode.setLeft(null);
             }
             if (Objects.nonNull(parentNode.getRight()) && parentNode.getRight().getValue() == value) {
                 parentNode.setRight(null);
             }
             return;
         }
         // 删除双子树节点
         if (Objects.nonNull(targetNode.getLeft()) && Objects.nonNull(targetNode.getRight())) {
             Node tempNode = targetNode.getRight();
             while (Objects.nonNull(tempNode.getLeft())) {
                 tempNode = tempNode.getLeft();
             }
             // delNode(int value)递归调用不会再次运行删除双子节点代码块
             delNode(tempNode.getValue());
             targetNode.setValue(tempNode.getValue());
             return;
         }
         // 删除单子树节点
         if (Objects.isNull(targetNode.getLeft())) {
             if (Objects.isNull(parentNode)) {
                 root = targetNode.getRight();
             } else {
                 if (Objects.nonNull(parentNode.getLeft()) && parentNode.getLeft().getValue() == value) {
                     parentNode.setLeft(targetNode.getRight());
                 }
                 if (Objects.nonNull(parentNode.getRight()) && parentNode.getRight().getValue() == value) {
                     parentNode.setRight(targetNode.getRight());
                 }
             }
         }
         if (Objects.isNull(targetNode.getRight())) {
             if (Objects.isNull(parentNode)) {
                 root = targetNode.getLeft();
             } else {
                 if (Objects.nonNull(parentNode.getLeft()) && parentNode.getLeft().getValue() == value) {
                     parentNode.setLeft(targetNode.getLeft());
                 }
                 if (Objects.nonNull(parentNode.getRight()) && parentNode.getRight().getValue() == value) {
                     parentNode.setRight(targetNode.getLeft());
                 }
             }
         }
     }

    public void addNode(Node node) {
        if (Objects.isNull(root)) {
            root = node;
        } else {
            root.add(node);
        }
    }
    public void midOrder() {
        if (Objects.nonNull(root)) {
            root.midOrder();
        }
    }
}

class Node {
    private int value;
    private Node left;
    private Node right;

    public Node searchTarget(int value) {
        if (this.getValue() == value) {
            return this;
        }
        if (this.getValue() > value && Objects.nonNull(this.getLeft())) {
            return this.getLeft().searchTarget(value);
        }
        if (this.getValue() < value && Objects.nonNull(this.getRight())) {
            return this.getRight().searchTarget(value);
        }
        return null;
    }

    public Node searchParent(int value) {
        if (this.getValue() == value) {
            return null;
        }
        if (Objects.nonNull(this.getLeft())) {
            if (this.getLeft().getValue() == value) {
                return this;
            }
            if (this.getValue() > value) {
                return this.getLeft().searchParent(value);
            }
        }
        if (Objects.nonNull(this.getRight())) {
            if (this.getRight().getValue() == value) {
                return this;
            }
            if (this.getValue() < value) {
                return this.getRight().searchParent(value);
            }
        }
        return null;
    }

    public void add(Node node) {
        if (this.getValue() > node.getValue()) {
            if (Objects.isNull(this.getLeft())) {
                this.setLeft(node);
            } else {
                this.getLeft().add(node);
            }
        } else {
            if (Objects.isNull(this.getRight())) {
                this.setRight(node);
            } else {
                this.getRight().add(node);
            }
        }
    }

    public void midOrder() {
        if (Objects.nonNull(this.getLeft())) {
            this.getLeft().midOrder();
        }
        System.out.println(this);
        if (Objects.nonNull(this.getRight())) {
            this.getRight().midOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
}
