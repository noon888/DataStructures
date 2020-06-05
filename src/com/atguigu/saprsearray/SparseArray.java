package com.atguigu.saprsearray;

/**
 * @Author: Administrator
 * @DATE:2020/5/5 10:14
 */
public class SparseArray {
    public static void main(String[] args) {
        // 创建普通二维数组
        int[][] nomalArray = new int[11][11];
        nomalArray[1][2] = 1;
        nomalArray[2][3] = 2;
        nomalArray[4][5] = 1;
        // 打印普通二维数组
//		for(int[] array1 : nomalArray) {
//			for(int i : array1) {
//				System.out.printf("%d\t", i);
//			}
//			System.out.println();
//		}
// 		二维数组转稀疏数组
        // 获取二维数组非0个数
        int count = 0;
        for(int[] array1 : nomalArray) {
            for(int i : array1) {
                if (i != 0) {
                    count++;
                }
            }
        }
        // 创建稀疏数组
        int[][] sparseArray = new int[count+1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = count;
        // 数据填充
        count = 0;
        for(int i=0; i<nomalArray.length; i++) {
            for(int j=0; j<nomalArray[i].length; j++) {
                if (nomalArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = nomalArray[i][j];
                }
            }
        }
//      遍历二维数组
//		for(int[] array1 : sparseArray) {
//			for (int i : array1) {
//				System.out.printf("%d\t", i);
//			}
//			System.out.println();
//		}

//      稀疏数组变普通数组
        nomalArray = new int[sparseArray[0][0]][sparseArray[0][1]];
        for(int i=1; i<sparseArray.length; i++) {
            nomalArray[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        // 打印普通二维数组
        for(int[] array1 : nomalArray) {
            for(int i : array1) {
                System.out.printf("%d\t", i);
            }
            System.out.println();
        }
    }
}
