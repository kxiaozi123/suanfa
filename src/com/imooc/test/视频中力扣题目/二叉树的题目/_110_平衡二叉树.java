package com.imooc.test.视频中力扣题目.二叉树的题目;

/**
 * 示例 1：
 *     3
 *   9  20
 *     15  7
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：root = []
 * 输出：true
 *
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 */
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
