package com.my016.arithmetic;

import java.lang.reflect.Array;
import java.util.Arrays;

@SuppressWarnings("NonAsciiCharacters")
public class 删除排序数组中的重复项 {
    public static void main(String[] args) {
        int[] arr ={0,1,2,2,3,3,4};
        System.out.println(remove(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int remove(int[] nums){
        if (nums.length == 0 ){
            return 0;
        }
        int slow = 0;
        for (int fast = 0; fast< nums.length -2; fast++){
            if (nums[fast]!= nums[fast+1]){
                slow++;
                nums[slow] = nums[fast+1];
            }
        }
        return slow+1;
    }
}
