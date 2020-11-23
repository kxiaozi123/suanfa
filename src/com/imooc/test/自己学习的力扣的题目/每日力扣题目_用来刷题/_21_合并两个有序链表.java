package com.imooc.test.自己学习的力扣的题目.每日力扣题目_用来刷题;

import com.imooc.test.力扣ppt上三道题.ListNode;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 */
public class _21_合并两个有序链表 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode dummyHead=new ListNode(0);
       ListNode temp=dummyHead,temp1=l1,temp2=l2;
       while (temp1!=null&&temp2!=null)
       {
           if(temp1.val<=temp2.val)
           {
               temp.next=temp1;
               temp1=temp1.next;
           }
           else {
               temp.next=temp2;
               temp2=temp2.next;
           }
           temp=temp.next;
       }
       if(temp1!=null)
       {
           temp.next=temp1;
       }else if(temp2!=null)
       {
           temp.next=temp2;
       }
       return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode three = new ListNode(4, null);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);



        ListNode three2 = new ListNode(4, null);
        ListNode two2 = new ListNode(3, three2);
        ListNode one2 = new ListNode(1, two2);
        System.out.println(mergeTwoLists(one, one2));
    }
}
