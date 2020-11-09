package com.imooc.test.力扣需要看一下的题目合集;

public class _941_有效的山脉数组 {
    public static void main(String[] args) {
        int [] a=new int[]{0,3,2,1};
        System.out.println(validMountainArray(a));
    }
    public static boolean validMountainArray(int[] A) {
//        int length = A.length;
//        int i=0;
//        while (i+1<length&&A[i]<A[i+1])
//        {
//            i++;
//        }
//        if(i==0||i==length-1) return false;
//        while (i+1<length&&A[i]>A[i+1])
//        {
//            i++;
//        }
//        return i==length-1;
        int N = A.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < N && A[i] < A[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == N - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < N && A[i] > A[i + 1]) {
            i++;
        }

        return i == N - 1;

    }

}
