package com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class _94_二叉树的中序遍历 {
    /*递归作法*/
    /*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        return list;
    }
    public void inorder(TreeNode root, List<Integer> res){
        if(root==null) return;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }*/
    /*非递归作法*/
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while (root!=null||(!stack.isEmpty()))
        {
            if(root!=null)
            {
                stack.push(root);
                root=root.left;
            }
            else {
                TreeNode temp = stack.pop();
                list.add(temp.val);
                root=temp.right;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        TreeNode left = new TreeNode(6, null, null);
        //TreeNode left = new TreeNode(5, null, null);
        TreeNode rootRight = new TreeNode(3, left, null);

        TreeNode right2 = new TreeNode(5, null, null);
        TreeNode left1 = new TreeNode(4, null, null);
        TreeNode rootLeaf = new TreeNode(2, left1, right2);


        TreeNode root = new TreeNode(1, rootLeaf, rootRight);
        System.out.println(inorderTraversal(root));

    }
}
