package com.imooc.test.每日力扣题目;

/**
 * 小扣在秋日市集发现了一款速算机器人。店家对机器人说出两个数字（记作 x 和 y），请小扣说出计算指令：
 *
 * "A" 运算：使 x = 2 * x + y；
 * "B" 运算：使 y = 2 * y + x。
 * 在本次游戏中，店家说出的数字为 x = 1 和 y = 0，小扣说出的计算指令记作仅由大写字母 A、B 组成的字符串 s，字符串中字符的顺序表示计算顺序，请返回最终 x 与 y 的和为多少。
 *
 * 示例 1：
 *
 * 输入：s = "AB"
 *
 * 输出：4
 *
 * 解释：
 * 经过一次 A 运算后，x = 2, y = 0。
 * 再经过一次 B 运算，x = 2, y = 2。
 * 最终 x 与 y 之和为 4。
 *
 * 提示：
 *
 * 0 <= s.length <= 10
 * s 由 'A' 和 'B' 组成
 *
 * 链接：https://leetcode-cn.com/problems/nGK0Fy
 */
public class LCP_17_速算机器人 {
    public static int calculate(String s) {
//        这道题有歧义，导致理解题目比解题还困难。“在本次游戏中，店家说出的数字为 x = 1 和 y = 0”，我对这句话的理解是每次x、y的值可能不同，仅例子中的x = 1 和 y = 0。按这个理解x + y的值不可能计算出来。最后还是按照x、y固定来处理，一行代码通过测试。
//        按题目可知，一次计算中无论计算A还是计算B，X + Y都会倍增。那么很容易得出计算完后X + Y的值为2 ^ s.length。
        return (int)Math.pow(2, s.length());
    }
    public static void main(String[] args) {
        String s="abc";
        System.out.println(calculate(s));
    }
}
