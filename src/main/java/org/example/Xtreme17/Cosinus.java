package org.example.Xtreme17;

import java.util.Scanner;

/**
 * @author pc
 * @description 功能描述
 * @create 2023/10/29 5:39
 */
public class Cosinus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            double angle = scanner.nextDouble();
            int n = findSmallestN(angle);
            System.out.println(n);
        }
    }

    public static int findSmallestN(double angle) {
        // double cosValue = Math.cos(Math.toRadians(angle));
        int n = 1; // 初始n值
        double minAbsCos = Math.abs(Math.cos(n * Math.toRadians(angle))); // 初始最小绝对值

        while (true) {
            double absCos = Math.abs(Math.cos(n * Math.toRadians(angle))); // 计算cos(n*a)的绝对值
            if (absCos < minAbsCos) {
                minAbsCos = absCos;
            } else {
                // 当绝对值开始增大时，说明已经找到了局部最小值
                break;
            }
            n++;
        }
        return n;
    }
}
