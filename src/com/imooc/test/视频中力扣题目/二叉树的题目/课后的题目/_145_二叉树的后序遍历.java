package com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class _145_二叉树的后序遍历 {
    /*递归作法*/
    /*public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        postorder(root,list);
        return list;
    }
    public void postorder(TreeNode root, List<Integer> res){
        if(root==null) return;
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }*/
    /*非递归作法*/
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        while (root!=null||(!stack.isEmpty()))
        {
            if(root!=null)
            {
                stack.push(root);
                list.add(0,root.val);
                root=root.right;
            }
            else {
                TreeNode temp = stack.pop();
                root=temp.left;
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
        System.out.println(postorderTraversal(root));

    }
}
