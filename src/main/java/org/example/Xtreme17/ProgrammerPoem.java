package org.example.Xtreme17;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;

/**
 * @author pc
 * @description 程序员之诗
 * 确定一个段落所使用的韵律，一个有 n 行的段落的押韵方案是一个长度为 n 的大写字母字符串，字符串中的第i个字母对应段落中的第i行。
 * 1) 除 X 外，押韵的行用大写字母标注。
 * 2) 第一组押韵的行用 A 标出，第二组用 B 标出，以此类推，跳过字母 X。
 * 3) 不押韵的诗行应标注 X。
 * @create 2023/10/28 14:16
 */
public class ProgrammerPoem {
    /**
     * 输入：
     * 第一行空格分割整数，n和m
     * 接下来每n行包含一系列通过空格隔开的押韵单词，只有小写字母组成
     * 然后是一行空白
     * 下m行是要解析的段落
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        List<List<String>> rhymeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rhymeList.add(Arrays.asList(sc.nextLine().split(" ")));
        }
        sc.nextLine();
        StringBuilder result = new StringBuilder();
        List<Integer> rhymeIndexList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> poemLine = Arrays.asList(sc.nextLine().split(" "));
            String word = poemLine.get(poemLine.size() - 1);
            int rhymeIndex = rhymeOrder(rhymeList, word);
            rhymeIndexList.add(rhymeIndex);
        }
        System.out.println(rhymeIndexList);
        for (int i = 0; i < rhymeIndexList.size(); i++){
            if (i == 0) {
                if (!rhymeIndexList.get(i).equals(rhymeIndexList.get(1))) {
                    rhymeIndexList.set(i, -1);
                }
            } else if (i ==  rhymeIndexList.size() - 1) {
                if (!rhymeIndexList.get(i).equals(rhymeIndexList.get(i - 1))) {
                    rhymeIndexList.set(i, -1);
                }
            } else {
                if (!Objects.equals(rhymeIndexList.get(i), rhymeIndexList.get(i - 1)) && !Objects.equals(rhymeIndexList.get(i), rhymeIndexList.get(i + 1))) {
                    rhymeIndexList.set(i, -1);
                }
            }
        }
        List<Integer> rhymeUsedList = new ArrayList<>();
        for (int rhymeIndex : rhymeIndexList) {
            if (rhymeIndex != -1) {
                if (rhymeUsedList.contains(rhymeIndex)) {
                    int index = rhymeUsedList.indexOf(rhymeIndex);
                    result.append((char) ('A' + index % 26));
                } else {
                    rhymeUsedList.add(rhymeIndex);
                    int index = rhymeUsedList.indexOf(rhymeIndex);
                    result.append((char) ('A' + index % 26));
                }

            } else {
                result.append('X');
            }
        }
        // System.out.println(rhymeIndexList);
        // // 判断字符串中有无前后都不相同的字符，有的话设置为X，并将后面的字符前移一位
        // char[] chars = result.toString().toCharArray();
        // for (int i = 1; i < chars.length - 2; i++) {
        //     if (chars[i] != chars[i + 1] && chars[i] != chars[i - 1]) {
        //         int charIndex = chars[i] - 'A';
        //         chars[i] = 'X';
        //         for (int j = i + 1; j < chars.length; j++) {
        //             if (chars[j] != 'X' && (int) chars[j] - 'A' > charIndex) {
        //                 chars[j] = (char) ((int) chars[j] - 1);
        //             }
        //         }
        //     }
        // }
        // if (chars[0] != chars[1]) {
        //     chars[0] = 'X';
        // }
        // if (chars[chars.length - 1] != chars[chars.length - 2]) {
        //     chars[chars.length - 1] = 'X';
        // }
        // for (int i = 0; i < result.length(); i++) {
        //     result.setCharAt(i, chars[i]);
        // }
        System.out.println(result);
    }

    static int rhymeOrder(List rhymeList, String word) {
        for (int i = 0; i < rhymeList.size(); i++) {
            List rhyme = (List) rhymeList.get(i);
            if (rhyme.contains(word.toLowerCase())) {
                char ch = 'X';
                if ((i % 26 + 'A') >= (int) ch) {
                    return i + 1;
                }
                return i;
            }

        }
        return -1;
    }
}
