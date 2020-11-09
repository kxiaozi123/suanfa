package com.imooc.test.力扣简单题目合集整理;

/**
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
     * 输入: s = "abcdefg", k = 2
     * 输出: "cdefgab"
     输入: s = "lrloseumgh", k = 6
     输出: "umghlrlose"
 */
public class 剑指_Offer58_II左旋转字符串 {
    public static String reverseLeftWords(String s, int n) {
        return s.substring(n)+s.substring(0,n);
    }
    public static void main(String[] args) {
        String s="abcdefg";
        System.out.println(s.substring(2) + s.substring(0, 2));
        String s1="lrloseumgh";
        System.out.println(s1.substring(6) + s1.substring(0, 6));

    }


}
