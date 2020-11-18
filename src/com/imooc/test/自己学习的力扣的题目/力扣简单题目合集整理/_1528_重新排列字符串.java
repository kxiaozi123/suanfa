package com.imooc.test.自己学习的力扣的题目.力扣简单题目合集整理;


/**
 * 示例 1：
 *
 *
 *
 * 输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * 输出："leetcode"
 * 解释：如图所示，"codeleet" 重新排列后变为 "leetcode" 。
 * 示例 2：
 *
 * 输入：s = "abc", indices = [0,1,2]
 * 输出："abc"
 * 解释：重新排列后，每个字符都还留在原来的位置上。
 * 示例 3：
 *
 * 输入：s = "aiohn", indices = [3,1,4,2,0]
 * 输出："nihao"
 * 示例 4：
 *
 * 输入：s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
 * 输出："arigatou"
 * 示例 5：
 *
 * 输入：s = "art", indices = [1,0,2]
 * 输出："rat"
 *
 * 链接：https://leetcode-cn.com/problems/shuffle-string
 */
public class _1528_重新排列字符串 {
    public static String restoreString(String s, int[] indices) {
        char [] result=new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            result[indices[i]]=s.charAt(i);
        }
        return String.valueOf(result);

    }
    public static void main(String[] args) {
        String s="art";
        int [] arr=new int[]{1,0,2};
        System.out.println(restoreString(s, arr));
    }
}
