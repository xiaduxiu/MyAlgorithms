package com.xcr.algorithm.sort;

/**
 * @Author: xia
 * @Date: 2021/1/8 10:30
 * @Version: v1.0
 */
public class BubbleSort {

    public static void sort1(int[] arr) {
        boolean flag = false;
        do {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < arr[i+1]) {
                    swap(arr, i, i+1);
                    flag = true;
                }
            }
        } while (flag);

    }


    /**
     *
     * @param arr
     */
    public static void sort2(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = 0; j < length - i -1; j++) {
                if (arr[j] < arr[j+1]) {
                    swap(arr, j, j+1);
                    flag = true;
                }
            }
            if(!flag) {
                break;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
