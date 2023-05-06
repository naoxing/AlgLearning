package com.xiaojiang.jichu;

/**
 * @Author xiaojiang
 * @Date 2023-04-27 23:30
 * @Description 69.x的平方根
 **/
public class Test004 {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
        System.out.println(mySqrt2(983972489));
    }

    //牛顿迭代
    public static int mySqrt2(int x) {
        return (int) sqrt(x, x);
    }

    private static double sqrt(double i, int x) {
        double res = (i + x / i) / 2;
        if (res == i) {
            return i;
        } else {
            return sqrt(res, x);
        }

    }


    //调函数
    public static int mySqrt1(int x) {
        return (int) Math.sqrt(x);
    }

    //二分查找
    public static int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

}
