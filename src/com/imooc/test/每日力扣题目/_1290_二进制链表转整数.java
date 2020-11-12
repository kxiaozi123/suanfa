package com.imooc.test.每日力扣题目;

import com.imooc.test.leetcode.linked.ListNode;

/**
 * 示例 1：
 *
 *
 *
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 *
 * 输入：head = [0]
 * 输出：0
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：1
 * 示例 4：
 *
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * 示例 5：
 *
 * 输入：head = [0,0]
 * 输出：0
 *
 * 链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
 */
public class _1290_二进制链表转整数 {
    public int getDecimalValue(ListNode head) {
        int result=0;
        while (head!=null)
        {
            result=result*2+head.val;
            head=head.next;
        }
        return result;
    }
}
