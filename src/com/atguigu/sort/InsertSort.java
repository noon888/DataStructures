package com.atguigu.sort;

import java.util.Arrays;

/**
 * @Author: Administrator
 * @DATE:2020/6/1 7:10
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        int insertVal, insertIndex;
        for (int i=1;i<arr.length;i++) {
            insertVal = arr[i];
            insertIndex = i;
            while (insertIndex > 0 && insertVal < arr[insertIndex-1]) {
                arr[insertIndex] = arr[insertIndex-1];
                insertIndex--;
            }
            arr[insertIndex] = insertVal;
        }
    }
}
