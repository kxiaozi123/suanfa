package com.imooc.test.视频中力扣题目.二叉树的题目;

import java.util.HashMap;

/**
 * 例如，给出
 * <p>
 * 中序遍历 inorder =[9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 */
public class _106_从中序与后序遍历序列构造二叉树 {
    static HashMap<Integer, Integer> inorderArrayMap = new HashMap<>();
    static int[] post;

    /** 如果忘记了 看这个文章
     * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/tu-jie-gou-zao-er-cha-shu-wei-wan-dai-xu-by-user72/
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderArrayMap.put(inorder[i], i);
        }
        post = postorder;
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
    }

    public static TreeNode buildTree(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if (inorderEnd < inorderStart || postorderEnd < postorderStart) return null;
        int root = post[postorderEnd];
        Integer rootIndex = inorderArrayMap.get(root);
        TreeNode node=new TreeNode(root);
        node.left=buildTree(inorderStart,rootIndex-1,postorderStart,postorderStart+rootIndex-inorderStart-1);
        node.right=buildTree(rootIndex+1,inorderEnd,postorderStart+rootIndex-inorderStart,postorderEnd-1);
        return node;

    }

    public static void main(String[] args) {
        int[] inorder = {4, 2, 8, 5, 9, 1, 6, 10, 3, 7};
        int[] postorder = {4, 8, 9, 5, 2, 10, 6, 7, 3, 1};
        System.out.println(buildTree(inorder, postorder));
    }
}
