package com.imooc.test.自己学习的力扣的题目.力扣需要看一下的题目合集;

/**https://leetcode-cn.com/problems/jewels-and-stones/
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 */
public class _771_宝石与石头 {
    public static int numJewelsInStones(String J, String S) {
        int result=0;
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < J.length(); j++) {
                if(S.charAt(i)==J.charAt(j))
                {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String j="z";
        String s="ZZ";
        System.out.println(numJewelsInStones(j, s));
    }
}
