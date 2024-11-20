package org.example.utils.stackQueue;

import java.util.Stack;

/**
 * @author pc
 * @description 逆波兰表达式求值
 * 波兰表达式计算 > 输入: ["2", "1", "+", "3", "*"] > 输出: 9
 *
 * 解释: ((2 + 1) * 3) = 9
 * @create 2023/10/27 21:04
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                int a = stack.pop();
                int b = stack.pop();
                if ("+".equals(s)) stack.push(b + a);
                else if ("-".equals(s)) stack.push(b - a);
                else if ("*".equals(s)) stack.push(b * a);
                    // 注意：b为被除数，a为除数
                else if ("/".equals(s)) stack.push(b / a);
            } else {
                // 转为数字
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        System.out.println(evalRPN.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
