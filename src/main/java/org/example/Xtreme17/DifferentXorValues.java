package org.example.Xtreme17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author pc
 * @description 功能描述
 * @create 2023/10/29 3:20
 */
public class DifferentXorValues {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] parts = br.readLine().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(parts[i]);
            }
            System.out.println(maxMoves(n, a));
        }
    }

    public static int maxMoves(int n, int[] a) {
        long total = 0;
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                total += uniqueXORs(a, l, r);
                total %= MOD;
            }
        }
        return (int) (total);
    }

    private static int uniqueXORs(int[] a, int l, int r) {
        Set<Integer> xorResults = new HashSet<>();

        for (int i = l; i <= r; i++) {
            int currentXOR = a[i];
            xorResults.add(currentXOR);
            for (int j = i + 1; j <= r; j++) {
                currentXOR ^= a[j];
                xorResults.add(currentXOR);
            }
        }

        xorResults.add(0);

        return xorResults.size();
    }
}
