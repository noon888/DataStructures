package com.atguigu.sort;

import java.util.Arrays;

/**
 * @Author: Administrator
 * @DATE:2020/6/8 11:33
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,-1,6,0};
        shellsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellsort(int[] arr) {
        int insertVal, insertIndex;
        for (int gap=arr.length/2; gap>=1; gap/=2) {
            for (int i=gap; i<arr.length; i++) {
                insertVal = arr[i];
                insertIndex = i;
                while (insertIndex - gap >= 0 && arr[insertIndex - gap] > insertVal) {
                    arr[insertIndex] = arr[insertIndex-gap];
                    insertIndex -= gap;
                }
                arr[insertIndex] = insertVal;
            }
        }
    }
}


