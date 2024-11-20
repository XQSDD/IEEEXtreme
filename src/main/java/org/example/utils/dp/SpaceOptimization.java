package org.example.utils.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author pc
 * @description 空间优化
 * 经过观察发现当前状态只与上一批状态有关，所以二维数组可以优化为一位数组，减少空间占用
 * @create 2023/10/27 22:21
 */
public class SpaceOptimization {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        SpaceOptimization spaceOptimization = new SpaceOptimization();
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        System.out.println(spaceOptimization.minimumTotal(triangle));
    }
}
