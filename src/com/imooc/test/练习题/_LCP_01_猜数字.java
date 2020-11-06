package com.imooc.test.练习题;

/**
 * https://leetcode-cn.com/problems/guess-numbers/
 * 输入：guess = [1,2,3], answer = [1,2,3]
 * 输出：3
 * 解释：小A 每次都猜对了。
 *
 * 输入：guess = [2,2,3], answer = [3,2,1]
 * 输出：1
 * 解释：小A 只猜对了第二次。
 */
public class _LCP_01_猜数字 {
    public static int game(int[] guess, int[] answer) {
        int result=0;
        for (int i = 0; i < guess.length; i++) {
            if(guess[i]==answer[i]) result++;
        }
        return result;

    }
    public static void main(String[] args) {
        int[] guess=new int[]{1,2,3};
        int[] answer=new int[]{1,2,3};
        System.out.println(game(guess, answer));
    }
}
