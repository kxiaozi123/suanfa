package com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目;

/**
 * 例如，
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 * 你应该返回如下子树:
 *
 *       2
 *      / \
 *     1   3
 *
 * 链接：https://leetcode-cn.com/problems/search-in-a-binary-search-tree
 */
public class _700_二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
//        if(root==null||val==root.val) return root;
//        return val<root.val?searchBST(root.left,val):searchBST(root.right,val);
        while (root!=null&&val!=root.val)
            root=val<root.val?root.left:root.right;
        return root;
    }
}
