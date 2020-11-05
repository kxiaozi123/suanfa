package com.imooc.test.日常力扣测试;

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
}
