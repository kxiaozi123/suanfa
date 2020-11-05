package com.imooc.test.练习题;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/xor-operation-in-an-array/
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 *      "^" 为按位异或 XOR 运算符。
 *
 * 输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 *
 */
public class _1486_数组异或操作 {
    public static int xorOperation(int n, int start) {
        int result=0;
        int [] temp=new int[n];
        for (int i = 0; i < n; i++) {
            temp[i]=start;
            start=start+2;
            result=result^temp[i];
        }
        return result;
    }
    public static void main(String[] args) {
        //System.out.println(xorOperation(1, 7));
        //System.out.println(10 ^ 6);
//        int n=10;
//        int start=5;
//        int result=0;
//        int [] temp=new int[n];
//        for (int i = 0; i < n; i++) {
//            temp[i]=start;
//            start=start+2;
//        }
//        for (int i = 0; i < n; i++) {
//            result=result^temp[i];
//        }
//        System.out.println(result);

    }
}
