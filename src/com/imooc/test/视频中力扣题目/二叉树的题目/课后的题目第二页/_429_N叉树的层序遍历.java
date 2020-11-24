package com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目第二页;

import com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目.TreeNode2;

import java.util.*;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个3叉树:
 *
 *      1
 *   3  2  4
 * 5  6
 *
 *
 *
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _429_N叉树的层序遍历 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                List<Node> children = node.children;
                if(!children.isEmpty())
                {
                    for (Node child : children) {
                        queue.offer(child);
                    }
                }
            }
            result.add(level);
        }
        return result;
    }
}
