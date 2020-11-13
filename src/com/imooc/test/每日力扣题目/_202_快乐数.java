package com.imooc.test.每日力扣题目;

import java.util.HashSet;
import java.util.Set;

/**
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class _202_快乐数 {
    /**
     * 用set的方式 如果出现重复了 有循环 就不是快乐数
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        Set<Integer> list = new HashSet<>();
        list.add(n);
        while (n != 1) {
            n = getNext(n);
            if (!list.contains(n)) {
                list.add(n);
            } else {
                return false;
            }
        }
        return true;

    }

    /**
     * 快慢指针作法
     * @param n
     * @return
     */
    public static boolean isHappy2(int n)
    {
        int slow = n;
        int fast = getNext(n);
        while (fast!=slow&&fast!=1)
        {
            slow=getNext(slow);
            fast=getNext(getNext(fast));
        }
        return fast==1;


    }

    private static int getNext(int n) {
        int sum = 0;
        int d;
        while (n > 0) {
            d = n % 10;
            sum += d * d;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        //System.out.println(getNext(19));
        System.out.println(isHappy2(19));
        //System.out.println(isHappy(116));
        //System.out.println(getNext(19));
        //System.out.println(isHappy(19));
    }
}
