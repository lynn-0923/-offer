package com.wu.verify_squence_of_BST;

/**
 * 输入一个非空整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0 || sequence == null) {
            return false;
        }
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int start, int end) {
        if (start >= end) {
            //判断结束
            return true;
        }
        //用于判断，因为后序遍历为左右根
        int val = sequence[end];
        int i;
        for (i = start; i < end; i++) {
            if (sequence[i] > val) {
                break;
            }
        }
        //判断右子树是否有小于val的值
        for (int j = i; j < end; j++) {
            if (sequence[j] < val) {
                return false;
            }
        }
        //递归判断
        if (start == i) {
            return verify(sequence, start, end - 1);
        }
        return verify(sequence, start, i - 1) && verify(sequence, i, end - 1);
    }
}