package com.xcr.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: xia
 * @Date: 2021/1/8 10:56
 * @Version: v1.0
 */
public class InsertSort {

    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while ( j > 0 && temp < arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }
            if (i != j) {
                arr[j] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sort = InsertSort.sort(new int[]{3, 1, 5, 6, 2, 7});
        System.out.println(Arrays.toString(sort));
    }
}
