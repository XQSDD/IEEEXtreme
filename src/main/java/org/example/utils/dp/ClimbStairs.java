package org.example.utils.dp;

/**
 * @author pc
 * @description 爬楼梯
 * 假设你正在爬楼梯。需要  n  阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶？
 * @create 2023/10/27 22:28
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int[] dp = new int[]{0, 1};
        while (n > 0) {
            int temp = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = temp;
            n--;
        }
        return dp[1];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(4));
    }
}
