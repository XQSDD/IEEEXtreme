package org.example.utils.dp;

/**
 * @author pc
 * @description 最小路径和
 * 给定一个包含非负整数的  m x n  网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * @create 2023/10/27 22:24
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        // dp[i][j] 表示0,0到i,j的最小和
        int[] dp = new int[grid[0].length];
        // 初始化：用第一行初始化
        dp[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[i] = dp[i-1] + grid[0][i];
        }
        // 状态转移方程
        // 每行第一个元素：
        // dp[j] = dp[j](到上一行这个位置的最小和) + grid[i][j];
        // 后续元素：
        // dp[j] = Math.min(dp[j-1](到左边位置的最小和), dp[j](到上一行这个位置的最小和)) + grid[i][j];
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
                }
            }
        }
        // 答案
        return dp[grid[0].length - 1];
    }

    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum.minPathSum(grid));
    }
}
