package com.xiaojiang.jichu;

/**
 * @Author xiaojiang
 * @Date 2023-04-27 16:25
 * @Description 素数个数统计(除0,1外)
 **/
public class Test001 {
    public static void main(String[] args) {
        System.out.println(bf(100)); //暴力求解
        System.out.println(eratosthenes(100)); //埃式筛选
    }

    //埃式筛选
    //false:素数 true:合数 2*2=4 2*3=6 ...
    //j=2*i ==> 优化成 j=i*i ;之前的数不用遍历了
    public static int eratosthenes(int n){
        boolean[] isPrime = new boolean[n]; //全是素数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(!isPrime[i]){
                count++;
                for(int j=i*i;j<n;j+=i){ //j是合数的标志位
                    isPrime[j]=true;
                }
            }
        }
        return count;
    }


    //暴力求法
    public static int bf(int n){
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i)? 1 : 0;
        }
        return count;
    }

    private static boolean isPrime(int n){
        for (int i = 2; i <= n/2; i++) {
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
