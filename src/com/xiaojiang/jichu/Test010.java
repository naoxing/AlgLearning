package com.xiaojiang.jichu;

/**
 * @Author xiaojiang
 * @Date 2023-04-29 21:44
 * @Description 441.排列硬币
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 **/
public class Test010 {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(19));
        System.out.println(arrangeCoins1(19));
        System.out.println(arrangeCoins2(19));
        System.out.println(arrangeCoins3(19));
    }
    //我很暴力
    public static int arrangeCoins(int n) {
        for (int i = 1; i <= n; i++) {
            if(i*(i+1)<=2*n && 2*n<(i+1)*(i+2)){
                return i;
            }
        }
        return 0;
    }
    //他也很暴力
    public static int arrangeCoins1(int n) {
        for (int i = 1; i <= n; i++) {
            n = n - i;
            if(n<=i){
                return i;
            }
        }
        return 0;
    }

    //又是二分
    public static int arrangeCoins2(int n) {
        long left = 0;
        long right = n;
        while(left<=right){
            long mid = (right-left)/2 + left;
            long cost = (mid+1)*mid/2;
            if(n==cost){
                return (int)mid;
            }else if(n<cost){
                right=mid-1;
            }else {
                left = mid+1;
            }
        }
        return (int)right;
    }

    //牛顿迭代  res = (i+x/i)/2
    public static int arrangeCoins3(int n) {

        return (int)sqrt(n,n);
    }

    private static double sqrt(double x,int n){
        double res = (x + (2*n-x)/x)/2;
        if(res == x){
            return x;
        }else {
            return sqrt(res,n);
        }
    }


}
