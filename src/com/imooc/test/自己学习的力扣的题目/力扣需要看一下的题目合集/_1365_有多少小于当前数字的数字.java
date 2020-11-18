package com.imooc.test.自己学习的力扣的题目.力扣需要看一下的题目合集;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * 示例 1：
 *
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 *
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 *
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 *
 */
//TODO 只会暴力作法
public class _1365_有多少小于当前数字的数字 {
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        /**
         * 暴力解法
         */
       /* int [] result=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j])
                {
                    result[i]++;
                }
                if(nums[i]<nums[j])
                {
                    result[j]++;
                }
            }
        }
        return result;*/
        int[] arr = new int[nums.length];

        int[] arrCount = new int[10];
        for (int i = 0; i < nums.length; i++) {
            arrCount[nums[i]]++;
        }

        int count = 0;
        for (int i = 0; i < arrCount.length; i++) {
            if (arrCount[i] > 0) {
                int curCount = arrCount[i];

                arrCount[i] = count;

                count += curCount;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arrCount[nums[i]];
        }

        return arr;

    }
    public static void main(String[] args) {
        int [] nums=new int[] {6,5,4,8};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(nums)));
        //int[] nums=new int[]{7,7,7,7};
//        int[] nums=new int[]{6,5,4,8};
//        int max=nums[0];
//        int min=nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            max=Math.max(max,nums[i]);
//            min=Math.min(min,nums[i]);
//        }
//        System.out.println(max);
//        System.out.println(min);

    }
}
