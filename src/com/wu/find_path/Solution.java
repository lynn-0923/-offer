package com.wu.find_path;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */

public class Solution {

    private ArrayList<ArrayList<Integer>> resultList = new ArrayList();
    private ArrayList<Integer> list = new ArrayList();
    public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return resultList;
        }
        list.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {
            resultList.add(new ArrayList<>(list));
        }
        if (target > root.val) {
            if (root.left != null) {
                FindPath(root.left, target - root.val);
                //如果遍历到最后还没有，则进行回溯，类似于深度优先遍历
                list.remove(list.size() - 1);
            }
            if (root.right != null) {
                FindPath(root.right, target - root.val);
                list.remove(list.size() - 1);
            }
        }
        return resultList;
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
