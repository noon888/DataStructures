package com.atguigu.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Administrator
 * @DATE:2020/6/1 7:10
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        List<Integer> integers = insertSort(arr);
        System.out.println(integers.toString());
    }

    private static List<Integer> insertSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        boolean flag;
        for (int i=1; i<arr.length; i++) {
            flag = false;
            for (int j=list.size()-1; j>=0; j--) {
                if (arr[i] > list.get(j)) {
                    flag = true;
                    list.add(j, arr[i]);
                    break;
                }
            }
            if (!flag) {
                list.add(0, arr[i]);
            }
        }
        return list;
    }
}
