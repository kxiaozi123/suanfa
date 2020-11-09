package com.imooc.test.力扣需要看一下的题目合集;

import java.util.HashSet;
import java.util.Set;

public class _349_两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1=new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }
        Set<Integer> result=new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if(s1.contains(nums2[i])) result.add(nums2[i]);
        }
        //set 转换成int
        int [] ans=new int[result.size()];
        int count=0;
        for (Integer integer : result) {
            ans[count++]=integer;
        }
        return ans;

    }
}
