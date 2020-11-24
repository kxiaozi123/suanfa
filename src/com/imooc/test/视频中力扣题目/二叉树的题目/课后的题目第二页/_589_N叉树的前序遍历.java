package com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目第二页;

import com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * 1
 * 3  2   4
 * 5  6
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/submissions/
 */
public class _589_N叉树的前序遍历 {
    /*递归写法*/
    /*public List<Integer> preorder(Node root) {
        List<Integer> list=new ArrayList<>();
        preorder(root,list);
        return list;

    }
    public void preorder(Node root, List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        List<Node> children = root.children;
        if(children ==null) return;
        for (Node child : children) {
            preorder(child,res);
        }
    }*/
    /*非递归写法*/
    public static List<Integer> preorder(Node root) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            Node node = stack.pop();
            result.add(node.val);
            if(node.children!=null)
            {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {


    }
}
