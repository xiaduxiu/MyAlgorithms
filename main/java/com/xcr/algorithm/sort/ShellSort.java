package com.xcr.algorithm.sort;

import java.util.Arrays;

/**
 * @Author: xia
 * @Date: 2021/1/8 11:18
 * @Version: v1.0
 */
public class ShellSort {

    public static int[] sort(int[] arr) {
        int grap = 1;
        while (grap < arr.length) {
            grap = grap * 3 +1;
        }

        while (grap > 0) {
            for (int i = grap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i- grap;
                while (j>= 0 && arr[j] > temp) {
                    arr[j+grap] = arr[j];
                    j -= grap;
                }
                arr[j+grap] = temp;
            }
            grap = (int) Math.floor(grap / 3);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sort = ShellSort.sort(new int[]{2, 3, 14, 5, 6, 7, 1, 4, 23, 13, 11});
        System.out.println(Arrays.toString(sort));
    }


}
