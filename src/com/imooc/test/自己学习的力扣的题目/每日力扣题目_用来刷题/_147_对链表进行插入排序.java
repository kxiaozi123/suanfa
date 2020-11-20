package com.imooc.test.自己学习的力扣的题目.每日力扣题目_用来刷题;


import com.imooc.test.代码复习.List;
import com.imooc.test.力扣ppt上三道题.ListNode;

public class _147_对链表进行插入排序 {
    public static ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode five = new ListNode(0, null);
        ListNode four = new ListNode(4, null);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(5, three);
        ListNode one = new ListNode(-1, two);
        System.out.println(insertionSortList(one));


    }
}
