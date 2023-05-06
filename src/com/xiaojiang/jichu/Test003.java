package com.xiaojiang.jichu;

import java.util.Arrays;

/**
 * @Author xiaojiang
 * @Date 2023-04-27 22:21
 * @Description 724.寻找数组的中心下标
 **/
public class Test003 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,-1,1,2}; //2
        System.out.println(pivotIndex(nums));
        System.out.println(pivotIndex1(nums));
    }


    //算出总长和最左边比较,++ (比较重叠了一个元素,该元素就是中心下标的元素,很巧妙)
    public static int pivotIndex1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total+=nums[i];
            if(total==sum){
                return i;
            }else {
                sum-=nums[i];
            }
        }
        return -1;
    }


        //自己想法
    public static int pivotIndex(int[] nums) {
        if(nums.length==1){
            return 0;
        }
        int r1 = 0;
        int r2 = 1;
        int sum1 = 0;
        int sum2 = 0;
        while (r1<nums.length){
            if(r1!=0){
                sum1+=nums[r1-1];
            }
            if(r2!=1){
                sum2 -= nums[r2-1];
            }else {
                for (int i = r2; i < nums.length; i++) {
                    sum2+=nums[i];
                }
            }
            if(sum1==sum2){
               return r1;
            }else {
                r1++;
                r2++;
            }
        }
        return -1;
    }

}
