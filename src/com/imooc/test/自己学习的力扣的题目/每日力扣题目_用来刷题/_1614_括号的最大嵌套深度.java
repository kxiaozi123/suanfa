package com.imooc.test.自己学习的力扣的题目.每日力扣题目_用来刷题;

/**
 * 示例 1：
 *
 * 输入：s = "(1+(2*3)+((8)/4))+1"
 * 输出：3
 * 解释：数字 8 在嵌套的 3 层括号中。
 * 示例 2：
 *
 * 输入：s = "(1)+((2))+(((3)))"
 * 输出：3
 * 示例 3：
 *
 * 输入：s = "1+(2*3)/(2-1)"
 * 输出：1
 * 示例 4：
 *
 * 输入：s = "1"
 * 输出：0
 *
 * 链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses
 */
public class _1614_括号的最大嵌套深度 {
    public static int maxDepth(String s) {
       int result=0;
       int current=0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='(') current++;
            if(chars[i]==')') current--;
            result=Math.max(current,result);
        }
        return result;

    }
    public static void main(String[] args) {
        String s="(1)+((2))+(((3)))";
        System.out.println(maxDepth(s));
    }
}
