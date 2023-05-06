package com.xiaojiang.jichu;

import java.util.Arrays;

/**
 * @Author xiaojiang
 * @Date 2023-04-29 13:50
 * @Description 628.三个数最大乘积
 **/
public class Test006 {
    public static void main(String[] args) {
        int[] nums = {-6,-5,-4,-2,1,2}; //{-5,-3,-1,1,2,34}
        System.out.println(maximumProduct(nums));
        System.out.println(maximumProduct1(nums));
        System.out.println(maximumProduct2(nums));
    }


    //线性扫描
    public static int maximumProduct2(int[] nums) {
        int min1 = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE,max3 = Integer.MIN_VALUE;
        for (int x : nums) {
            if(x<min1){
                min2 = min1;
                min1 = x;
            }else if(x<min2){
                min2 = x;
            }
            if(x>max1){
                max3=max2;
                max2=max1;
                max1=x;
            }else if(x>max2){
                max3=max2;
                max2=x;
            }else if(x>max3){
                max3=x;
            }
        }
        return Math.max(min1*min2*max1,max1*max2*max3);
    }


        //直接调函数比较
    public static int maximumProduct1(int[] nums) {
        int len = nums.length;
        if(len == 3){
            return nums[0]*nums[1]*nums[2];
        }
        Arrays.sort(nums);
        return Math.max(nums[0]*nums[1]*nums[len-1],nums[len-3]*nums[len-2]*nums[len-1]);
    }


        //我的暴力
    public static int maximumProduct(int[] nums) {
        int len = nums.length;
        if(len == 3){
            return nums[0]*nums[1]*nums[2];
        }
        Arrays.sort(nums);
        int sum = 0;
        //  4个数以上并且 第一个数为正数||第二个数为正数||最后一个为负数||前两位乘积小于倒数第二第三的乘积
        if(nums[0]>=0 || nums[1]>=0 || nums[len-1]<0 || nums[0] * nums[1] < nums[len-2] * nums[len-3]){
            sum +=  nums[len-1]*nums[len-2]*nums[len-3];
        }else {
            sum += nums[0] * nums[1]*nums[len-1];
        }
        return sum;
    }

}
