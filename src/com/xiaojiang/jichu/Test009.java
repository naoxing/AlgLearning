package com.xiaojiang.jichu;

/**
 * @Author xiaojiang
 * @Date 2023-04-29 17:18
 * @Description 509.斐波那契数列
 **/
public class Test009 {
    public static void main(String[] args) {
        System.out.println(fib(4));
        System.out.println(fib1(4));
        System.out.println(fib2(4));
    }


    //暴力递归x
    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //去重递归
    public static int fib1(int n) {
        int[] arr = new int[n + 1];
        return recurse(arr, n);
    }

    private static int recurse(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = recurse(arr, n - 1) + recurse(arr, n - 2);
        return arr[n];
    }

    //双指针
    public static int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int low = 0, hign = 1;
        for (int i = 2; i <= n; i++) {
            int sum = low + hign;
            low = hign;
            hign = sum;
        }
        return hign;

    }


}
