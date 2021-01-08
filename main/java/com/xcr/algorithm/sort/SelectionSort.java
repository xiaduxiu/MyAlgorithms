package com.xcr.algorithm.sort;

/**
 * @Author: xia
 * @Date: 2021/1/8 10:49
 * @Version: v1.0
 */
public class SelectionSort {

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        return arr;
    }

}
