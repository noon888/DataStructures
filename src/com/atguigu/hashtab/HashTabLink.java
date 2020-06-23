package com.atguigu.hashtab;

/**
 * @Author: Administrator
 * @DATE:2020/6/23 10:25
 */
public class HashTabLink {
    private Emp head;

    public void addEmp (Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(emp);
    }
    public void delEmpById(int id) {
        if (head != null) {
            if (head.getId() == id) {
                head = null;
                return;
            }
            Emp temp = head;
            while (temp.getNext() != null) {
                if (temp.getNext().getId() == id) {
                    temp.setNext(temp.getNext().getNext());
                    return;
                }
                temp = temp.getNext();
            }
        }
        System.out.println("没有要删除的元素");
    }
    public Emp findEmpById (int id) {
        Emp temp = head;
        while (temp != null) {
            if (temp.getId() == id) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }
    public void list() {
        if (head == null) {
            System.out.print("没有元素");
        }
        Emp temp = head;
        while (temp != null) {
            System.out.print("==> " + temp + "\t");
            temp = temp.getNext();
        }
    }
}
