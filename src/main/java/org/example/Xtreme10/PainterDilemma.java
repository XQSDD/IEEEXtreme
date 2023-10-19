package org.example.Xtreme10;

import java.util.Arrays;
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
     * 输出更改其中一个画笔的最小次数
     * 思路：
     * 贪心算法
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] colors = new int[n];
            for (int j = 0; j < n; j++) {
                colors[j] = sc.nextInt();
            }
            // 实现贪心算法
            // 两把刷子更改颜色次数
            int brushColor1 = -1;
            int brushColor2 = -1;
            int changeCount = 0;

            for (int j = 0; j < n; j++) {
                if (brushColor1 == colors[j] || brushColor2 == colors[j]) {
                    continue;
                }
                if (brushColor1 == -1) {
                    brushColor1 = colors[j];
                    changeCount++;
                } else if (brushColor2 == -1) {
                    brushColor2 = colors[j];
                    changeCount++;
                } else {
                    for (int k = j + 1; k < n; k++) {
                        if (brushColor1 == colors[k]) {
                            brushColor2 = colors[j];
                            changeCount++;
                            break;
                        } else if (brushColor2 == colors[k]) {
                            brushColor1 = colors[j];
                            changeCount++;
                            break;
                        }
                    }
                    if (brushColor1 != colors[j] && brushColor2 != colors[j]) {
                        brushColor1 = colors[j];
                        changeCount++;
                    }
                }
            }
            System.out.println(changeCount);
        }
    }
}
