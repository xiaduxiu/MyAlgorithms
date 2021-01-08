package com.xcr.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: xia
 * @Date: 2021/1/8 14:04
 * @Version: v1.0
 */
public class MergeSort {
    public static int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int middle  = (int)Math.floor(arr.length >> 1);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right  = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(sort(left), sort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] arr = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                arr[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                arr[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            arr[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            arr[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return arr;
    }


    public static void main(String[] args) {
        int[] sort = MergeSort.sort(new int[]{2, 4, 6, 7, 12, 34, 21, 22, 13, 43, 5, 66, 48, 3});
        System.out.println(Arrays.toString(sort));
    }
}
