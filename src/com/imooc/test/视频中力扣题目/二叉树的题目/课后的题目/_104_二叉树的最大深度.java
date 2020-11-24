package com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目;

import com.imooc.test.二叉搜索树.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明:叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度3 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 */
public class _104_二叉树的最大深度 {
    /*递归写法*/
    public int maxDepth(TreeNode root) {
        return height(root);
    }
    private int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    /*非递归写法*/
   /* public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        int height = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            level--;
            if (node.left != null) {
               queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (level == 0) {
                level = queue.size();
                height++;
            }

        }
        return height;

    }*/

    public static void main(String[] args) {

    }
}
