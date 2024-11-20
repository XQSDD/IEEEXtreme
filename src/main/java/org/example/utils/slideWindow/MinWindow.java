package org.example.utils.slideWindow;

/**
 * @author pc
 * @description 最小覆盖子串
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串
 * @create 2023/10/27 21:41
 */
public class MinWindow {
    public static String minWindow(String s, String t) {
        // 技巧：用数组代替Map
        // 保存滑动窗口字符集
        int[] winMap = new int[256];
        // 保存需要出现的字符集
        int[] tMap = new int[256];
        for (char c : t.toCharArray()) {
            tMap[c]++;
        }
        // 计算共出现了多少不同的字符
        int charNum = 0;
        for (int n : tMap) {
            if (n > 0) {
                charNum++;
            }
        }
        // 滑动窗口左右边界
        int left = 0;
        int right = 0;
        // 匹配数
        int match = 0;
        // 窗口调整前暂存原窗口边界
        int start = 0;
        int end = 0;
        // 窗口长度的最小值
        int minValue = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            // 在需要的字符集里面，添加到窗口字符集里面
            if (tMap[c] != 0) {
                winMap[c]++;
                // 如果当前字符的数量匹配需要的字符的数量，则match值+1
                if (tMap[c] == winMap[c]) {
                    match++;
                }
            }
            right++;
            // 当所有字符数量都匹配之后，开始缩紧窗口
            while (match == charNum) {
                // 获取结果
                if (right - left < minValue) {
                    minValue = right - left;
                    start = left;
                    end = right;
                }
                char leftChar = s.charAt(left);
                // 左指针指向不在需要字符集则直接跳过
                if (tMap[leftChar] != 0) {
                    // 左指针指向字符数量和需要的字符相等时，右移之后match值就不匹配则减一
                    if (winMap[leftChar] == tMap[leftChar]) {
                        match--;
                    }
                    winMap[leftChar]--;
                }
                left++;
            }
        }
        if (minValue == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}
