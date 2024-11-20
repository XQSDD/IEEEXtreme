package org.example.utils.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pc
 * @description 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 数字到字母的映射与电话按键相同
 * @create 2023/10/27 22:06
 */
public class LetterCombinations {
    // 记录数字到字母的映射
    private final static Map<Character, String> map = new HashMap<>();

    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        StringBuilder builder = new StringBuilder();
        List<String> result = new ArrayList<>();
        backtrack(digits, 0, builder, result);
        return result;
    }

    private void backtrack(String digits, int pos, StringBuilder builder, List<String> result) {
        // 结束条件：到达末尾
        if (pos == digits.length()) {
            // 如果原字符串为空则没有对应的字母组合
            if (pos != 0) {
                result.add(builder.toString());
            }
            return;
        }
        for (char c : map.get(digits.charAt(pos)).toCharArray()) {
            builder.append(c);
            backtrack(digits, pos + 1, builder, result);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
        System.out.println(letterCombinations.letterCombinations(""));
        System.out.println(letterCombinations.letterCombinations("2"));
    }
}
