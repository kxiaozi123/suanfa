package com.imooc.test.自己学习的力扣的题目.每日力扣题目_用来刷题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * 示例 1：
 * <p>
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 * <p>
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 */
public class _973_最接近原点的K个点 {
    public int[][] kClosest(int[][] points, int K) {
         /*
            将 原数组 以距离原点大小 从小到大 排序
         */
        Arrays.sort(points, Comparator.comparingInt((array) -> array[0] * array[0] + array[1] * array[1]));
         /*
            将 排序后的数组 前K个 取出并返回
         */
        return Arrays.copyOf(points, K);
    }

    public static void main(String[] args) {

    }
}
