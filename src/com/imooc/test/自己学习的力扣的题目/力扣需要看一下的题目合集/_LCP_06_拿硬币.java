package com.imooc.test.自己学习的力扣的题目.力扣需要看一下的题目合集;

/**
 * https://leetcode-cn.com/problems/na-ying-bi/
 *
 * 输入：[4,2,1]
 *
 * 输出：4
 *
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 *
 * 输入：[2,3,10]
 *
 * 输出：8
 */
public class _LCP_06_拿硬币 {
    /**
     * 只需要判断每一堆的力扣币数是否是偶数
     * 如果是偶数则至少要拿coins[i]/2次
     * 如果是奇数则至少要拿coins[i]/2 + 1次
     * @param coins
     * @return
     */
    public static int minCount(int[] coins) {
        int result=0;
        for (int i = 0; i < coins.length; i++) {
            result+=coins[i]/2;
            result+=coins[i]%2;
        }
        return result;
    }

    public static void main(String[] args) {
            int [] coins=new int[]{4,2,1};
        System.out.println(minCount(coins));
    }
}
