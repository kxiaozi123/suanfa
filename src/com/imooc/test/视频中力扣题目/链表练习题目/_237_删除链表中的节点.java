package com.imooc.test.视频中力扣题目.链表练习题目;

/**
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class _237_删除链表中的节点 {
    public void deleteNode(ListNode node){
        node.val=node.next.val;
        node.next=node.next.next;

    }
    public static void main(String[] args) {

    }
}
