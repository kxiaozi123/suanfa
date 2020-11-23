package com.imooc.test.自己学习的力扣的题目.力扣简单题目合集整理;

import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 */
public class _242_有效的字母异位词 {
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1,array2);
    }
    public static void main(String[] args) {

    }
}
