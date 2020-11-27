package com.imooc.test.视频中力扣题目.二叉树的题目;

/**
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 */
public class _108_将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0,nums.length-1);
    }
    public TreeNode helper(int[] nums,int left,int right)
    {
        if(left>right) return null;
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,left,mid-1);
        root.right=helper(nums,mid+1,right);
        return root;
    }
}
