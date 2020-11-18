package com.imooc.test.自己学习的力扣的题目.力扣简单题目合集整理;

/**
 * 示例 1：
 * <p>
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 2：
 * <p>
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 3：
 * <p>
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 * <p>
 * 链接：https://leetcode-cn.com/problems/split-a-string-in-balanced-strings
 */
public class _1221_分割平衡字符串 {
    public static int balancedStringSplit(String s) {
        int R = 0;
        int L = 0;
        int result = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == 'R') R++;
            if (c == 'L') L++;
            if (R == L) result++;
        }
        return result;

    }

    public static void main(String[] args) {
        String s1 = "RLRRLLRLRL";
        String s2 = "RLLLLRRRLR";
        String s3 = "LLLLRRRR";
        System.out.println(balancedStringSplit(s3));
    }
}
