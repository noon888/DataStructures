package com.atguigu.stack;

/**
 * @Author: Administrator
 * @DATE:2020/5/14 23:24
 */
public class Calculator {
    public static void main(String[] args) {
        String str = "1+70+23*6/3-4";
        ArrayStack2 numStack = new ArrayStack2(12);
        ArrayStack2 symbolStack = new ArrayStack2(12);
        char[] chars = str.toCharArray();
        StringBuilder num = new StringBuilder();
        for (char aChar : chars) {
            if (isSymbol(aChar)) {
                numStack.push(Integer.parseInt(num.toString()));
                num = new StringBuilder();
                if (!symbolStack.isNull() && prority(symbolStack.peek()) >= prority(aChar)) {
                    numStack.push(calc(numStack.pop(), numStack.pop(), symbolStack.pop()));
                }
                symbolStack.push(aChar);
            } else {
                num.append(aChar);
            }
        }
        numStack.push(Integer.parseInt(num.toString()));
        while (!symbolStack.isNull()) {
            numStack.push(calc(numStack.pop(), numStack.pop(), symbolStack.pop()));
        }
        System.out.println(numStack.pop());
    }
    // 判断运算符号优先级
    public static int prority(int s) {
        if ('*' == s || '/' == s) {
            return 1;
        }
        if ('+' == s || '-' == s) {
            return 0;
        }
        return -1;
    }
    // 判断是符号还是数值
    public static boolean isSymbol(int s) {
        return '*' == s || '/' == s || '+' == s || '-' == s;
    }
    // 计算
    public static int calc(int num1, int num2, int symbol) {
        int res = 0;
        switch (symbol) {
            case '+' :
                res = num2 + num1;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num2 * num1;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}
class ArrayStack2 {
    private final int[] array;
    private int top = -1;
    private final int maxLength;
    public ArrayStack2(int maxLength) {
        this.maxLength = maxLength;
        array = new int[maxLength];
    }
    public void push(int s) {
        if (top == maxLength - 1) {
            System.out.println("栈内已满");
            return;
        }
        top++;
        array[top] = s;
    }
    public int pop() {
        if (isNull()) {
            System.out.println("栈内已空");
            return '\n';
        }
        int s = array[top];
        top--;
        return s;
    }
    public int peek() {
        return array[top];
    }
    public void show() {
        if (isNull()){
            System.out.println("栈内为空");
            return;
        }
        for (int i=top; i>=0; i--){
            System.out.println(array[i]);
        }
    }
    public boolean isNull() {
        return top == -1;
    }
}