package org.example.Xtreme10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author pc
 * @description 画家困境
 * 尽可能减少更换画笔颜色的次数，以获得更多的收入。
 * @create 2023/10/18 20:25
 */
public class PainterDilemma {
    /**
     * 标准输入：
     * 第一行方案数量t
     * 每个方案两行，第一行整数N，需要用到的颜色序列长度，第二行包含N个整数c1-cn，需要用到的颜色序列，按照需要的顺序排列
     * 标准输出：
     * 输出更改两支画笔的最小次数总和
     * 思路：
     * 贪心算法
     * 按照颜色序列向后遍历，每次和后面每一种颜色进行对比，如果有刷子颜色在后面存在，就改变另一把刷子颜色，如果都不存在，就随便改变一把刷子颜色。
     */
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int t = sc.nextInt();
    //     for (int i = 0; i < t; i++) {
    //         int n = sc.nextInt();
    //         int[] colors = new int[n];
    //         for (int j = 0; j < n; j++) {
    //             colors[j] = sc.nextInt();
    //         }
    //         // 两把刷子更改颜色次数
    //         int brushColor1 = -1;
    //         int brushColor2 = -1;
    //         int changeCount = 0;
    //
    //         for (int j = 0; j < n; j++) {
    //             if (brushColor1 == colors[j] || brushColor2 == colors[j]) {
    //                 continue;
    //             }
    //             if (brushColor1 == -1) {
    //                 brushColor1 = colors[j];
    //                 changeCount++;
    //             } else if (brushColor2 == -1) {
    //                 brushColor2 = colors[j];
    //                 changeCount++;
    //             } else {
    //                 for (int k = j + 1; k < n; k++) {
    //                     if (brushColor1 == colors[k]) {
    //                         brushColor2 = colors[j];
    //                         changeCount++;
    //                         break;
    //                     } else if (brushColor2 == colors[k]) {
    //                         brushColor1 = colors[j];
    //                         changeCount++;
    //                         break;
    //                     }
    //                 }
    //                 if (brushColor1 != colors[j] && brushColor2 != colors[j]) {
    //                     brushColor1 = colors[j];
    //                     changeCount++;
    //                 }
    //             }
    //         }
    //         System.out.println(changeCount);
    //     }
    // }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        List<List<Integer>> walls =new ArrayList<>();


        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt(); // 颜色序列长度
            scanner.nextLine(); // 读取换行符
            String[] colors = scanner.nextLine().split(" ");
            System.out.println(minChanges(n,colors));
        }
    }

    private static int minChanges(int n, String[] colors) {

        String brush1 = colors[0];
        String brush2 = "";
        int changes = 1;

        for (int i = 1; i < colors.length; i++) {
            if(brush2.equals("") && !colors[i].equals(brush1)){
                brush2 = colors[i];
                changes++;
                continue;
            }

            if (!colors[i].equals(brush1) && !colors[i].equals(brush2)) {
                for (int j = i + 1; j < n; j++) {
                    if (colors[j].equals(brush1)) {
                        brush2 = colors[i];
                        changes++;
                        break;
                    } else if (colors[j].equals(brush2)){
                        brush1 = colors[i];
                        changes++;
                        break;
                    }
                }
                if (!colors[i].equals(brush1) && !colors[i].equals(brush2)) {
                    brush1 = colors[i];
                    changes++;
                }
            }
        }

        return changes;
    }
}
