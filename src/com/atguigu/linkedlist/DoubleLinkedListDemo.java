package com.atguigu.linkedlist;

/**
 * @Author: Administrator
 * @DATE:2020/5/9 15:45
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addElement(hero1);
        doubleLinkedList.addElement(hero4);
        doubleLinkedList.addElement(hero2);
        doubleLinkedList.addElement(hero3);
//        doubleLinkedList.addElementWithNo(hero1);
//        doubleLinkedList.addElementWithNo(hero4);
//        doubleLinkedList.addElementWithNo(hero2);
//        doubleLinkedList.addElementWithNo(hero3);
        doubleLinkedList.findElement();
        System.out.println("更改后。。。");
        HeroNode hero5 = new HeroNode(4, "公孙胜", "入云龙");
        doubleLinkedList.updateElement(hero5);
        doubleLinkedList.findElement();
        System.out.println("删除后。。。");
        doubleLinkedList.delElement(4);
        doubleLinkedList.findElement();
    }
}
class DoubleLinkedList {
    private final HeroNode head = new HeroNode();

    public HeroNode getHead() {
        return head;
    }
    // 链表尾部添加
    public void addElement(HeroNode heroNode) {
        HeroNode temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(heroNode);
        heroNode.setPre(temp);
    }
    // 按次序添加
    public void addElementWithNo(HeroNode heroNode) {
        HeroNode temp = head;
        while(temp.getNext() != null) {
            if (temp.getNext().getNo() > heroNode.getNo()) {
                break;
            } else if (temp.getNext().getNo() == heroNode.getNo()) {
                System.out.println("该序号" + heroNode.getNo() + "已存在");
                break;
            }
            temp = temp.getNext();
        }
        if (temp.getNext() != null) {
            temp.getNext().setPre(heroNode);
        }
        heroNode.setNext(temp.getNext());
        heroNode.setPre(temp);
        temp.setNext(heroNode);
    }
    // 删除节点
    public void delElement(int num) {
        HeroNode temp = head.getNext();
        boolean flag = false;
        while (temp != null) {
            if (temp.getNo() == num) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.getPre().setNext(temp.getNext());
            if (temp.getNext() != null) {
                temp.getNext().setPre(temp.getPre());
            }
        }else {
            System.out.println("该序号" + "num" + "不存在");
        }
    }
    // 修改节点
    public void updateElement(HeroNode heroNode) {
        HeroNode temp = head.getNext();
        boolean flag = false;
        while(temp != null) {
            if (temp.getNo() == heroNode.getNo()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setName(heroNode.getName());
            temp.setNickName(heroNode.getNickName());
        } else {
            System.out.println("该节点" + heroNode.getNo() + "不存在");
        }
    }
    // 查找节点
    public void findElement() {
        HeroNode temp = head.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}
class HeroNode {
    private int no;
    private String name;
    private String nickName;
    private HeroNode next;
    private HeroNode pre;

    public HeroNode() {
    }

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    public void setPre(HeroNode pre) {
        this.pre = pre;
    }

    public HeroNode getNext() {
        return next;
    }

    public HeroNode getPre() {
        return pre;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
