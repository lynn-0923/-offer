package com.wu.print_matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        //最上一行
        int up = 0;
        //最右边
        int right = matrix[0].length - 1;
        //最下边
        int down = matrix.length - 1;
        //最左边
        int left = 0;

        while (true){
            //遍历最上一行
            for (int col = left; col <= right; col++) {
                list.add(matrix[up][col]);
            }
            up++;
            if (up > down){
                break;
            }
            //遍历最右一行
            for (int row = up; row <= down; row++) {
                list.add(matrix[row][right]);
            }
            right--;
            if (left > right){
                break;
            }
            //遍历最下一行
            for (int col = right; col >= left; col--) {
                list.add(matrix[down][col]);
            }
            down--;
            if (up > down){
                break;
            }
            //遍历最左一行
            for (int row = down; row >= up; row--) {
                list.add(matrix[row][left]);
            }
            left++;
            if (left > right){
                break;
            }
        }
        return list;
    }
}