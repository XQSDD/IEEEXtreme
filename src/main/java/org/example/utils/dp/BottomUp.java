package org.example.utils.dp;

import java.util.List;

/**
 * @author pc
 * @description 动态规划就是把大问题变成小问题，并解决了小问题重复计算的方法称为动态规划
 *
 * 动态规划和 DFS 区别
 *
 * 二叉树 子问题是没有交集，所以大部分二叉树都用递归或者分治法，即 DFS，就可以解决
 * 像 triangle 这种是有重复走的情况，子问题是有交集，所以可以用动态规划来解决
 * @create 2023/10/27 22:19
 */
public class BottomUp {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 1、状态定义：f[i][j] 表示从i,j出发，到达最后一层的最短路径
        int[][] dp = new int[triangle.size()][triangle.size()];
        // 2、初始化
        for (int i = 0; i < triangle.size(); i++) {
            dp[triangle.size() - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }
        // 3、递推求解
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        // 4、结果
        return dp[0][0];
    }

    public static void main(String[] args) {

    }
}
