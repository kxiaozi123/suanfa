package com.imooc.test.自己学习的力扣的题目.力扣需要看一下的题目合集;

/**
 * https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * 示例 1：
 *
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * 示例 2：
 *
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 *
 */
public class _1281_整数的各位积和之差 {
    public static int subtractProductAndSum(int n) {
       int add=0;
       int mul=1;
       while (n!=0)
       {
           int temp = n % 10;
           add=add+temp;
           mul=mul*temp;
           n=n/10;
       }
       return mul-add;
    }
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }
}
