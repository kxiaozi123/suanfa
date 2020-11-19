package com.imooc.test.自己学习的力扣的题目.每日力扣题目_用来刷题;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _283_移动零 {
    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int j=0;
        for (int i = 0; i < length; i++) {
            if(nums[i]!=0)
            {
                nums[j++]=nums[i];
            }
        }
        for (int i = j; i < length; i++) {
            nums[i]=0;
        }
    }
    public static void main(String[] args) {
        int [] arr=new int[]{0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
