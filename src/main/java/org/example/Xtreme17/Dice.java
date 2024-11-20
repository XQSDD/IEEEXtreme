package org.example.Xtreme17;

import java.util.Scanner;

/**
 * @author pc
 * @description 骰子
 * 让我们从 1 到 k 中均匀随机地选择一个整数 t。
 * 现在让我们掷 t 个标准的六面骰子。
 * 这些骰子掷出的数值之和正好是 n?
 * @create 2023/10/28 22:49
 */
public class Dice {
    /**
     * 第一行两个整数n和k
     * 输出：
     * 答案可以用有理数P/Q表示，其中Q mod 998244353 不等于0
     * 输出一个值
     */

    public static int MOD = 998244353;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[][] dp = new long[k + 1][n + 1];
        dp[0][0] = 1;

        for (int t = 1; t <= k; t++) {
            for (int s = 1; s <= 6; s++) {
                for (int i = s; i <= n; i++) {
                    dp[t][i] = (dp[t][i] + dp[t - 1][i - s]) % MOD;
                }
            }
        }

        // Calculate the total number of ways to roll t dice
        long totalWays = 0;
        for (int t = 1; t <= k; t++) {
            totalWays = (totalWays + dp[t][n]) % MOD;
        }

        // Calculate the probability
        long numerator = totalWays;
        long denominator = k;
        long inverseDenominator = modInverse(denominator, MOD);
        System.out.println(inverseDenominator);

        long probability = (numerator * inverseDenominator) % MOD;
        System.out.println(probability);
        long result = (probability * modInverse(MOD - 1, MOD)) % MOD;

        System.out.println(result);
    }

    // Calculate the modular inverse of a number
    private static long modInverse(long number, long mod) {
        long result = 1;
        long base = number;

        while (mod > 0) {
            if (mod % 2 == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;
            mod /= 2;
        }

        return result;
    }
}
