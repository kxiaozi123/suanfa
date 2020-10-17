package com.imooc.test.fib;

/**
 * 斐波那契数列
 *第几项 n      0 1 2 3 4 5 6 7  8
 *第几项的值    0 1 1 2 3 5 8 13 21
 *
 *  也可以使用斐波那契数列公式如下  此处不做推导 时间复杂度为 O(1) 或者O(logn)
 *  [（1＋√5）/2]^n /√5 － [（1－√5）/2]^n /√5 【√5表示根号5】
 *  时间复杂度比较 O(1)<O(logn)<O(n)<O(nlogn)<O(n²)<O(n³)<O(2ⁿ)<O(n!)
 */
public class FibDemo {
    //fb1 时间复杂度 O(2^n)
    public static int fib1(int n)
    {
        if(n<=1) return n;
        return fib1(n-2)+fib1(n-1);
    }
    //fb2 时间复杂度 O(n)
    public static int fib2(int n)
    {
        if(n<=1) return n;
        int first=0;
        int second=1;
        for (int i = 1; i < n; i++) {
            //当输入2 sum 就等于0+1 赋值给second 再把原来的second给first
            int sum=first+second;
            first=second;
            second=sum;
        }
        return second;
    }
    public static void main(String[] args) {
        System.out.println(fib2(8));
    }
}
