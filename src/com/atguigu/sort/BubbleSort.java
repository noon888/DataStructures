package com.atguigu.sort;

import java.util.Arrays;

/**
 * @Author: Administrator
 * @DATE:2020/5/30 14:57
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, 20};
        int count = bubbleSort(arr);
        System.out.print(Arrays.toString(arr));
        System.out.println();
        System.out.println(count);
    }

    private static int bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        int count = 0;
        for (int i=0; i<arr.length-1; i++) {
            flag = true;
            count ++;
            for (int j=0; j< arr.length-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    flag = false;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if (flag) {
                break;
            }
        }
        return count;
    }
}
