package org.example.utils.dp;

import java.util.List;

/**
 * @author pc
 * @description 自顶向下
 * @create 2023/10/27 22:20
 */
public class UpBotton {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 1、状态定义：dp[i][j] 表示从0,0出发，到达i,j的最短路径
        int[][] dp = new int[triangle.size()][triangle.size()];
        // 2、初始化
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                // 这里分为三种情况：
                // 1、上一层没有左边值
                // 2、上一层没有右边值
                // 3、其他
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i-1][j-1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + triangle.get(i).get(j);
                }
            }
        }
        // 从最后一层中查找最小值
        int minValue = dp[triangle.size() - 1][0];
        for (int i = 0; i < triangle.size(); i++) {
            minValue = Math.min(minValue, dp[triangle.size() - 1][i]);
        }
        return minValue;
    }

    public static void main(String[] args) {

    }
}
