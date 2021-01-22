package com.xcr.algorithm.labuladong.list;

/**
 * @Author: xia
 * @Date: 2021/1/22 17:13
 * @Version: v1.0
 */
public class Q1List {

    int binarySearch(int[] nums, int target) {
        int left =0, right = nums.length-1;
        int mid = left + (right-left) /2;

        while (left <= right) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else if (nums[mid] < target) {
                left = mid+1;
            }
        }
        return -1;
    }
}
