package com.atguigu.linkedlist;

import java.util.Stack;

/**
 * @Author: Administrator
 * @DATE:2020/5/5 10:14
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        Hero hero1 = new Hero(1, "宋江", "及时雨");
        Hero hero2 = new Hero(2, "卢俊义", "玉麒麟");
        Hero hero3 = new Hero(3, "吴用", "智多星");
        Hero hero4 = new Hero(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();
//        singleLinkedList.addElement(hero1);
//        singleLinkedList.addElement(hero4);
//        singleLinkedList.addElement(hero3);
//        singleLinkedList.addElement(hero2);
        singleLinkedList.addElementWithNum(hero1);
        singleLinkedList.addElementWithNum(hero4);
        singleLinkedList.addElementWithNum(hero3);
        singleLinkedList.addElementWithNum(hero2);
        singleLinkedList.printLinkedList();
        System.out.println("链表内元素个数为：" + nodeNum(singleLinkedList.getHead()));
        System.out.println("选中元素为：" + findBackNode(singleLinkedList.getHead(), 3));
//        System.out.println("反转后的单链表为：");
//        reverseOrder(singleLinkedList.getHead());
//        singleLinkedList.printLinkedList();
        System.out.println("倒叙遍历：");
        reversePrint(singleLinkedList.getHead());
//        hero1 = new Hero(1, "宋公明", "及时雨1");
//        singleLinkedList.updateLinkedList(hero1);
//        System.out.println("修改后的链表：");
//        singleLinkedList.printLinkedList();
//        singleLinkedList.delLinkedList(1);
//        singleLinkedList.delLinkedList(4);
//        singleLinkedList.delLinkedList(2);
//        singleLinkedList.delLinkedList(3);
//        System.out.println("删除后的链表：");
//        singleLinkedList.printLinkedList();
    }
    // 查找链表中有效节点的个数
    public static int nodeNum(Hero head) {
        Hero temp = head.getNext();
        int num = 0;
        while (temp != null) {
            num ++;
            temp = temp.getNext();
        }
        return num;
    }
    // 查找链表中倒数第num个节点
    public static Hero findBackNode(Hero head, int num) {
        if (num <= 0 || num >nodeNum(head)) {
            return null;
        }
        Hero temp = head.getNext();
        num = nodeNum(head) - num;
        for (int i=0; i<num; i++) {
            temp = temp.getNext();
        }
        return temp;
    }
    // 单链表反转
    public static void reverseOrder(Hero head) {
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return;
        }
        Hero reverseHead = new Hero();
        Hero currentNode = head.getNext();
        Hero next = null;
        while (currentNode != null) {
            next = currentNode.getNext();
            currentNode.setNext(reverseHead.getNext());
            reverseHead.setNext(currentNode);
            currentNode = next;
        }
        head.setNext(reverseHead.getNext());
    }
    // 从尾到头打印单链表
    public static void reversePrint(Hero head) {
        Stack<Hero> stack = new Stack<Hero>();
        Hero temp = head.getNext();
        while (temp != null) {
            stack.push(temp);
            temp = temp.getNext();
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}

class SingleLinkedList {
    private final Hero head = new Hero();

    public Hero getHead() {
        return head;
    }

    // 队尾添加
    public void addElement(Hero hero) {
        Hero temp = head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        temp.setNext(hero);
    }
    // 按照编号添加
    public void addElementWithNum(Hero hero) {
        Hero temp = head;
        while (temp.getNext() != null) {
            if (temp.getNext().getNum() > hero.getNum()) {
                break;
            }else if (temp.getNext().getNum() == hero.getNum()) {
                System.out.println("列表中已经有" + hero.getNum());
                return;
            }
            temp = temp.getNext();
        }
        hero.setNext(temp.getNext());
        temp.setNext(hero);
    }
    // 删除链表
    public void delLinkedList(int num) {
        Hero temp = head;
        boolean flag = false;
        while (temp.getNext() != null) {
            if (temp.getNext().getNum() == num) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setNext(temp.getNext().getNext());
        }else {
            System.out.println("此元素" + num + "不存在");
        }
    }
    // 修改链表
    public void updateLinkedList(Hero hero) {
        Hero temp = head.getNext();
        boolean flag = false;
        while(temp != null) {
            if (temp.getNum() == hero.getNum()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setName(hero.getName());
            temp.setNickName(hero.getNickName());
        } else {
            System.out.println("此编号" + hero.getNum() +"对象不存在");
        }
    }
    // 遍历链表
    public void printLinkedList() {
        Hero temp = head.getNext();
        if (temp == null) {
            System.out.println("链表为空！");
            return;
        }
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }
}

class Hero {
    private int num;
    private String name;
    private String nickName;
    private Hero next;

    public Hero() {
    }

    public Hero(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public Hero getNext() {
        return next;
    }

    public void setNext(Hero next) {
        this.next = next;
    }
}
