package com.imooc.test.每日力扣题目;

/**
 * 示例 1：
 *
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * 示例 2：
 *
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 *
 * 输入：arr = [10,11,12]
 * 输出：66
 *
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 */
public class _1588_所有奇数长度子数组的和 {
    //以{1,2,3,4,5}为例，计算i为某确定值时候对应arr[i]出现的总次数。
    public static int sumOddLengthSubarrays(int[] arr) {
        /*int sum = 0;
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            //当i = 2时候，arr[2] = 3,左边有2个元素1，2，
            //需要保证连续，则取元素方式如下:
            //取0个:{3}
            //取1个:只取一个元素2.则{2,3}
            //取2个:取2个元素1和2,则{1,2,3}
            //所以有3种情况就是2+1种情况，也就是i+1种情况
            int left = i + 1;
            //右边个数为：len-(i+1)个
            //同理可得
            int right = len - (i + 1) + 1;
            //左边取的元素个数0,1,2；则只有1为奇数，可得左边去奇数个元素的方式：
            int left_odd = left / 2;
            //左边取的元素个数0,1,2；则偶数为0个或者2个，可得左边去偶数个元素的方式：
            int left_even = (left + 1) / 2;
            //同上，右边去奇数个元素的方式
            int right_odd = right / 2;
            //同上，右边去偶数个元素的方式
            int right_even = (right + 1) / 2;
            //左边取任意奇数个同时右边去任意奇数个加上自身，一共奇数个。任意组合所以是乘法。
            //左边取任意偶数个同时右边去任意偶数个加上自身，一共奇数个。注意包含左右各取0个。
            sum += arr[i] * (left_odd * right_odd + left_even * right_even);
        }
        return sum;*/
        int sum=0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int left=i+1;
            int right=length-left+1;
            int left_odd=left/2;
            int left_even=(left+1)/2;
            int right_odd=right/2;
            int right_even=(right+1)/2;
            sum+=arr[i]*(left_odd*right_odd+left_even*right_even);
        }
        return sum;
    }

    public static void main(String[] args) {
        int [] arr=new int[]{1,2,3,4,5};
        System.out.println(sumOddLengthSubarrays(arr));
    }
}
