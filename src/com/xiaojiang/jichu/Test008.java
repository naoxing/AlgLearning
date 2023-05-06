package com.xiaojiang.jichu;

import java.util.Arrays;

/**
 * @Author xiaojiang
 * @Date 2023-04-29 16:13
 * @Description 剑指offer 006.排序数组两数之和
 **/
public class Test008 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,4,9,56,90};
        System.out.println(Arrays.toString(twoSum(numbers,8)));
        System.out.println(Arrays.toString(twoSum1(numbers,8)));
    }

    //双指针
    public static int[] twoSum1(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        int sum = 0;
        while (l<r){
             sum = numbers[l]+numbers[r];
             if(sum == target){
                 return new int[] {l,r};
             }else if(sum > target){
                 r--;
             }else {
                 l++;
             }
        }
        return new int[0];
    }


        //二分查找
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int l = i;
            int r = numbers.length-1;
            while (l<r){
                int mid = (r-l)/2 + l;
                if(numbers[mid] == target - numbers[i]){
                    return new int[] {i,mid};
                }else if(numbers[mid]>target-numbers[i]){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }
        return new int[0];
    }
}
