package com.imooc.test.排序;

import java.util.Arrays;

/**
 * 2, 5, 1, 3, 4
 */
public class _1_冒泡排序 {
    public static void main(String[] args) {
        int [] array=new int[]{2,5,1,3,4};
        maopao(array);
        System.out.println(Arrays.toString(array));
    }

    private static int[] maopao(int[] array) {
        int isChange;
        for (int i = 0; i < array.length - 1; i++) {
            isChange=0;
            for (int j = 0; j < array.length - 1-i; j++) {
                if(array[j]> array[j+1])
                {
                    int temp= array[j];
                    array[j]= array[j+1];
                    array[j+1]=temp;
                    isChange=1;
                }
            }
            if(isChange==0) break;
        }
        return array;
    }

}
