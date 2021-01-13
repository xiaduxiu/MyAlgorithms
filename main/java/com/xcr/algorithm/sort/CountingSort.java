package com.xcr.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: xia
 * @Date: 2021/1/13 17:33
 * @Version: v1.0
 */
public class CountingSort {

    public static int[] sort(int[] arr) {
        int maxValue = getMaxValue(arr);
        int bucketLen = maxValue+1;
        int[] bucket = new int[bucketLen];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    private static int getMaxValue(int[] arr) {
        int max = arr[0];
        for (int i = 1; i <arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] sort = CountingSort.sort(new int[]{2, 4, 6, 7, 12, 34, 21, 22, 13, 43, 5, 66, 48, 3});
        System.out.println(Arrays.toString(sort));
    }

}
