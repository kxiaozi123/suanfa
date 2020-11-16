package com.imooc.test.每日力扣题目;

import java.util.Arrays;

/**
 * 示例：
 * <p>
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 * https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side/
 * 用到递归
 */
public class _1299_将每个元素替换为右侧最大元素 {
    public static int[] replaceElements(int[] arr) {
        if(arr.length==1)
        {
            return new int[]{-1};
        }
        int maxIndex=0;
        for (int i = 0; i < arr.length-1; i++) {
            if(i>=maxIndex)
            {
                maxIndex=findMax(arr,i+1);
            }
            arr[i]=arr[maxIndex];
        }
        arr[arr.length-1]=-1;
        return arr;

    }

    public static int findMax(int[] arr, int index) {
        int max = arr[index];
        int maxIndex = index;
        for (int i = index; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{17, 18, 5, 4, 6, 1};
        System.out.println(Arrays.toString(replaceElements(arr)));
    }
}
