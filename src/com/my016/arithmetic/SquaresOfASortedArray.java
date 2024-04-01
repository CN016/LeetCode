package com.my016.arithmetic;

public class SquaresOfASortedArray {

    public static void main(String[] args) {
        System.out.println(new Solution().sortedSquares(null));
    }

    private static class Solution {
        public int[] sortedSquares(int[] nums) {
            int right  = 0;
            int[] res = new int[nums.length];
            while (right < nums.length){
                if (nums[right] >= 0)break;
                right++;
            }
            int left = right - 1;
            int x = 0;
            while (left >= 0 && right < nums.length){
                if (Math.abs(nums[left]) < nums[right])res[x++] = nums[left] * nums[left--];
                else res[x++] = nums[right] * nums[right++];
            }
            while (left >= 0){
                res[x++] = nums[left] * nums[left--];
            }
            while (right < nums.length){
                res[x++] = nums[right] * nums[right++];
            }

            return res;
        }
    }
}
