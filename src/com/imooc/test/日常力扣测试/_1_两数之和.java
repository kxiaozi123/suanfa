package com.imooc.test.日常力扣测试;

import java.util.HashMap;
import java.util.Map;

public class _1_两数之和 {
    /**
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer,Integer> map=new HashMap<>(length-1);
        map.put(nums[0],0);
        for (int i = 1; i < length; i++) {
            int another = target - nums[i];
            if(map.containsKey(another))
            {
                return new int[]{i,map.get(another)};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }

    public int[] twoSum2(int[] nums, int target){
        Map<Integer,Integer> map=new HashMap();
        map.put(nums[0],0);
        int length = nums.length;
        for (int i = 1; i < length - 1; i++) {
            int another = target - nums[i];
            if(map.containsKey(another))
                return new int[]{i,map.get(another)};
            map.put(nums[i],i);
        }
        return null;
    }
}
