package com.my016.arithmetic;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
    int[] arr1 = {-1,0,3,5,9,12};
        System.out.println(new Solution().search(arr1, 2));
        System.out.println(Arrays.toString(args));
    }

    private static class Solution {
        public int search(int[] nums, int target) {
            /*if (nums.length == 1){
                if (nums[0] == target){
                    return 0;
                }
            }
            int index = nums.length/2;
            for (int i = 0; i < nums.length/2; i++) {
                if (target < nums[index]){
                    index/=2;
                }
                if (target > nums[index]){
                    index = index + index/2;
                }
                if (target == nums[index]){
                    return index;
                }
            }
        return -1;*/
            int left = 0, right = nums.length - 1, mid = 0;
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (nums[mid] == target) return mid;
                if (nums[mid] > target) right = mid-1;
                else if (nums[mid] < target) left = mid+1;
            }
            return -1;
        }
    }
}
