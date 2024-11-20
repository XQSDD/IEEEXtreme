package org.example.utils.dp;

/**
 * @author pc
 * @description 最长公共子序列
 * 给定两个字符串  text1 和  text2，返回这两个字符串的最长公共子序列。
 * 一个字符串的   子序列   是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下
 * 删除某些字符（也可以不删除任何字符）后组成的新字符串。 例如，"ace" 是 "abcde" 的子序列，
 * 但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * @create 2023/10/27 22:33
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] a前i个和b前j个字符最长公共子序列
        // dp[m+1][n+1]
        //   ' a d c e
        // ' 0 0 0 0 0
        // a 0 1 1 1 1
        // c 0 1 1 2 1
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                // 相等取左上元素+1，否则取左或上的较大值
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcde", "ace"));
    }
}
