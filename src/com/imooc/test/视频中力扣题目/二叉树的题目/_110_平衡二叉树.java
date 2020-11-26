package com.imooc.test.视频中力扣题目.二叉树的题目;

public class _110_平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private int depth(TreeNode x) {
        if (x == null) return 0;
        int leftDepth = depth(x.left);
        if (leftDepth == -1) return -1;
        int rightDepth = depth(x.right);
        if (rightDepth == -1) return -1;
        return Math.abs(leftDepth - rightDepth) < 2 ? Math.max(leftDepth, rightDepth) + 1 : -1;

    }
}
