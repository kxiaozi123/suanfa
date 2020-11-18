package com.imooc.test.自己学习的力扣的题目.力扣简单题目合集整理;

public class _344_反转字符串 {
    /**
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * @param s
     */
    public void reverseString(char[] s) {
        int begin=0;
        int end=s.length-1;
        while (begin<end)
        {
            char temp=s[begin];
            s[begin]=s[end];
            s[end]=temp;
            begin++;
            end--;
        }

    }

    public static void reverseString2(char[] s)
    {
        int start=0;
        int end=s.length-1;
        for (int i = 0; i <=end/2; i++) {
            char temp = s[start];
            s[start]=s[end];
            s[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char[] s=new char[]{'h','e','l','l','o'};
        reverseString2(s);
        System.out.println(s);
    }
}
