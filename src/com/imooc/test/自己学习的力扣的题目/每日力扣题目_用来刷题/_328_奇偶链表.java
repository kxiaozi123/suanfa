package com.imooc.test.自己学习的力扣的题目.每日力扣题目_用来刷题;

import com.imooc.test.视频中力扣题目.链表练习题目.ListNode;

/**
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 *
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 */
public class _328_奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
        {
            return head;
        }
        ListNode odd=head;
        ListNode even = head.next;
        ListNode evenHead=even;
        while (even!=null&&even.next!=null)
        {
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
}
