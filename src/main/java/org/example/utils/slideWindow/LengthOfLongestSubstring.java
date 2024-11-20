package org.example.utils.slideWindow;

/**
 * @author pc
 * @description 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度
 * @create 2023/10/27 21:53
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        int[] winMap = new int[256];
        int left = 0;
        int right = 0;
        int maxLen = 0;
        // 1、右指针右移
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            winMap[c]++;
            // 2、根据题意收缩窗口
            while (winMap[c] > 1) {
                // 3、左指针右移更新窗口
                char d = s.charAt(left);
                left++;
                winMap[d]--;
            }
            // 4、根据题意计算结果
            maxLen = Math.max(right - left, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(" "));
    }
}
