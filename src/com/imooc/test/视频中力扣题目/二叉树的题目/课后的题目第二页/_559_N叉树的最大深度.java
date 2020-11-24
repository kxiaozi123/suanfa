package com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目第二页;

import com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目.TreeNode;

import java.util.*;

/**
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * 例如，给定一个3叉树:
 *
 *          1
 *       3  2  4
 *    5   6
 *
 *
 *
 *
 *
 * 我们应返回其最大深度，3。
 *
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 */
public class _559_N叉树的最大深度 {
    /*递归作法*/
   /* public int maxDepth(Node root) {
        return height(root);
    }
    private int height(Node root) {
        if (root == null) return 0;
        if(root.children.isEmpty()) return 1;
        int max=0;
        for (Node child : root.children) {
          max=Math.max(max,height(child));
        }
        return max+1;
    }*/
    /*非递归作法*/
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        int height = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            level--;
            List<Node> children = node.children;
            if(!children.isEmpty())
            {
                for (Node child : children) {
                    queue.offer(child);
                }
            }
            if (level == 0) {
                level = queue.size();
                height++;
            }

        }
        return height;
    }

}
