package com.atguigu.recursion;

/**
 * @Author: Administrator
 * @DATE:2020/5/28 22:00
 */
public class Queue8 {
    private static final int MAX = 8;
    private static final int[] array = new int[MAX];
    private static int count = 0;
    public static void main(String[] args) {
        check(0);
        System.out.println(count);
    }

    private static void check(int n) {
        if (n == MAX) {
            count++;
            show();
            return;
        }
        for (int i=0; i<MAX; i++) {
            array[n] = i;
            if (judge(n)) {
               check(n + 1);
            }
        }
    }

    private static boolean judge(int n) {
        for (int i=0; i<n; i++) {
            if (array[i]  == array[n] || Math.abs(n - i) == Math.abs(array[i] - array[n])) {
                return false;
            }
        }
        return true;
    }

    private static void show() {
        for (int i : array) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }
}
