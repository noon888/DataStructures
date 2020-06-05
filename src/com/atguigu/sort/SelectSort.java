package com.atguigu.sort;

import java.util.Arrays;

/**
 * @Author: Administrator
 * @DATE:2020/5/30 17:01
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectSort(int[] arr) {
        int temp;
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
