package com.imooc.test.每日力扣题目;

import java.util.Arrays;

/**
 * 给定一个非负整数数组A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当A[i] 为奇数时，i也是奇数；当A[i]为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 * <p>
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
 */
public class _922_按奇偶排序数组II {
    public static int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
        int i = 0;
        for (int a : A) {
            if (a % 2 == 0) {
                result[i] = a;
                i = i + 2;
            }
        }
        i = 1;
        for (int a : A) {
            if (a % 2 == 1) {
                result[i] = a;
                i = i + 2;
            }
        }
        return result;


    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 5, 7};
        System.out.println(Arrays.toString(sortArrayByParityII(arr)));
    }
}
