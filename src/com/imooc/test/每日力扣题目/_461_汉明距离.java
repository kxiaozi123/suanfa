package com.imooc.test.每日力扣题目;

public class _461_汉明距离 {
    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        //System.out.println(Integer.bitCount(1));
        //System.out.println(Integer.bitCount(4));
        System.out.println(1 ^ 4);
    }
}
