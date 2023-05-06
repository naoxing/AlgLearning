package com.xiaojiang.jichu;

import java.util.Arrays;

/**
 * @Author xiaojiang
 * @Date 2023-04-27 20:03
 * @Description  26.删除有序数组中的重复项(返回长度)
 **/
public class Test002 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,4,4,5,6,7,8,8,8};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
          if(nums[j]!=nums[i]){
              nums[++i]=nums[j];
          }
        }
        int[] nums2 = nums;
        nums = new int[i+1];
        for(int j = 0; j <= i; j++) {
          nums[j] = nums2[j];
        }
        return i+1;
    }

}
