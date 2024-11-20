package org.example.Xtreme17;

import java.util.Scanner;

/**
 * @author pc
 * @description 凯撒在现
 * 凯撒密码是一种简单的加密技术，被凯撒大帝用来向他的盟友发送秘密信息。它的工作原理是将明文信息中的字母移动一定的位置。解密是通过向后移动相同数量的位置来实现的。
 *
 * 要加密明文信息或解密密文信息，需要一个实现这种技术的程序。空格不受加密或解密的影响。
 *
 * 您需要确定所提供的值是明文还是密文。如果提供的值是明文，则应根据上述移位值输出加密信息。如果提供的值是密文，则应输出解密后的信息。
 * @create 2023/10/28 8:00
 */
public class CaesarRedux {
    /**
     * 输入：
     * 一个整数n，表示信息的数量
     * 接下来2n行包含一行位移数量和一行明文或密码
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int shift = sc.nextInt();
            sc.nextLine();
            String message = sc.nextLine();
            // 将密码向后移动一定位置
            StringBuilder message2 = new StringBuilder();
            // todo 如何确定是明文还是密文呢
            // 加密
            if (isPlaintext(message)) {
                for (int j = 0; j < message.length(); j++) {
                    char c = message.charAt(j);
                    if (c >= 'a' && c <= 'z') {
                        char cl = (char) ((c - 'a' - shift + 26) % 26 + 'a');
                        message2.append(cl);
                    } else if (c >= 'A' && c <= 'Z') {
                        char cl = (char) ((c - 'A' - shift + 26) % 26 + 'A');
                        message2.append(cl);
                    } else {
                        message2.append(c);
                    }
                }
            } else {
                for (int j = 0; j < message.length(); j++) {
                    char c = message.charAt(j);
                    if (c >= 'a' && c <= 'z') {
                        char cl = (char) ((c - 'a' + shift) % 26 + 'a');
                        message2.append(cl);
                    } else if (c >= 'A' && c <= 'Z') {
                        char cl = (char) ((c - 'A' - shift + 26) % 26 + 'A');
                        message2.append(cl);
                    } else {
                        message2.append(c);
                    }
                }
            }
            System.out.println(message2);
        }
    }

    static boolean isPlaintext(String message) {
        String[] words = message.split(" ");
        for (String word : words) {
            if (word.equalsIgnoreCase("the")) {
                return true;
            }
        }
        return false;
    }
}
