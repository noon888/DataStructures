package com.atguigu.queue;

import java.util.Scanner;

/**
 * @Author: Administrator
 * @DATE:2020/5/5 10:14
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 测试一把
        System.out.println("测试数组模拟环形队列的案例");
        // 创建一个环形队列
        CircleArray cricleArray = new CircleArray(4);
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头数据");

            switch(scanner.next().charAt(0)){
                case 's':
                    try {
                        cricleArray.ergodic();
                    }catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    System.out.println("程序退出");
                    return;
                case 'a':
                    System.out.println("请输入一个整数");
                    int value = scanner.nextInt();
                    try{
                        cricleArray.addElement(value);
                    }catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try {
                        System.out.println(cricleArray.getElement());
                    }catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println(cricleArray.findElement());
                    }catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}
class CircleArray {
    private final int[] array;
    private final int maxLength;
    private int front;
    private int rear;
    public CircleArray(int maxLength) {
        this.maxLength = maxLength;
        array = new int[maxLength];
    }
    public boolean isFull() {
        return (rear + 1) % maxLength == front;
    }
    public boolean isEmpty() {
        return rear == front;
    }
    public void addElement(int num) {
        if (isFull()) {
            throw new RuntimeException("队列已满，无法添加");
        }
        array[rear] = num;
        rear = (rear + 1) % maxLength;
    }
    public int getElement() {
        if (isEmpty()) {
            throw new RuntimeException("此队列为空");
        }
        int temp = array[front];
        front = (front + 1) % maxLength;
        return temp;
    }
    // 有效元素个数
    public int effective() {
        return (rear + maxLength - front) % maxLength;
    }
    // 遍历队列中的有效元素
    public void ergodic() {
        if (isEmpty()) {
            throw new RuntimeException("此队列为空");
        }
        for (int i=front; i<front+effective(); i++) {
            System.out.printf("array[%d] = %d\n", i % maxLength, array[i % maxLength]);
        }
    }
    // 查看首个元素
    public int findElement() {
        if (isEmpty()) {
            throw new RuntimeException("此队列为空");
        }
        return array[front];
    }
}

