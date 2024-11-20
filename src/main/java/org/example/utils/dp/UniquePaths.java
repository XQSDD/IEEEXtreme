package org.example.utils.dp;

/**
 * @author pc
 * @description 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 * @create 2023/10/27 22:25
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        // dp[i][j] 表示0,0到i,j的路径数
        int[] dp = new int[n];
        // 初始化：到达第一行的路径数均为1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 每行第一个格子只有一条路到达
                if (j == 0) {
                    dp[j] = 1;
                }
                // 其他格子可以由左侧或上方的格子到达
                else {
                    dp[j] = dp[j-1] + dp[j];
                }
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 7));
        System.out.println(uniquePaths.uniquePaths(3, 2));
        System.out.println(uniquePaths.uniquePaths(7, 3));
        System.out.println(uniquePaths.uniquePaths(3, 3));
    }
}
