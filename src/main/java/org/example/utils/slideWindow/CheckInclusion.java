package org.example.utils.slideWindow;

/**
 * @author pc
 * @description 字符串的排列
 * 给定两个字符串  s1  和  s2，写一个函数来判断  s2  是否包含  **s1 **的排列。
 * @create 2023/10/27 21:45
 */
public class CheckInclusion {
    public static boolean checkInclusion(String s1, String s2) {
        // 保存滑动窗口字符集
        int[] winMap = new int[256];
        // 保存需要出现的字符集
        int[] tMap = new int[256];
        for (char c : s1.toCharArray()) {
            tMap[c]++;
        }
        // 计算共出现了多少不同的字符
        int charNum = 0;
        for (int n : tMap) {
            if (n > 0) {
                charNum++;
            }
        }
        // 左右边界
        int left = 0;
        int right = 0;
        // 已经匹配的字母数
        int match = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (tMap[c] != 0) {
                winMap[c]++;
                if (winMap[c] == tMap[c]) {
                    match++;
                }
            }
            // 窗口收缩
            while (match == charNum) {
                c = s2.charAt(left);
                if (tMap[c] != 0) {
                    if (winMap[c] == tMap[c]) {
                        match--;
                    }
                    winMap[c]--;
                }
                left++;
                // 子串是一个排列，即子串长度等于s1
                if (right - left + 1 == s1.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";
        System.out.println(checkInclusion(s1, s2));
    }
}
