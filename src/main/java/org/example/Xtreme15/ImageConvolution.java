package org.example.Xtreme15;

import java.util.Scanner;

/**
 * @author yxs
 * @description 实现图像卷积识别物体简化版
 * @create 2023/10/18 10:49
 */
public class ImageConvolution {
    /**
     * 标准输入：
     * 第一行输入一个整数T，测试用例数量
     * 每个测试用例有R和C，节下来R行有C和字符，表示图像的一行像素，每个字符要么是哈希值，要么是点。
     *
     * 标准输出：
     * 对于每个测试用例，单行输出图像中出现图案的次数。
     */

    /**
     * 实现卷积
     * @param kernel
     * @param image
     * @return
     */
    public int Conv(char[][] kernel, char[][] image) {
        // 从左上到右下进行卷积，输出和卷积核一样的数量
        int result = 0;
        for (int i = kernel.length / 2; i < image.length - Math.ceil(kernel.length / 2.) + 1; i++) {
            for (int j = (kernel[0].length / 2); j < image[0].length - Math.ceil(kernel[0].length / 2.) + 1; j++) {
                // 判断两个数组中的所有元素是否相等
                int sum = 0;
                for (int k = 0; k < kernel.length; k++) {
                    for (int l = 0; l < kernel[0].length; l++) {
                        if ((image[i - (kernel.length / 2) + k][j - (kernel[0].length / 2) + l] == kernel[k][l]) || (kernel[k][l] == '?')) {
                            sum++;
                        }
                    }
                }
                // System.out.println("+++++++");
                // System.out.println(i);
                // System.out.println(sum);
                // System.out.println(kernel.length * kernel[0].length);
                if (sum == kernel.length * kernel[0].length) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Input:");
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] image = new char[r][c];
        for (int i = 0; i < r; i++) {
            image[i] = sc.next().toCharArray();
        }
        // System.out.println(Arrays.deepToString(image));
        System.out.println("Output:");
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            char[][] kernel = new char[a][b];
            for (int j = 0; j < a; j++) {
                kernel[j] = sc.next().toCharArray();
            }
            ImageConvolution ico = new ImageConvolution();
            System.out.println(ico.Conv(kernel, image));
        }
    }
}
