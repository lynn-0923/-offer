package com.wu.jumpfloor;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Solution {
    public int jumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        //方式一：非递归（推荐）
        int a = 1, b = 2, result = 0;
        for (int i = 2; i < target; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
        //方式二
//        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }
}