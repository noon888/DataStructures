package com.atguigu.sort;

import java.util.Arrays;

/**
 * @Author: Administrator
 * @DATE:2020/6/15 15:39
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxCount = ("" + max).length();
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCount = new int[10];
        int digit, index;
        for (int i=0,num=1; i<maxCount; i++,num*=10) {
            for (int j : arr) {
                digit = j / num % 10;
                bucket[digit][bucketElementCount[digit]++] = j;
            }
            index = 0;
            for (int j=0; j<10; j++) {
                if (bucketElementCount[j] != 0) {
                   for (int k=0; k<bucketElementCount[j]; k++) {
                       arr[index++] = bucket[j][k];
                   }
                }
                bucketElementCount[j] = 0;
            }
        }
    }
}
