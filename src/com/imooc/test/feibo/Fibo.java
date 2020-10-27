package com.imooc.test.feibo;

public class Fibo {
    // 0 1 2 3 4 5 6 7  8
    // 0 1 1 2 3 5 8 13 21
    //还可以用斐波那契数学公式求解
    public static int fibo(int n)
    {
        if(n<=1) return n;
        return fibo(n-1)+fibo(n-2);
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
        while (n-->1) {
            //n-->1 执行n-1次  n-->0 执行n次
            second+=first;
            first=second-first;
        }
        return second;
    }
    public static int sum1(int n)
    {
        int result=0;
        for (int i = 1; i <=n; i++) {
            result=result+i;
        }
        return result;
    }
    public static int sum2(int n)
    {
        return (1+n)*n/2;
    }
    public static void main(String[] args) {
        //System.out.println(fibo3(8));
        /*for (int i = 0; i < 10; i++) {
            System.out.print(fibo(i)+" ");
        }*/
        //System.out.println("");
        /*for (int i = 0; i < 10; i++) {
            System.out.print(fibo2(i)+" ");
        }*/
//        Times.test("sum1", () -> {
//            System.out.println(sum1(99999));
//        });
//        Times.test("sum2", () -> {
//            System.out.println(sum2(99999));
//        });

    }
}
