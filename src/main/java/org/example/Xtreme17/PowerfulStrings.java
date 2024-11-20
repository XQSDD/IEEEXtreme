package org.example.Xtreme17;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pc
 * @description Powerful Strings
 * @create 2023/10/29 0:56
 */
public class PowerfulStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] S = new String[M];
        for (int i = 0; i < M; i++) {
            S[i] = sc.next();
        }
        System.out.println(powerfulStrings(N, M, S));
    }

    private static long powerfulStrings(int N, int M, String[] S) {
        long powerSum = 0;
        int[] count = new int[M];
        for (int i = 0; i < N; i++) {
            count[0] = 0;
            count[1] = 0;
            for (String s : S) {
                if (i < s.length()) {
                    char c = s.charAt(i);
                    if (c == 'a') {
                        count[0]++;
                    } else if (c == 'b') {
                        count[1]++;
                    }
                } else {
                    break;
                }
            }
            powerSum += Math.pow(2, count[0]) * Math.pow(2, count[1]);
        }
        return powerSum % 998244353;
    }
}
