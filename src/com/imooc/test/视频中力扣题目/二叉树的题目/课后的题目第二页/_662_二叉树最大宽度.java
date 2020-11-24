package com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目第二页;

import com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例3:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * <p>
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 */
public class _662_二叉树最大宽度 {
    static void test1() {
        TreeNode right = new TreeNode(9, null, null);
        TreeNode rootRight = new TreeNode(2, null, right);

        TreeNode right2 = new TreeNode(3, null, null);
        TreeNode left1 = new TreeNode(5, null, null);
        TreeNode rootLeaf = new TreeNode(3, left1, right2);


        TreeNode root = new TreeNode(1, rootLeaf, rootRight);


        System.out.println(widthOfBinaryTree(root));
    }
    /*思路是修改二叉树的编号*/
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.offer(root);
        int sum, ans = 0;
        while (!queue.isEmpty()) {
            sum = queue.size();
            ans = Math.max(ans, queue.getLast().val - queue.getFirst().val + 1);
            while (sum > 0) {
                TreeNode temp = queue.remove();
                if (temp.left != null) {
                    temp.left.val = temp.val * 2 + 1;
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    temp.right.val = temp.val * 2 + 2;
                    queue.offer(temp.right);
                }


                sum--;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        test1();
    }
}
