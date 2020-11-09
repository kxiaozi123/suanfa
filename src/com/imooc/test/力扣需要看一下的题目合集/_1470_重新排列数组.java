package com.imooc.test.力扣需要看一下的题目合集;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shuffle-the-array/
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 *
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出：[1,4,2,3,3,2,4,1]
 *
 * 输入：nums = [1,1,2,2], n = 2
 * 输出：[1,2,1,2]
 */
public class _1470_重新排列数组 {
    public static int[] shuffle(int[] nums, int n) {
       int [] result=new int[2*n];
        for (int i = 0; i < n; i++) {
            result[2*i]=nums[i];
            result[2*i+1]=nums[i+n];
        }
        return result;

    }
    public static void main(String[] args) {
        int [] nums=new int[]{1,2,3,4,4,3,2,1};
        System.out.println(Arrays.toString(shuffle(nums, nums.length / 2)));
    }
}
