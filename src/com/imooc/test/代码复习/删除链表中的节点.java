package com.imooc.test.代码复习;


public class 删除链表中的节点 {
    public void deleteNode(ListNode node){
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
