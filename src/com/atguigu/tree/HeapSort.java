package com.atguigu.tree;

import java.util.Arrays;

/**
 * @Author: Administrator
 * @DATE:2020/7/2 14:17
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        // 实现大顶堆
        for (int i=arr.length/2-1;i>=0;i--) {
            adjustHeap(arr, i, arr.length);
        }
        // 将每次大顶堆顶上的最大值放在最后
        for (int j=arr.length-1; j>0; j--) {
            swap(arr, 0, j);
            adjustHeap(arr,0, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j=i*2+1;j<length;j=j*2+1) {
            if (j+1 < length && arr[j] < arr[j+1]) {
                j++;
            }
            if (temp < arr[j]) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
