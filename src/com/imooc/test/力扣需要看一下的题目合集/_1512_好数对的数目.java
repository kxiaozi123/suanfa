package com.imooc.test.力扣需要看一下的题目合集;

/**
 * https://leetcode-cn.com/problems/number-of-good-pairs/
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 *
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 *
 * 输入：nums = [1,2,3]
 * 输出：0
 *
 *
 *
             * 解法二：
             * 好数对满足2个条件：
             * 1. nums[i] == nums[j]
             * 2. i < j
             * 假如输入[1,1,1,1]
             * 我们从前往后遍历的时候，好数对的数量为：3：[0,1],[0,2],[0,3]
             * 2:[1,2],[1,3]
             * 1:[2,3]
             * 这里我们举的例子是[1,1,1,1]，如果我们的例子是[2,1,1,1,1,4]结果也是一样的
             * 所以当我们从前往后遍历的时候，我们把数值存放在temp数组中，实际上计算的结果顺序是从后往前的，
             * 即1 + 2 + 3 = 6；
             * 这个结果其实跟我们正常理解的3 + 2 + 1 = 6的结果是一致的
 *
 *
             * class Solution {
             *     public int numIdenticalPairs(int[] nums) {
             *         int[] temp = new int[101];
             *         int ans = 0;
             *         for(int num : nums){
             *             //temp[num]存放的就是满足条件1的数目
             *             temp[num]++;
             *             //temp[num]-1理解为：满足条件1的好数对的数目。只不过这里的求值过程为倒序的
             *             ans+=temp[num]-1;
             *         }
             *         return ans;
             *     }
             * }
             *
 */
public class _1512_好数对的数目 {
    public static int numIdenticalPairs(int[] nums) {
//        int result=0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if(i<j&&nums[i] == nums[j])
//                    result++;
//            }
//        }
//        return result;
        int [] temp=new int[101];
        int result=0;
        for (int num : nums) {
           temp[num]++;
           result+=temp[num]-1;

        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,1,1,3};
        System.out.println(numIdenticalPairs(nums));

    }

}
