package com.imooc.test.视频中力扣题目.二叉树的题目;

/**
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * 输出：
 * 1
 * <p>
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * <p>
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 */
public class _530_二叉搜索树的最小绝对差 {
    static int min = Integer.MAX_VALUE;
    static TreeNode prev;

    public static int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        inorder(root.right);
    }


    public static void main(String[] args) {
        TreeNode two = new TreeNode(2, null, null);
        TreeNode three = new TreeNode(3, two, null);
        TreeNode root = new TreeNode(1, null, three);
        System.out.println(getMinimumDifference(root));

    }


}
