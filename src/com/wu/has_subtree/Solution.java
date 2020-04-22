package com.wu.has_subtree;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
/*
        1.首先需要判断A,B的根节点是否一样。
        2.如果不一样，判断A的左孩子和B的根节点是否一样，同理可判断A的右孩子和B的根节点是否一样。依次找下去
        如果上述情况都不满足则说明不包含
            1.如果找到了A中有值和B中的根节点相同，则比较左右子树是否相同。
            2.如果B为空了，则说明包含
            3.如果A为空了，则说明不包含
 */
public class Solution {
    //遍历大树
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        //判断两个子树节点的值是否相等
        if (root1.val == root2.val){//相等
            if (judgeSub(root1,root2)) {
                return true;//接着判断
            }
        }
        //如果不等，则遍历大树的左右子树
        return HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    private boolean judgeSub(TreeNode root, TreeNode sub) {
        //如果子结构为null则遍历完毕,包含
        if (sub == null){
            return true;
        }
        //如果父结构为null则遍历完毕,不包含
        if (root == null){
            return false;
        }
        //判断是否相等
        if (root.val == sub.val){
            //判断左右子树
            return judgeSub(root.left,sub.left) && judgeSub(root.right,sub.right);
        }
        return false;
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
