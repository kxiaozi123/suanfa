package com.imooc.test.视频中力扣题目;

import com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目.TreeNode;

import java.util.Stack;

/**
 * 示例 1：
 *              10
 *            5   15
 *          3  7    18
 *
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * 示例 2：
 *
 *
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 *
 * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
 */
public class _938_二叉搜索树的范围和 {
    public int rangeSumBST(TreeNode root, int low, int high) {
//        int ans=0;
//        Stack<TreeNode> stack=new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty())
//        {
//            TreeNode node = stack.pop();
//            if(node!=null)
//            {
//                if(node.val>=low&&node.val<=high)
//                    ans+=node.val;
//                if(node.val>low)
//                {
//                    stack.push(node.left);
//                }
//                if(node.val<high)
//                {
//                    stack.push(node.right);
//                }
//            }
//        }
//        return ans;
        if(root==null) return 0;
        if(root.val<low) return rangeSumBST(root.right,low,high);
        if(root.val>high) return rangeSumBST(root.left,low,high);
        return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
    }
}
