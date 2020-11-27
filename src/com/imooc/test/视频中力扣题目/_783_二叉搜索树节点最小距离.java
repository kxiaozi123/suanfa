package com.imooc.test.视频中力扣题目;

import com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目.TreeNode;

/**
 * 示例：
 *
 * 输入: root = [4,2,6,1,3,null,null]
 * 输出: 1
 * 解释:
 * 注意，root是树节点对象(TreeNode object)，而不是数组。
 *
 * 给定的树 [4,2,6,1,3,null,null] 可表示为下图:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * 最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
 *
 * 链接：https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes
 *
 * --------一题两做
 * 注意：
 *
 * 二叉树的大小范围在 2 到100。
 * 二叉树总是有效的，每个节点的值都是整数，且不重复。
 * 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 */
public class _783_二叉搜索树节点最小距离 {
    int min = Integer.MAX_VALUE;
    TreeNode prev;
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }
    public  void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev.val);
        }
        prev = root;
        inorder(root.right);
    }
}
