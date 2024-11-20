package org.example.utils.dp;

import java.util.List;

/**
 * @author pc
 * @description 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * @create 2023/10/27 22:14
 */
public class MinimumTotal {
    //优化 DFS，缓存已经被计算的值（称为：记忆化搜索 本质上：动态规划）
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] saves = new int[triangle.size()][triangle.size()];
        return dfs(0, 0, triangle, saves);
    }

    // 使用saves数组记录已经被计算过的值
    // 返回值表示从x, y处到底部的最小路径和
    private int dfs(int x, int y, List<List<Integer>> triangle, int[][] saves) {
        if (x == triangle.size() - 1) {
            return triangle.get(x).get(y);
        }
        // 如果已经被计算过则直接返回
        if (saves[x][y] != 0) {
            return saves[x][y];
        }
        int minLeft = dfs(x + 1, y, triangle, saves);
        int minRight = dfs(x + 1, y + 1, triangle, saves);
        // 缓存已经被计算的值
        saves[x][y] = Math.min(minLeft, minRight) + triangle.get(x).get(y);
        return saves[x][y];
    }

    public static void main(String[] args) {
        MinimumTotal minimumTotal = new MinimumTotal();
    }

}
