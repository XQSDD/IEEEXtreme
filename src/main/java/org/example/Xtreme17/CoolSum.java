package org.example.Xtreme17;

import java.util.Scanner;

/**
 * @author pc
 * @description 给两个整数k和n
 * 定义一个序列
 * 你的任务是找到a0，a1，。。。，a2k-1
 * 由于计算可能非常大，所以所有计算应该采用998244353模进行
 * @create 2023/10/28 16:31
 */
public class CoolSum {
    static final long MOD = 998244353L;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        long[] a = new long[1 << k];



        for (int i = 0; i <= n; i++) {
            int index = i % (1 << k);
            if (index % Math.pow(2, k) == index) {
                a[index] = (a[index] + combination(n, i)) % MOD;
            }
        }

        for (long val : a) {
            System.out.print(val + " ");
        }
    }

    // public static int calculateCombination(int n, int i) {
    //     int combination = 1;
    //     for (int j = 1; j <= i; j++) {
    //         combination *= n;
    //         combination /= j;
    //         n--;
    //     }
    //     return combination;
    // }
    public static int combination(int n, int k) {
        int[][] dp = new int[n+1][k+1];

        // 初始化边界条件
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // 计算组合数
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        return dp[n][k];
    }
}
