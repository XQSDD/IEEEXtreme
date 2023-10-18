package org.example.Xtreme14;

import java.util.Scanner;

/**
 * @author yxs
 * @description 通过汉明距判断优惠码有多少对是相似的
 * 汉明距是1，那么就是相似的
 * @create 2023/10/17 20:35
 */
public class CouponCodes {
    /**
     * 计算两个优惠码汉明距
     * @param C1
     * @param C2
     * @return
     */
    public int hammingDistance(String C1, String C2) {
        if (C1 == null || C2 == null) {
            return 0;
        } else if (C1.length() != C2.length()) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < C1.length(); i++) {
            if (C1.charAt(i) != C2.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 计算优惠码有多少对是相似的
     */
    public int countSimilarCodes() {
        // 标准化多行输入
        System.out.println("Input:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 将后面n行存成一个列表
        String[] codes = new String[n];
        for (int i = 0; i < n; i++) {
            String code = sc.next();
            // 去除字符串中的-
            codes[i] = code.replaceAll("-", "");
        }
        sc.close();
        // 计算codes中两两的汉明距，汉明距为1就加1
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (hammingDistance(codes[i], codes[j]) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 开始时间
        long start = System.currentTimeMillis();
        CouponCodes cc = new CouponCodes();
        System.out.println(cc.countSimilarCodes());
        // 结束时间
        long end = System.currentTimeMillis();
        System.out.println("Runtime：" + (end - start) + "ms");;
    }
}
