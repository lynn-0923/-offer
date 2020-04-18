package com.wu.number_of_1;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution {
    public static int numberOf1(int n) {

        //方式一，利用api
//        String s = Integer.toBinaryString(n);
//        String[] split = s.split("");
//        int count = 0;
//        for (int i = 0; i < split.length; i++) {
//            if ("1".equals(split[i])){
//                count++;
//            }
//        }

//        方式二
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int i = numberOf1(-5);
        System.out.println(i);
    }
}