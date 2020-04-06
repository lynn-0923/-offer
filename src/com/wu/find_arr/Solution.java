package com.wu.find_arr;

import java.util.Arrays;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author lynn
 * @date 2020/4/6 - 14:37
 */
public class Solution {
    public static boolean find(int target, int[][] array) {

        //方式一
//        int find = -1;
//        boolean flag = false;
//        for (int i = 0; i < array.length; i++) {
//            int[] arr = array[i];
//            find = Arrays.binarySearch(arr, target);
//            if (find >= 0) {
//                if (array[i][find] == target) {
//                    flag = true;
//                    break;
//                }
//            }
//        }
//        if (flag) {
//            return true;
//        } else {
//            return false;
//        }

        int m, n, x, y;
        m = array.length;//行数
        n = array[0].length;//列数
        x = m - 1;
        y = 0;//坐标定在左下角
        while (x >= 0 && y <= n - 1) {
            if (target < array[x][y]) {
                x--;//遇小上移
            } else if (target > array[x][y]) {
                y++;//遇大右移
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};

        boolean b = find(9, arr);
        System.out.println(b);
    }
}
