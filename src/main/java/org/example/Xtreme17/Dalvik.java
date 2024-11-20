package org.example.Xtreme17;

import java.util.Scanner;

/**
 * @author pc
 * @description 达尔维克
 * 给定下面的 smali 代码，编写一个程序，在给定三个输入值的情况下，返回输出值。
 * @create 2023/10/28 21:21
 */
public class Dalvik {
    /**
     * 输入包含一个整数，第一行是测试用例数量T
     * 接下来每行有三个整数A, B , C
     * 每个测试用例输出R
     */

    public static void main (String[] args) throws java.lang.Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long A = sc.nextInt();
            long B = sc.nextInt();
            long C = sc.nextInt();
            System.out.println(translateCode(A,B,C));
        }
    }
    public static long translateCode(long A, long B, long C) {
        long v3 = 1;
        long v4 = 0;

        long v6 = v3;

        long v9 = A + B;
        long v10 = v4;
        long v12 = v3;

        while (v12 <= C) {
            v10 += A;
            long v13 = v10;

            while (true) {
                long v16 = v13 + v13;
                if (v16 > B) {
                    v13 -= B;
                } else {
                    break;
                }
            }
            if (v13 <= v4) {
                v13 = v4 - v13;
            }
            long v17 = v4;
            long v18 = v3;

            while (v18 <= v6) {
                v17 += v13;
                v18 += v3;
            }
            v18 = v3;
            while (v18 <= v12) {
                v17 -=  v9;
                v18 +=  v3;
            }

            if (v17 < v4) {
                v6 = v12;
                v9 = v13;
            }
            v12 += v3;
        }
        return v6;
    }
}
