package org.example.utils.dp;

/**
 * @author pc
 * @description 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回  -1。
 *
 * 思路：和其他 DP 不太一样，i 表示钱或者容量
 * @create 2023/10/27 22:36
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // 状态 dp[i]表示金额为i时，组成的最小硬币个数
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 初始化为最大值
            int minNum = Integer.MAX_VALUE;
            for (int n : coins) {
                if (i - n >= 0) {
                    // 如果上个金额也无法组成，则直接标记
                    if (dp[i - n] == -1) {
                        dp[i] = -1;
                        continue;
                    } else {
                        minNum = Math.min(minNum, dp[i - n] + 1);
                    }
                } else if (i % n == 0) {
                    minNum = i / n;
                }
            }
            dp[i] = (minNum == Integer.MAX_VALUE ? -1 : minNum);
        }
        return dp[amount];
    }

    // 第二种方法
    // 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
    public int change(int amount, int[] coins) {
        // 状态 dp[i]表示金额为i时，组合的方法数
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        // 先遍历物品再遍历背包
        for (int n : coins) {
            for (int i = n; i <= amount; i++) {
                dp[i] += dp[i - n];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange.coinChange(coins, amount));
        System.out.println(coinChange.change(amount, coins));
    }
}
