package com.wu.rectcover;
/* 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
比如n=3时，2*3的矩形块有3种覆盖方法：
 */
public class Solution {
    public int RectCover(int target) {

        //本质上还是斐波那契数列
        if (target <= 2) {
            return target;
        }
        int a = 1, b = 2, result = 0;
        for (int i = 2; i < target; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}