package com.imooc.test.代码复习;

public class 斐波那契数列 {
    //0 1 2 3 4 5 6 7  8  9  10
    //0 1 1 2 3 5 8 13 21 34 55
    public static int fibo1(int n)
    {
        if(n<=1) return n;
        return fibo1(n-2)+fibo1(n-1);
    }
    public static int fibo2(int n)
    {
        if(n<=1) return n;
        int first=0;
        int second=1;
        for (int i = 1; i < n; i++) {
            int sum=first+second;
            first=second;
            second=sum;
        }
        return second;
    }
    public static int fibo3(int n)
    {
        if(n<=1) return n;
        int first=0;
        int second=1;
        while (n-->1){
            second=first+second;
            first=second-first;
        }
        return second;
    }
    
    public static void main(String[] args) {
        System.out.println(fibo1(10));
        System.out.println(fibo2(10));
        System.out.println(fibo3(10));
    }
}
