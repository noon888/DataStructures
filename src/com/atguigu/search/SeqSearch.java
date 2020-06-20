package com.atguigu.search;

/**
 * @Author: Administrator
 * @DATE:2020/6/18 17:45
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1,9,11,-1,34,89};
        int index = seqSearch(arr, -2);
        System.out.println(index);
    }

    private static int seqSearch(int[] arr, int value) {
        for (int i=0; i< arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
