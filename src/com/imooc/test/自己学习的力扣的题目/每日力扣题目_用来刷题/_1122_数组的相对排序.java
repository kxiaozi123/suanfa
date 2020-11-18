package com.imooc.test.自己学习的力扣的题目.每日力扣题目_用来刷题;

import java.util.Arrays;

/**
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 */
public class _1122_数组的相对排序 {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int [] result=new int[arr1.length];
        int [] nums=new int[1001];
        int index=0;
        for (int i : arr1) {
            nums[i]++;
        }
        for (int i : arr2) {
            while (nums[i]>0)
            {
                result[index++]=i;
                nums[i]--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]>0)
            {
                result[index++]=i;
                nums[i]--;
            }
        }

        return result;
//        int[] res = new int[arr1.length];
//        int[] nums = new int[1001];//0 <= arr1[i], arr2[i] <= 1000
//
//        //1.遍历arr1，统计每个元素的数量。存放在数组nums中，
//        for (int i : arr1) {
//            nums[i]++;
//        }
//
//        //2.将arr2中出现的数，放入res中
//        int index = 0;
//        for (int i : arr2) {
//            while (nums[i] > 0) {
//                res[index++] = i;
//                nums[i]--;
//            }
//        }
//
//        //3.将arr2中没有出现的数放入res中
//        for (int i = 0; i < nums.length; i++) {
//            while (nums[i] > 0) {
//                res[index++] = i;
//                nums[i]--;
//            }
//        }
//
//        return res;
    }

    public static void main(String[] args) {
        int arr1[] =new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int arr2[]=new int[]{2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }
}
