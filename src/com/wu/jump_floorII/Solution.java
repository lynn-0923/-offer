package com.wu.jump_floorII;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution {
    public static int jumpFloorII(int target) {
        if (target <= 2) {
            return target;
        }
        //方式一
//        return (int) Math.pow(2,target - 1);

        //方式二
        int b = 2 ,result = 0;
        for (int i = 2; i < target ; i++) {
            result = 2 * b;
            b = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = jumpFloorII(5);
        System.out.println(i);
    }
}