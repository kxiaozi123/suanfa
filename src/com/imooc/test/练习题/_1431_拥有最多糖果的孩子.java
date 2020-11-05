package com.imooc.test.练习题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
        *  输入：candies = [4,2,1,1,2], extraCandies = 1
        * 输出：[true,false,false,false,false]
        * 解释：只有 1 个额外糖果，所以不管额外糖果给谁，只有孩子 1 可以成为拥有糖果最多的孩子。
 *
 *
 *      输入：candies = [12,1,12], extraCandies = 10
 *      输出：[true,false,true]
 *
 */
public class _1431_拥有最多糖果的孩子 {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result=new ArrayList<>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            result.add(candies[i]+extraCandies>=max);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] candies =new int[]{12,1,12};
        System.out.println(kidsWithCandies(candies, 1));

    }
}
