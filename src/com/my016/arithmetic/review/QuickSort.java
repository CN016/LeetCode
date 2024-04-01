package com.my016.arithmetic.review;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] data = {1,1,4,5,1,4,1,9,1,9,8,1,0};
        quickSort(data,0,data.length-1);
        System.out.println(Arrays.toString(data));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 将数组分割为两部分，获取基准元素的索引
            int pivotIndex = partition(arr, low, high);

            // 递归地对左侧和右侧的子数组进行排序
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low , int high){
        // 选择最右边的元素作为基准
        int pivot = arr[high];
        int i = low - 1; // i表示小于基准的元素的最右边界
        for (int j = 0; j < high; j++) {
            if (arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }

        swap(arr,i+1,high);
        return i+1;
    }

    private static void swap(int[] arr , int indexA , int indexB){
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
