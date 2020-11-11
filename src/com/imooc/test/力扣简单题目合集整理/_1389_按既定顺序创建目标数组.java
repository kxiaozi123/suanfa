package com.imooc.test.力扣简单题目合集整理;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/create-target-array-in-the-given-order/
 * 示例 1：
 *
 * 输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * 输出：[0,4,1,3,2]
 * 解释：
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4,0], index = [0,1,2,3,0]
 * 输出：[0,1,2,3,4]
 * 解释：
 * nums       index     target
 * 1            0        [1]
 * 2            1        [1,2]
 * 3            2        [1,2,3]
 * 4            3        [1,2,3,4]
 * 0            0        [0,1,2,3,4]
 * 示例 3：
 *
 * 输入：nums = [1], index = [0]
 * 输出：[1]
 *
 */
public class _1389_按既定顺序创建目标数组 {
    public static int[] createTargetArray(int[] nums, int[] index) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            list.add(index[i],nums[i]);
//        }
//        int [] result=new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            result[i]=list.get(i);
//        }
//        return result;
        int len = nums.length;
        int[] target = new int[len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < i; j++) {
                if(index[j] >= index[i]) {
                    index[j]++;
                }
            }
        }
        for(int i = 0; i < len; i++) {
            target[index[i]] = nums[i];
        }
        return target;



    }
    public static void main(String[] args) {
        int [] nums=new int[] {0,1,2,3,4};
        int [] index=new int[] {0,1,2,2,1};
        System.out.println(Arrays.toString(createTargetArray(nums,index)));
    }
}
