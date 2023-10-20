package org.example.Xtreme15;

import java.util.*;

/**
 * @author pc
 * @description 着色瓷砖
 * 一堵墙N行M列瓷砖，有一些瓷砖能着色，用C种颜料，在2*2中不能有三个相同颜色单元，
 * 求着色方案数，答案对1000000007取模
 * @create 2023/10/19 16:38
 */
public class ColoringTiles {
    /**
     * 标准输入：
     * 第一行测试用例数T
     * 每个例子有三个整数N,M,C
     * 接下来N行M列
     * .表示可着色，#表示不可着色
     * 标准输出：
     * 输出上色方式数
     * 思路：动态规划
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int C = sc.nextInt();
            char[][] tiles = new char[N][M];
            for (int j = 0; j < N; j++) {
                tiles[j] = sc.next().toCharArray();
            }
            colorTiles(N, M, C, tiles);
        }
    }

    public static void colorTiles(int N, int M, int C, char[][] tiles) {
        int[][][] dp = new int[N][M][C];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < C; k++) {
                    if (tiles[i][j] == '#') {
                        dp[i][j][k] = 0;
                    } else if (i == 0 && j == 0) {
                        dp[i][j][k] = 1;
                    } else {
                        dp[i][j][k] = 0;
                        for (int x = Math.max(0, i - 1); x <= Math.min(N - 1, i + 1); x++) {
                            for (int y = Math.max(0, j - 1); y <= Math.min(M - 1, j + 1); y++) {
                                if ((x == i && y == j) || tiles[x][y] == '#') {
                                    continue;
                                }
                                dp[i][j][k] += dp[x][y][k];
                                dp[i][j][k] %= 1000000007;
                            }
                        }
                    }
                }
            }
        }
        int total = 0;
        for (int k = 0; k < C; k++) {
            total += dp[N - 1][M - 1][k];
            total %= 1000000007;
        }
        System.out.println(total);
    }
}
