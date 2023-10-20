package org.example.Xtreme11;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pc
 * @description 功能描述
 * @create 2023/10/19 18:40
 */
public class BeetleBag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {

            // 背包容量和工具数量
            int capacity = scanner.nextInt();
            int n = scanner.nextInt();

            // 工具重量和战斗力
            int[] weight = new int[n];
            int[] value = new int[n];
            for (int j = 0; j < n; j++) {
                weight[j] = scanner.nextInt();
                value[j] = scanner.nextInt();
            }
            System.out.println(getMaxPower(capacity, weight,value,n));

        }
    }

    private static int getMaxPower(int capacity, int[] weight, int[] value, int n) {
        int[][] dp = new int[n][capacity+1];
        for (int j = 0; j < capacity+1; j++) {
            if(weight[0] <= j){
                dp[0][j]=value[0];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < capacity+1; j++) {
                if (weight[i]<=j) {
                    dp[i][j] = Integer.max(value[i] + dp[i-1][j-weight[i]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n-1][capacity];
    }
}
