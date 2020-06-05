package com.atguigu.stack;

import java.util.Scanner;

/**
 * @Author: Administrator
 * @DATE:2020/5/13 15:43
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(4);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        String key = "";
        while(loop) {
            System.out.println("show:表示显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:表示人栈");
            System.out.println("pop:表示出栈");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    arrayStack.show();
                    break;
                case "exit":
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入要插入的字符串");
                    arrayStack.pushStack(scanner.next());
                    break;
                case "pop":
                    System.out.println(arrayStack.popStack());
            }
        }
        System.out.println("程序退出");
    }
}

class ArrayStack {
    private final int maxSize;
    private final String[] array;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        array = new String[maxSize];
    }
    public boolean isFull() {
       return top == maxSize - 1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public void pushStack(String value) {
        if (isFull()) {
            System.out.println("栈内已满");
            return;
        }
        top++;
        array[top] = value;
    }
    public String popStack() {
        if (isEmpty()) {
            System.out.println("栈内已空");
            return null;
        }
        String value = array[top];
        top--;
        return value;
    }
    public void show() {
        if (isEmpty()) {
            System.out.println("栈内为空");
            return;
        }
        for (int i=top; i>=0; i--) {
            System.out.println(array[i]);
        }
    }
}
