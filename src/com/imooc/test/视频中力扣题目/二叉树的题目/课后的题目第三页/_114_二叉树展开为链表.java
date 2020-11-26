package com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目第三页;

import com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * <p>
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 */
public class _114_二叉树展开为链表 {
    public static void flatten(TreeNode root) {
//        List<TreeNode> list=new ArrayList<>();
//        preorderTraversal(root,list);
//        for (int i = 1; i < list.size(); i++) {
//            TreeNode prev = list.get(i - 1),curr=list.get(i);
//            prev.left=null;
//            prev.right=curr;
//
//        }
        /*List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || (!stack.isEmpty())) {
            if (root != null) {
                list.add(root);
                stack.push(root);
                root = root.left;
            } else {
                TreeNode temp = stack.pop();
                root = temp.right;
            }
        }
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;

        }*/


    }

    public static void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode six = new TreeNode(6, null, null);
        TreeNode five = new TreeNode(5, null, six);
        TreeNode four = new TreeNode(4, null, null);
        TreeNode three = new TreeNode(3, null, null);
        TreeNode two = new TreeNode(2, three, four);
        TreeNode root = new TreeNode(1, two, five);
        flatten(root);
        System.out.println(root);
    }
}
