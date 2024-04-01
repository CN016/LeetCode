package com.my016.arithmetic.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] data = {1,1,4,5,1,4,1,9,1,9,8,1,0};
        data = mergeSort(data);
        System.out.println(Arrays.toString(data));
    }

    private static int[] mergeSort(int[] arr){
        if (arr.length <=1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left,right);

    }

    private static int[] merge(int[] left, int[] right){
        List<Integer> merged = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        //比较左右子数组的元素，将较小的元素添加到合并数组中
        while ( leftIndex < left.length && rightIndex < right.length ){
            if (left[leftIndex] <= right[rightIndex]){
                merged.add(left[leftIndex++]);
            }else {
                merged.add(right[rightIndex++]);
            }
        }

        while (leftIndex < left.length){
            merged.add(left[leftIndex++]);
        }

        while (rightIndex < right.length){
            merged.add(right[rightIndex++]);
        }

        int[] result = new int[merged.size()];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }

        return result;
    }
}
