package com.imooc.test.视频中力扣题目.二叉树的题目.课后的题目第二页;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class _590_N叉树的后序遍历 {
    /*递归写法*/
    /*public List<Integer> postorder(Node root) {
        List<Integer> list=new ArrayList<>();
        postOrder(root,list);
        return list;
    }
    public void postOrder(Node root, List<Integer> res){
        if(root==null) return;
        List<Node> children = root.children;
        if(children ==null) return;
        for (Node child : children) {
            postOrder(child,res);
        }
        res.add(root.val);
    }*/
     public List<Integer> postorder(Node root) {
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
                 for(int i= 0; i< node.children.size();i++){
                     stack.push(node.children.get(i));
                 }
             }
         }
         Collections.reverse(result);
         return result;
    }
    public static void main(String[] args) {

    }
}
