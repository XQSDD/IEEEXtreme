package org.example.utils.stackQueue;

import java.util.Stack;

/**
 * @author pc
 * @description 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * @create 2023/10/27 21:09
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        // 当前高度小于栈，则将栈内元素都弹出计算面积
        for (int i = 0; i <= heights.length; i++) {
            int cur = 0;
            if (i < heights.length) {
                cur = heights[i];
            }
            while (stack.size() != 0 && cur <= heights[stack.peek()]) {
                int index = stack.pop();
                int h = heights[index];
                // 计算宽度
                int w = i;
                if (stack.size() != 0) {
                    int peek = stack.peek();
                    w = i - peek - 1;
                }
                max = Math.max(max, h * w);
            }
            // 记录索引即可获取对应元素
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        int max = largestRectangleArea.largestRectangleArea(heights);
        System.out.println(max);
    }
}
