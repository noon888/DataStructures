package com.atguigu.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Administrator
 * @DATE:2020/6/18 18:10
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,8,1000,1000,1000,1000,10,89,1234};
        List<Integer> list = binarySearch(arr, 0, arr.length-1, 1000);
        System.out.println(list);
    }

    private static List<Integer> binarySearch(int[] arr, int left, int right, int value) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) / 2;
        if (arr[mid] > value) {
            return binarySearch(arr, left, mid-1, value);
        } else if (arr[mid] < value) {
            return binarySearch(arr, mid+1, right, value);
        } else {
            List<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == value) {
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == value) {
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
