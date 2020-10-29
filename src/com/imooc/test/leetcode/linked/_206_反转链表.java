package com.imooc.test.leetcode.linked;

public class _206_反转链表 {
        //1->2->3->4->5->null
        //5->4->3->2->1->null
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
