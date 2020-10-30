package com.imooc.test.复习;


public class 反转链表 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
    public ListNode reverseList2(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode newHead=null;
        while (head!=null)
        {
            ListNode temp = head.next;
            head.next=newHead;
            newHead=head;
            head=temp;
        }
        return newHead;
    }
}
