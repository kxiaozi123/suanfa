package com.imooc.test.自己学习的力扣的题目.每日力扣题目_用来刷题;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height
 */
public class _406_根据身高重建队列 {
    public static int[][] reconstructQueue(int[][] people) {
        //身高相等 升序， 不相等 降序
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // 再一个一个插入。
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list.toArray(people);
    }
    public static void main(String[] args) {
        int[][] people=new int[][] {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(Arrays.deepToString(reconstructQueue(people)));

    }
}
