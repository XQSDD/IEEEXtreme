package org.example.Xtreme15;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author pc
 * @description 单词搜索
 * 单词可能水平、垂直、对角线、反对角线或反向放置
 * @create 2023/10/18 15:34
 */
public class WordSearch {
    /**
     *标准输入：
     * 第一行三个整数R行，C列，Q个单词
     * R行后是Q个待搜索单词
     * 标准输出：
     * 输出位置：rs，cs，re，ce
     * 如果有多个搜索结果，输出具有最小位置的位置rs、cs、re、ce
     * 不存在搜索词则输出-1
     */

    public static int[] searchWord(char[][] words, char[] word) {
        // 在words数组中查找word是否存在，包括水平、垂直、对角线、反对角线及反向放置
        // 使用回溯法查找
        int rs = -1, cs = -1, re = -1, ce = -1;
        int R = words.length, C = words[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                // System.out.println("r:" + r + " c:" + c);
                if (words[r][c] == word[0]) {
                    // 先向右
                    if (c <= C - word.length) {
                        char[] tempR = new char[word.length];
                        for (int k = 0; k < word.length; k++) {
                            tempR[k] = words[r][c + k];
                        }
                        if (Arrays.equals(tempR, word)) {
                            rs = r;
                            cs = c;
                            re = r;
                            ce = c + word.length - 1;
                            return new int[]{rs, cs, re, ce};
                        }
                    }
                    // 向右下遍历
                    if (r <= R - word.length && c <= C - word.length) {
                        char[] tempRD = new char[word.length];
                        for (int k = 0; k < word.length; k++){
                            tempRD[k] = words[r + k][c + k];
                        }
                        if (Arrays.equals(tempRD, word)) {
                            rs = r;
                            cs = c;
                            re = r + word.length - 1;
                            ce = c + word.length - 1;
                            return new int[]{rs, cs, re, ce};
                        }
                    }
                    // 向右上遍历
                    if (r >= word.length - 1 && c <= C - word.length) {
                        char[] tempRU = new char[word.length];
                        for (int k = 0; k < word.length; k++) {
                            tempRU[k] = words[r - k][c + k];
                        }
                        if (Arrays.equals(tempRU, word)) {
                            rs = r;
                            cs = c;
                            re = r - word.length + 1;
                            ce = c + word.length - 1;
                            return new int[]{rs, cs, re, ce};
                        }
                    }
                    // 向下遍历
                    if (r <= R - word.length) {
                        char[] tempD = new char[word.length];
                        for (int k = 0; k < word.length; k++) {
                            tempD[k] = words[r + k][c];
                        }
                        if (Arrays.equals(tempD, word)) {
                            rs = r;
                            cs = c;
                            re = r + word.length - 1;
                            ce = c;
                            return new int[]{rs, cs, re, ce};
                        }
                    }
                    // 向左遍历
                    if (c >= word.length - 1) {
                        char[] tempL = new char[word.length];
                        for (int k = 0; k < word.length; k++) {
                            tempL[k] = words[r][c - k];
                        }
                        if (Arrays.equals(tempL, word)) {
                            rs = r;
                            cs = c;
                            re = r;
                            ce = c - word.length + 1;
                            return new int[]{rs, cs, re, ce};
                        }
                    }
                    // 向左下遍历
                    if (r <= R - word.length && c >= word.length - 1) {
                        char[] tempLD = new char[word.length];
                        for (int k = 0; k < word.length; k++) {
                            tempLD[k] = words[r + k][c - k];
                        }
                        if (Arrays.equals(tempLD, word)) {
                            rs = r;
                            cs = c;
                            re = r + word.length - 1;
                            ce = c - word.length + 1;
                            return new int[]{rs, cs, re, ce};
                        }
                    }
                    // 向左上遍历
                    if (r >= word.length - 1 && c >= word.length - 1) {
                        char[] tempLU = new char[word.length];
                        for (int k = 0; k < word.length; k++) {
                            tempLU[k] = words[r - k][c - k];
                        }
                        if (Arrays.equals(tempLU, word)) {
                            rs = r;
                            cs = c;
                            re = r - word.length + 1;
                            ce = c - word.length + 1;
                            return new int[]{rs, cs, re, ce};
                        }
                    }
                    // 向上遍历
                    if (r >= word.length - 1) {
                        char[] tempU = new char[word.length];
                        for (int k = 0; k < word.length; k++) {
                            tempU[k] = words[r - k][c];
                        }
                        if (Arrays.equals(tempU, word)) {
                            rs = r;
                            cs = c;
                            re = r - word.length + 1;
                            ce = c;
                            return new int[]{rs, cs, re, ce};
                        }
                    }
                }
            }
        }
        return new int[]{rs, cs, re, ce};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int Q = sc.nextInt();
        char[][] words = new char[R][C];
        for (int i = 0; i < R; i++) {
            words[i] = sc.next().toCharArray();
        }
        for (int i = 0; i < Q; i++) {
            char[] word = sc.next().toCharArray();
            System.out.println(word);
            int[] result = searchWord(words, word);
            if (result[0] == -1) {
                System.out.println(-1);
            } else {
                System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3]);
            }
        }
    }
}