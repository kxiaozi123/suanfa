package com.imooc.test.视频中力扣题目.链表练习题目;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev=sentinel,curr=head;
        while (curr!=null)
        {
            if(curr.val==val) prev.next=curr.next;
            else prev=curr;
            curr=curr.next;
        }
        return sentinel.next;
    }

    public static void main(String[] args) {

    }
}
