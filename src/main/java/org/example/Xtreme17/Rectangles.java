package org.example.Xtreme17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pc
 * @description 功能描述
 * @create 2023/10/29 5:34
 */
public class Rectangles {
    public static void main(String[] args) {
        int p = 1;
        int q = 12;
        int maxCount = getMaxCount(p, q);
        System.out.println(maxCount);
    }

    public static int getMaxCount(int p, int q) {
        List<int[]> rectangles = new ArrayList<>();

        // 生成满足条件的矩形尺寸
        for (int w = p; w <= q; w++) {
            for (int h = p; h <= q; h++) {
                if (isRelativePrime(w, h)) {
                    rectangles.add(new int[]{w, h});
                }
            }
        }

        int n = rectangles.size();
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int[] current = rectangles.get(i - 1);
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                int[] previous = rectangles.get(j - 1);
                if (isCompatible(current, previous)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxCount = 0;
        for (int i = 1; i <= n; i++) {
            maxCount = Math.max(maxCount, dp[i]);
        }

        return maxCount;
    }

    public static boolean isRelativePrime(int a, int b) {
        return gcd(a, b) == 1;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static boolean isCompatible(int[] rect1, int[] rect2) {
        return isRelativePrime(rect1[0], rect2[0]) &&
                isRelativePrime(rect1[1], rect2[1]) &&
                isRelativePrime(rect1[0], rect2[1]);
    }
}
