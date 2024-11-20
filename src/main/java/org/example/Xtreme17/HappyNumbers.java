package org.example.Xtreme17;

import java.util.Scanner;

/**
 * @author pc
 * @description 快乐数字
 * 从 n 开始，将其替换为数字的平方和。
 * 重复这个过程，直到数字到达 1（在这里它将永远快乐），或者重复一个不包含 1 的无限循环。
 * 这个过程以 1 结尾的数字就是幸福数字。
 * 例如，23 是一个幸福的数字：23 -> 13 -> 10 -> 1 -> 1。
 * @create 2023/10/28 11:53
 */
public class HappyNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isHappy(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = happyNumber(n);

        while (fast != 1 && slow != fast) {
            slow = happyNumber(slow);
            fast = happyNumber(happyNumber(fast));
        }

        return fast == 1;
    }
    public static int happyNumber(int n){
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
