package com.atguigu.search;

import java.util.Arrays;

/**
 * @Author: Administrator
 * @DATE:2020/6/20 19:29
 */
public class FibonacciSearch {
    public static final int MAX_LENGTH = 20;
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
        int index = fibonacciSearch(arr, 1234);
        System.out.println(index);
    }

    private static int fibonacciSearch(int[] arr, int value) {
        int low = 0, high = arr.length - 1, mid = 0, k = 0;
        int[] f = fib();
        while (high > f[k]-1) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i=high+1; i<temp.length; i++) {
            temp[i] = arr[high];
        }
        while (low <= high) {
            mid = low + f[k-1] - 1;
            if (value < temp[mid]) {
                high = mid - 1;
                k--;
            }
            if (value > temp[mid]) {
                low = mid + 1;
                k -=2;
            }
            if (value == temp[mid] && mid < high) {
                return mid;
            }
            if (value == temp[mid] && mid >= high) {
                return high;
            }
        }
        return -1;
    }

    private static int[] fib() {
        int[] f = new int[MAX_LENGTH];
        f[0] = 1;
        f[1] = 1;
        for (int i=2; i<f.length; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f;
    }
}
