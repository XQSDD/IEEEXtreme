// package org.example.Xtreme17;
//
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
// import java.util.Scanner;
//
// /**
//  * @author pc
//  * @description 组合锁再现
//  * 锁由以下部分组成 n个轮子，每个轮子上都有 0 到 9 的数字。在电子版锁中，你可以一次转动任意一个轮子。由于轮子上的数字是环绕的，因此在三轮锁上，您可以从 000 转到以下任何一个位置： 001、010、100、009、090 或 900。
//  * 电子版锁总是从所有 0 开始。要解锁，必须将锁切换到目标代码，而且在切换到目标代码的过程中经过的每个位置都必须在允许位置列表中。
//  * 允许位置列表由以下定义的序列生成：
//  * hi = （a * hi-1 + b） mod q
//  *一旦可以从起始位置到达目标代码，序列就会终止。
//  *
//  * 本挑战的任务是评估在给定锁的情况下是否有可能到达目标代码。如果可能，您还将确定达到目标代码所需的最小更改次数，以及使用最小更改次数达到目标代码的不同方法的数量。由于达到目标的不同方法的数量可能很大，因此应输出计数的模数
//  * @create 2023/10/29 2:47
//  */
// public class ComboLockRedux {
//     /**
//      * 输入：
//      * 第一行c表示提供了多少种锁配置
//      * 后面每行：
//      * n 表示锁的轮数。
//      * t 是一个 n 位字符串，表示目标代码
//      * h_0 是允许值序列的第一个值。请注意，允许值应从 h_0 生成。
//      * a、b、q 是用于计算允许值序列的值，如上所述。
//      *
//      * 输出：
//      * 如果没有办法用允许值到达最终代码，输出-1
//      * 如果有，输出最小更改次数和不同方法数，取模10^9+9,空格隔开
//      */
//
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int c = sc.nextInt();
//         for (int i = 0; i < c; i++) {
//             int n = sc.nextInt();
//             int t = sc.nextInt();
//             int h0 = sc.nextInt();
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             int q = sc.nextInt();
//
//             char[] targetDigits = Integer.toString(t).toCharArray();
//             System.out.println(targetDigits);
//
//             List allowedValues = generateAllowedValues(h0, a, b, q, t, n);
//
//             System.out.println(allowedValues);
//
//             int minChanges = Integer.MAX_VALUE;
//             int count = 0;
//
//             for (Object allowedValue : allowedValues) {
//                 char[] currentDigits = Integer.toString((Integer) allowedValue).toCharArray();
//                 int value = (int) allowedValue;
//
//                 int changes = calculateChanges(currentDigits, targetDigits);
//
//                 if (changes < minChanges) {
//                     minChanges = changes;
//                     count = 1;
//                 } else if (changes == minChanges) {
//                     count++;
//                 }
//             }
//
//             System.out.println(minChanges + " " + count);
//         }
//         sc.close();
//     }
//     public static List generateAllowedValues(int h0, int a, int b, int q, int t, int n) {
//         List<Integer> allowedValues = new ArrayList<>();
//         allowedValues.add(h0);
//
//         while (true) {
//             int value = (a * allowedValues.get(allowedValues.size() - 1) + b) % q;
//             char[] valueArray = Integer.toString(value).toCharArray();
//             // if (valueArray[0]) {
//             //     break;
//             // } else {
//             //     allowedValues.add(value);
//             // }
//         }
//
//         return allowedValues;
//     }
//
//     public static int calculateChanges(char[] currentDigits, char[] targetDigits) {
//         int changes = 0;
//
//         for (int i = 0; i < currentDigits.length; i++) {
//             int diff = Math.abs(currentDigits[i] - targetDigits[i]);
//             changes += Math.min(diff, 10 - diff);
//         }
//         return changes;
//     }
//
//     public static boolean isArrived(int value, int t, int n) {
//         int count = 0;
//         for (int i = 0; i < n; i++) {
//             if (i == 0 && value % Math.pow(10, i + 1) - t / Math.pow(10, i + 1) == 0) {
//                 count++;
//             }
//             if (value / Math.pow(10, i + 1) - t / Math.pow(10, i + 1) == 0) {
//                 count++;
//             }
//         }
//     }
// }
