package com.xcr.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: xia
 * @Date: 2021/1/8 14:03
 * @Version: v1.0
 */
public class FastSort {

    public static int[] sort(int[] arr) {
        return fast(arr, 0, arr.length-1);
    }

    public static int[] fast(int[] arr, int left, int right) {
        if (left < right) {
            int parttion = parttion(arr, left, right);
            fast(arr, left, parttion-1);
            fast(arr, parttion+1, right);
        }
        return arr;
    }

    public static int parttion(int[] arr, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[left]) {
                swap(arr, i, index);
                index ++;
            }
        }
        swap(arr, left, index-1);
        return index-1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {

        int[] sort = FastSort.sort(new int[]{2, 4, 6, 7, 12, 34, 21, 22, 13, 43, 5, 66, 48, 3});
        System.out.println(Arrays.toString(sort));
    }

}
