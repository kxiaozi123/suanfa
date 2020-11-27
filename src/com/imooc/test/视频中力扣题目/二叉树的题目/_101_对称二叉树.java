package com.imooc.test.视频中力扣题目.二叉树的题目;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * <p>
 * <p>
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * <p>
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 */
public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    //    public boolean isMirror(TreeNode t1,TreeNode t2)
//    {
//        if(t1==null&&t2==null) return true;
//        if(t1==null||t2==null) return false;
//        return t1.val==t2.val&&isMirror(t1.left,t2.right)&&isMirror(t1.right,t2.left);
//    }
    public boolean isMirror(TreeNode t1, TreeNode t2)
    {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(t1);
        queue.offer(t2);
        while (!queue.isEmpty())
        {
            t1 = queue.poll();
            t2 = queue.poll();
            if(t1==null&&t2==null) continue;
            if((t1==null||t2==null)||(t1.val!=t2.val)) return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }
}
