package com.imooc.test.自己学习的力扣的题目.力扣简单题目合集整理;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/running-sum-of-1d-array/
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 *
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 *
 */
public class _1480_一维数组的动态和 {
    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i]=nums[i-1]+nums[i];
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{1,1,1,1,1};
        System.out.println(Arrays.toString(runningSum(nums)));
    }
}
