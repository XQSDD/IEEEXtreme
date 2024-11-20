package org.example.utils.dp;

/**
 * @author pc
 * @description 最长递增子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * @create 2023/10/27 22:29
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        // dp[i]表示从0到i的最长上升子序列长度
        int[] dp = new int[nums.length];
        // 初始化：到第一个元素序列长度为1
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            // 注意默认为1，即此处最长子序列为自身
            int maxLen = 1;
            // dp[i] = max(dp[j]) + 1 , nums[j] < nums[i]
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxLen = Math.max(maxLen, dp[j] + 1);
                }
            }
            dp[i] = maxLen;
        }
        int maxNum = 0;
        for (int n : dp) {
            maxNum = Math.max(maxNum, n);
        }
        // 答案：dp中的最大值
        return maxNum;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS.lengthOfLIS(nums));
    //    最长递增子序列是 [2,3,7,101]，因此长度为 4
    }
}
