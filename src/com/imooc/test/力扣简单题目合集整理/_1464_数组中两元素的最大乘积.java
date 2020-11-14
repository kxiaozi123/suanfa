package com.imooc.test.力扣简单题目合集整理;

import java.util.Arrays;

/**
 * 示例 1：
 *
 * 输入：nums = [3,4,5,2]
 * 输出：12
 * 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12 。
 * 示例 2：
 *
 * 输入：nums = [1,5,4,5]
 * 输出：16
 * 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
 * 示例 3：
 *
 * 输入：nums = [3,7]
 * 输出：12
 *
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array
 */
public class _1464_数组中两元素的最大乘积 {
    public static int maxProduct(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        return (nums[length-1]-1)*(nums[length-2]-1);
    }

    public static void main(String[] args) {
        int [] nums=new int[]{3,7};
        //Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        System.out.println(maxProduct(nums));
    }
}
