package com.wu.power;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class Solution {
    public  double power(double base, int exponent) {
        if (base == 0.0) {
            return 0.0;
        } else if (exponent == 0) {
            return 1;
        }
        double value = 1.0;

        int a = exponent > 0 ? exponent : -exponent;

        for (int i = 0; i < a; i++) {
            value = value * base;
        }
        return exponent > 0 ? value : 1 / value;
    }
}