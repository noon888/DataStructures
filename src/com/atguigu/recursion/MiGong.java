package com.atguigu.recursion;

/**
 * @Author: Administrator
 * @DATE:2020/5/21 18:19
 */
public class MiGong {
    public static void main(String[] args) {
        int[][] array = new int[8][7];
        fill(array);
        findPath(array, 1, 1);
        show(array);
    }

    private static boolean findPath(int[][] array, int i, int j) {
        if (array[6][5] == 2) {
            return true;
        }
        if (array[i][j] == 0) {
            array[i][j] = 2;
            if (findPath(array, i+1, j)) {
                return true;
            }
            if (findPath(array, i, j+1)) {
                return true;
            }
            if (findPath(array, i-1, j)) {
                return true;
            }
            if (findPath(array, i, j - 1)) {
                return true;
            }
            array[i][j] = 3;
            return false;
        }
        return false;
    }

    private static void fill(int[][] array) {
        for (int i=0; i<array[0].length; i++) {
            array[0][i] = 1;
            array[array.length - 1][i] = 1;
        }
        for (int j=0; j<array.length; j++) {
            array[j][0] = 1;
            array[j][array[0].length - 1] = 1;
        }
        array[3][1] = 1;
        array[3][2] = 1;
//        array[1][2] = 1;
//        array[2][2] = 1;
    }

    private static void show(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
