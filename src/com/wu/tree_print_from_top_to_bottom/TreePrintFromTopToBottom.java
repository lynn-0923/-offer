package com.wu.tree_print_from_top_to_bottom;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lynn
 * @date 2020/3/20 - 13:44
 */
//从上往下打印出二叉树的每个节点，同层节点从左至右打印。
public class TreePrintFromTopToBottom {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node =root;
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right!= null) {
                queue.add(node.right);
            }
        }
        return list;
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