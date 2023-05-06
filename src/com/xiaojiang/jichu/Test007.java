package com.xiaojiang.jichu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author xiaojiang
 * @Date 2023-04-29 15:34
 * @Description 1.两数之和
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 **/
public class Test007 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums,22)));
        System.out.println(Arrays.toString(twoSum1(nums,22)));
    }


    //存入map,只遍历一次
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    //暴力求解
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
              if(nums[i]+nums[j] == target){
                  nums = new int[2];
                  nums[0] = i;
                  nums[1] = j;
                  break;
              }
            }
        }

        return nums;
    }

}
