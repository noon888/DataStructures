package com.atguigu.linkedlist;

/**
 * @Author: Administrator
 * @DATE:2020/5/11 10:28
 */
public class Josepfu {
    public static void main(String[] args) {
        CircularSingleLinkedList circularSingleLinkedList = new CircularSingleLinkedList();
        circularSingleLinkedList.add(5);
//        circularSingleLinkedList.show();
        circularSingleLinkedList.Listing(2, 16);
    }
}

class CircularSingleLinkedList {
    private Boy first;
    public void add (int count) {
        Boy temp = null;
        for (int i=1; i<=count; i++) {
            Boy boy = new Boy();
            if (i == 1) {
                boy.setNum(1);
                first = boy;
                temp = first;
                first.setNext(boy);
            }else {
                boy.setNum(i);
                temp.setNext(boy);
                boy.setNext(first);
                temp = temp.getNext();
            }
        }
    }
    public void show() {
        Boy temp = first;
        if (temp == null) {
            return;
        }
        while (temp.getNext() != first) {
            System.out.println(temp);
            temp = temp.getNext();
        }
        System.out.println(temp);
    }

    /**
     * 出列
     * @param n     从第几个开始数
     * @param step  间隔几个开始出列
     */
    public void Listing(int n, int step) {
        Boy helper = first;
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }
        for(int i=1;i<n;i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        while (helper != first) {
            for (int i=0;i<step-1;i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println(first);
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后剩下的为：" + helper.getNum());
    }
}

class Boy {
    private int num;
    private Boy next;

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "num=" + num +
                '}';
    }
}
