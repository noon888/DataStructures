package com.atguigu.search;

/**
 * @Author: Administrator
 * @DATE:2020/6/20 18:35
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[99];
        for (int i=0; i<99; i++) {
            arr[i] = i + 1;
        }
        int index = insertValueSearch(arr, 0, arr.length-1, 1);
        System.out.println(index);
    }

    private static int insertValueSearch(int[] arr, int left, int right, int value) {
        if (left > right || value > arr[right] || value < arr[left]) {
            return -1;
        }
        int mid = left + (right - left) * (value - arr[left]) / (arr[right] - arr[left]);
        if (value > arr[mid]) {
            return insertValueSearch(arr, mid+1, right, value);
        } else if (value < arr[mid]) {
            return insertValueSearch(arr, mid-1, right, value);
        } else {
            return mid;
        }
    }
}
