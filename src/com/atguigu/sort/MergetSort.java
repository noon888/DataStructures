package com.atguigu.sort;

import java.util.Arrays;

/**
 * @Author: Administrator
 * @DATE:2020/6/11 11:53
 */
public class MergetSort {
    public static void main(String[] args) {
        int[] arr = {8,4,5,7,1,3,9,6,2};
        mergetSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergetSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergetSort(arr, left, mid);
            mergetSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int ll = left, rl = mid + 1, t = 0;
        while (ll <= mid && rl <= right) {
            if (arr[ll] <= arr[rl]) {
                temp[t] = arr[ll];
                ll++; t++;
            }else {
                temp[t] = arr[rl];
                rl++; t++;
            }
        }
        while (ll <= mid) {
            temp[t] = arr[ll];
            ll++; t++;
        }
        while (rl <= right) {
            temp[t] = arr[rl];
            rl++; t++;
        }
        for (int i=left,j=0; i<=right; i++,j++) {
            arr[i] = temp[j];
        }
    }

}
