package com.imooc.test.快慢指针题目;

import com.imooc.test.视频中力扣题目.链表练习题目.ListNode;

public class _141_环形链表 {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null&&fast.next!=null)// 快指针 如果指向的是空 那么就说明没环
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;//放下面是 刚开始肯定不相等
        }
        return false;
        //PPT作业

    }
}
