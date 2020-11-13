package com.imooc.test.每日力扣题目;

import java.util.*;

/**
 * 示例 1：
 * <p>
 * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * 输出："Sao Paulo"
 * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
 * 示例 2：
 * <p>
 * 输入：paths = [["B","C"],["D","B"],["C","A"]]
 * 输出："A"
 * 解释：所有可能的线路是：
 * "D" -> "B" -> "C" -> "A".
 * "B" -> "C" -> "A".
 * "C" -> "A".
 * "A".
 * 显然，旅行终点站是 "A" 。
 * 示例 3：
 * <p>
 * 输入：paths = [["A","Z"]]
 * 输出："Z"
 * <p>
 * 链接：https://leetcode-cn.com/problems/destination-city
 */
public class _1436_旅行终点站 {
    public static String destCity(List<List<String>> paths) {
//        Map<String,String> map=new HashMap<>();
//        for (List<String> path : paths) {
//            map.put(path.get(0),path.get(1));
//        }
//        for (String s : map.keySet()) {
//            if(map.get(map.get(s))==null)
//                return map.get(s);
//        }
//        return null;
        /**
         * 第二种解法
         */
        Set<String> s = new HashSet<>();
        for (List<String> path : paths) {
            s.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!s.contains(path.get(1))) return path.get(1);
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("B", "C");
        List<String> list2 = Arrays.asList("D", "B");
        List<String> list3 = Arrays.asList("C", "A");
        List<List<String>> paths = new ArrayList<>();
        paths.add(list);
        paths.add(list2);
        paths.add(list3);
        System.out.println(destCity(paths));
    }
}
