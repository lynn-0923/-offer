package com.wu.fibonacci;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 */
public class Solution {
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 ){
            return 1;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        int i;
        for (i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[i - 1];
    }

    public static void main(String[] args) {
        int fibonacci = fibonacci(1);
        System.out.println(fibonacci);
    }
}