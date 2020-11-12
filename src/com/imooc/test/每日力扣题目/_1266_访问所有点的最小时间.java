package com.imooc.test.每日力扣题目;

/**
 * 输入：points = [[1,1],[3,4],[-1,0]]
 * 输出：7
 * 解释：一条最佳的访问路径是： [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * 从 [1,1] 到 [3,4] 需要 3 秒
 * 从 [3,4] 到 [-1,0] 需要 4 秒
 * 一共需要 7 秒
 * 示例 2：
 *
 * 输入：points = [[3,2],[-2,2]]
 * 输出：5
 *       //切比雪夫距离
 * 链接：https://leetcode-cn.com/problems/minimum-time-visiting-all-points
 */
public class _1266_访问所有点的最小时间 {
    public static int minTimeToVisitAllPoints(int[][] points) {
        int result=0;
        for (int i = 0; i < points.length-1; i++) {
            result+=Math.max(Math.abs(points[i][0]-points[i+1][0]),Math.abs(points[i][1]-points[i+1][1]));
        }
        return result;
    }

    public static void main(String[] args) {
        //int points [] [] =new int[][] {{1,1},{3,4},{-1,0}};
        int points [] [] =new int[][] {{3,2},{-2,2}};
        System.out.println(minTimeToVisitAllPoints(points));
    }
}
