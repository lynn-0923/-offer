package com.wu.mirror;

/**
操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return;
        }
        TreeNode tem = root.left;
        root.left = root.right;
        root.right = tem;
        if (root.left != null){
            Mirror(root.left);
        }
        if (root.right != null){
            Mirror(root.right);
        }
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
