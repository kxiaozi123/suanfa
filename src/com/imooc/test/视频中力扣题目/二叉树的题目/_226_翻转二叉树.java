package com.imooc.test.视频中力扣题目.二叉树的题目;

import com.imooc.test.二叉搜索树.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 */
public class _226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        /*前序遍历*/
//        if (root == null) return root;
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        invertTree(root.left);
//        invertTree(root.right);
//        return root;
        /*后序遍历*/
//        if (root == null) return root;
//        invertTree(root.left);
//        invertTree(root.right);
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        return root;
        /*中序遍历*/
//        if (root == null) return root;
//        invertTree(root.left);
//        TreeNode temp = root.left;
//        root.left = root.right;
//        root.right = temp;
//        invertTree(root.left);
//        return root;
        /*官网作法*/
//        if(root==null) return root;
//        TreeNode left = invertTree(root.left);
//        TreeNode right = invertTree(root.right);
//        root.left=right;
//        root.right=left;
//        return root;
        /*层序遍历*/
//        if (root == null) return root;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            TreeNode temp = node.left;
//            node.left = node.right;
//            node.right = temp;
//            if (node.left != null) {
//                queue.offer(node.left);
//            }
//
//            if (node.right != null) {
//                queue.offer(node.right);
//            }
//        }
//        return root;
        return null;
    }

}
