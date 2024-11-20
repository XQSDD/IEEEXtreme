package org.example.Xtreme17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author pc
 * @description 长队伍
 * 排队时，有些人比其他人更引人注目，这与身高有很大关系。在这个问题中，我们定义当且仅当出现以下情况时，一个人 i 才会被另一个人 j 注意到：
 * i 站在 j 的前面，并且
 * 在 i 和 j 之间没有和 i 一样高或比 i 更高的人。
 * 根据排队者的身高和这些定义，你可以数出一行中有多少人值得注意。
 * @create 2023/10/28 9:23
 */
public class LongLines {
    /**
     * 输入：
     * 5个空格分割数字组成n，h0，a，c，q
     * n是人数
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 人数
        int[] heights = new int[n];

        heights[0] = sc.nextInt(); // 第一个人的身高
        int a = sc.nextInt(); // 计算参数 a
        int c = sc.nextInt(); // 计算参数 c
        int q = sc.nextInt(); // 计算参数 q

        // 根据公式计算每个人的身高
        for (int i = 1; i < n; i++) {
            heights[i] = (a * heights[i - 1] + c) % q;
        }
        // System.out.println(Arrays.toString(heights));

        int count = 0; // 值得注意的人的数量

        int[] notices = new int[n];
        notices[0] = 0;
        notices[1] = 1;

        for (int i = 2; i < n; i++) {
            notices[i] = 1;
            int j = i - 1;
            while (j >= 1) {
                if (heights[j] < heights[j-1]){
                    if (j == i-1) {
                        notices[i] += notices[j];
                        break;
                    } else if (heights[j] > heights[i-1]) {
                        notices[i] += notices[j] + 1;
                        break;
                    }
                }
                j--;
            }
        }
        // System.out.println(Arrays.toString(notices));

        for (int notice : notices) {
            count += notice;
        }

        // int sum = 0;
        // for (int i = 1; i < n; i++) {
        //     // System.out.println(i);
        //     count++;
        //     // 如果前一个人比自己高，只能看到前一个
        //     if (i < 2) {
        //         continue;
        //     }
        //     // if ()
        //     sum = findOrderCount(heights, i);
        //     count += sum;
        //     // System.out.println(count);
        // }
        System.out.println(count);

        sc.close();
    }



    static int findOrderCount(int[] heights, int end) {
        if (heights.length == 1) {
            return 1;
        }
        // System.out.println(Arrays.toString(heights));
        int left = 0;
        int right = end - 1;

        int count = 0;
        int rightValue = heights[right];
        int leftMax;
        List<Integer> maxList = new ArrayList<>();
        while (left < right) {
            int maxIndex = findMaxIndex(heights, left, right);
            // System.out.println("maxIndex: " + maxIndex);
            leftMax = heights[maxIndex];
            // 如果前一位比自己高的情况，那么在往前每一个最高值都得比他高
            if (leftMax <= rightValue) {
                break;
            }
            maxList.add(leftMax);
            count++;
            left = maxIndex;
        }
        // System.out.println(end + " " + maxList);
        return count;

    }

    static int findMaxIndex(int[] heights, int left, int right) {
        int maxIndex = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (heights[i] > heights[maxIndex]) {
                maxIndex = i;
            }
        }
        // System.out.println("maxIndex:" + maxIndex);
        return maxIndex;
    }
}
