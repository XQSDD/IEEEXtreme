package org.example.utils.dp;

/**
 * @author pc
 * @description 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 等价于0-1背包问题，只不过目标为数组和的一半。状态转移可以参考题解：动态规划（转换为 0-1 背包问题）。
 * @create 2023/10/27 22:38
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        // 首先计算数组的和
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        // 如果和不是2的倍数则肯定无法分割
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        // dp[i][j]表示从数组的[0, i]子区间内挑选一些正整数(每个数只能用一次)使得这些数的和恰好等于j
        boolean[][] dp = new boolean[nums.length][sum + 1];
        if (nums[0] <= sum) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                // 注意这里的状态转移方程
                if (nums[i] == j) {
                    dp[i][j] = true;
                } else if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i-1][j-nums[i]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length - 1][sum];
    }

    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartition(new int[]{1, 5, 11, 5}));
    }
}
