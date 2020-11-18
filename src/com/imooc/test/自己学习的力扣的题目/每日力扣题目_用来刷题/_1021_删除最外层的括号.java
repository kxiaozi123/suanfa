package com.imooc.test.自己学习的力扣的题目.每日力扣题目_用来刷题;

/**
 * 示例 1：
 *
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 *
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 *
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 *
 * 链接：https://leetcode-cn.com/problems/remove-outermost-parentheses
 */
public class _1021_删除最外层的括号 {
    public static String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int level=0;
        for (char c : s.toCharArray()) {
            if(c==')') level--;
            if(level>=1) sb.append(c);
            if(c=='(') level++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="()()";
        System.out.println(removeOuterParentheses(s));
    }


}
