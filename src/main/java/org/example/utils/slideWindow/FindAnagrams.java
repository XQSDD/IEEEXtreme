package org.example.utils.slideWindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pc
 * @description 找到字符串中所有字母异位词
 * 给定一个字符串  **s **和一个非空字符串  p，找到  **s **中所有是  **p **的字母异位词的子串，返回这些子串的起始索引。
 * @create 2023/10/27 21:49
 */
public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        int[] pMap = new int[256];
        int[] winMap = new int[256];
        int charNum = 0;
        for (char c : p.toCharArray()) {
            if (pMap[c] == 0) charNum++;
            pMap[c]++;
        }
        int left = 0;
        int right = 0;
        int match = 0;
        List<Integer> result = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (pMap[c] != 0) {
                winMap[c]++;
                if (pMap[c] == winMap[c]) {
                    match++;
                }
            }
            // 缩紧窗口
            while (match == charNum) {
                c = s.charAt(left);
                if (pMap[c] != 0) {
                    if (pMap[c] == winMap[c]) {
                        match--;
                    }
                    winMap[c]--;
                }
                // 当窗口长度和字符串长度匹配时，满足条件
                if (right - left == p.length()) {
                    result.add(left);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
        // 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
        // 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
    }
}
