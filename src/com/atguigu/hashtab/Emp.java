package com.atguigu.hashtab;

/**
 * @Author: Administrator
 * @DATE:2020/6/23 10:30
 */
public class Emp {
    private final int id;
    private final String name;
    private Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Emp getNext() {
        return next;
    }

    public void setNext(Emp next) {
        this.next = next;
    }

    public int getId() {
        return id;
    }
}
