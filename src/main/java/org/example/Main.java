package org.example;

/**
 * @author ${USER}
 * @description 功能描述
 * @create ${DATE} ${TIME}
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 3, 4, 1};
        int[] result = findMaxDescendingArray(arr);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] findMaxDescendingArray(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int maxLen = 0;
        int endIndex = -1;

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dp[i][j] = dp[j][i - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i;
                    }
                } else {
                    dp[i][j] = 1;
                }
            }
        }

        int[] result = new int[maxLen];
        for (int i = maxLen - 1; i >= 0; i--) {
            result[i] = arr[endIndex];
            endIndex--;
        }

        return result;
    }

}