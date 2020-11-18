package com.imooc.test.自己学习的力扣的题目.每日力扣题目_用来刷题;

/**
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：
 * mat =
 * [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：25
 * 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
 * 请注意，元素 mat[1][1] = 5 只会被计算一次。
 * 示例  2：
 * <p>
 * 输入：mat =
 * [[1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1],
 * [1,1,1,1]]
 * 输出：8
 * 示例 3：
 * <p>
 * 输入：mat = [[5]]
 * 输出：5
 * <p>
 * 链接：https://leetcode-cn.com/problems/matrix-diagonal-sum
 */
public class _1572_矩阵对角线元素的和 {
    public static int diagonalSum(int[][] mat) {

        int sum = 0;
        int length = mat.length;
        int mid=length>>1;
        for (int i = 0; i < mat.length; i++) {
            sum+=mat[i][i]+mat[i][length-i-1];
        }
        return length%2==0?sum:sum-mat[mid][mid];

    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(diagonalSum(mat));
    }
}
