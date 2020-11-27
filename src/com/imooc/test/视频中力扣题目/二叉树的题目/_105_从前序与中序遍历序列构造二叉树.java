package com.imooc.test.视频中力扣题目.二叉树的题目;

import java.util.HashMap;

/**
 * 例如，给出
 *
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */
public class _105_从前序与中序遍历序列构造二叉树 {
    static HashMap<Integer, Integer> inorderArrayMap = new HashMap<>();
    static int[] pre;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderArrayMap.put(inorder[i], i);
        }
        pre = preorder;
        return buildTree(0, inorder.length - 1, 0, preorder.length - 1);
    }
    public static TreeNode buildTree(int inorderStart, int inorderEnd, int preorderStart, int preorderEnd) {
        if (inorderEnd < inorderStart || preorderEnd < preorderStart) return null;
        int root = pre[preorderStart];
        Integer rootIndex = inorderArrayMap.get(root);
        TreeNode node=new TreeNode(root);
        node.left=buildTree(inorderStart,rootIndex-1,preorderStart+1,preorderStart+rootIndex-inorderStart+1);
        node.right=buildTree(rootIndex+1,inorderEnd,preorderStart+rootIndex-inorderStart+1,preorderEnd);
        return node;

    }

    public static void main(String[] args) {
        int[] preorder = {1,2,4,5,8,9,3,6,10,7};
        int[] inorder = {4,2,8,5,9,1,6,10,3,7};
        System.out.println(buildTree(preorder, inorder));
    }
    
}
