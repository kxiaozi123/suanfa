package com.imooc.test.力扣ppt上三道题;

public class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int x)
      { val = x; }

      public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
      }

      @Override
      public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
      }
}
