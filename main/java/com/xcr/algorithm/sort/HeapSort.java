package com.xcr.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: xia
 * @Date: 2021/1/13 17:33
 * @Version: v1.0
 */
public class HeapSort {

    public static int[] sort(int[] arr) {
        int len = arr.length;
        buildMaxHeap(arr, len);
        for (int i=len-1; i>=0; i--) {
            swap(arr, 0, i);
            len--;
            heapfiy(arr, 0, len);
        }
        return arr;
    }

    public static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int)Math.floor(len/2); i >= 0; i--) {
            heapfiy(arr, i, len);
        }
    }

    private static void heapfiy(int[] arr, int i, int len) {
        int left = i * 2 +1;
        int right = i * 2 +2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapfiy(arr, largest, len);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] sort = HeapSort.sort(new int[]{2, 4, 6, 3});
        System.out.println(Arrays.toString(sort));
    }

}
