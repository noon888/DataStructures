package com.atguigu.hashtab;

import java.util.Objects;

/**
 * @Author: Administrator
 * @DATE:2020/6/23 10:20
 */
public class HashTab {
    private final HashTabLink[] hashTabLinks;

    public HashTab(int size) {
        hashTabLinks = new HashTabLink[size];
        for (int i=0; i< hashTabLinks.length; i++) {
            hashTabLinks[i] = new HashTabLink();
        }
    }

    private int hash (int id) {
        return id % hashTabLinks.length;
    }
    public void addEmp (Emp emp) {
        if (Objects.nonNull(emp)) {
            hashTabLinks[hash(emp.getId())].addEmp(emp);
        }
    }
    public void delEmp (int id) {
        hashTabLinks[hash(id)].delEmpById(id);
    }
    public void findEmpByid (int id) {
        Emp emp = hashTabLinks[hash(id)].findEmpById(id);
        if (Objects.isNull(emp)) {
            System.out.println("没有找到id为" + id + "的元素");
        } else {
            System.out.println("在第" + (hash(id) + 1) + "条链表中找到该元素");
        }
    }
    public void list() {
        for (int i=0; i<hashTabLinks.length; i++) {
            System.out.print("第" + (i + 1) + "行:" + "\t");
            hashTabLinks[i].list();
            System.out.println();
        }
    }
}
