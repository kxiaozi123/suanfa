package com.imooc.test.自己学习的力扣的题目.力扣简单题目合集整理;

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
