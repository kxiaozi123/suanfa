package com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class _144_二叉树的前序遍历 {
    /*递归作法*/
    /*public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        preorder(root,list);
        return list;

    }
    public void preorder(TreeNode root, List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }*/
    /*非递归作法*/
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while (root!=null||(!stack.isEmpty()))
        {
            if(root!=null)
            {
                list.add(root.val);
                stack.push(root);
                root=root.left;
            }
            else {
                TreeNode temp = stack.pop();
                root=temp.right;
            }
        }
        return list;
    }


    public static void main(String[] args) {
        TreeNode right = new TreeNode(6, null, null);
        TreeNode left = new TreeNode(5, null, null);
        TreeNode rootRight = new TreeNode(3, left, right);

        TreeNode right2 = new TreeNode(4, null, null);
        TreeNode rootLeaf = new TreeNode(2, null, right2);


        TreeNode root = new TreeNode(1, rootLeaf, rootRight);
        System.out.println(preorderTraversal(root));

    }
}
