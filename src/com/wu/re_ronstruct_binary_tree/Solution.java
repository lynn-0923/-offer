package com.wu.re_ronstruct_binary_tree;


import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author lynn
 * @date 2020/4/15 - 20:35
 */
public class Solution {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        int rootVal = pre[0];
        TreeNode tree = new TreeNode(rootVal);

        int index = 0;
        for (int i = 0; i < in.length; i++) {
            if (rootVal == in[i]) {
                index = i;
                break;
            }
        }
        tree.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(in, 0, index));
        tree.right = reConstructBinaryTree(Arrays.copyOfRange(pre, index + 1, pre.length), Arrays.copyOfRange(in, index + 1, in.length));
        return tree;
    }


    public static void main(String[] args) {
        //测试
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        treeNode.preOrder();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this.val);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}