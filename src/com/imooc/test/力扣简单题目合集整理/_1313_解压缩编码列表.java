package com.imooc.test.力扣简单题目合集整理;

import java.util.Arrays;

/**
 * 示例：
 * https://leetcode-cn.com/problems/decompress-run-length-encoded-list/
 * 输入：nums = [1,2,3,4]
 * 输出：[2,4,4,4]
 * 解释：第一对 [1,2] 代表着 2 的出现频次为 1，所以生成数组 [2]。
 * 第二对 [3,4] 代表着 4 的出现频次为 3，所以生成数组 [4,4,4]。
 * 最后将它们串联到一起 [2] + [4,4,4] = [2,4,4,4]。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2,3]
 * 输出：[1,3,3]
 */
public class _1313_解压缩编码列表 {
    public static int[] decompressRLElist(int[] nums) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            len += nums[i];
        }
        int[] result = new int[len];
        for (int i = 0; i < nums.length; i = i + 2) {
            for (int j = 0; j < nums[i]; j++) {
                result[index] = nums[i+1];
                index++;

            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2,3};
        System.out.println(Arrays.toString(decompressRLElist(arr)));
    }
}
