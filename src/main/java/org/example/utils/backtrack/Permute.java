package org.example.utils.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pc
 * @description 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * @create 2023/10/27 22:00
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        // 标记这个元素是否已经添加到结果集
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, list, result);
        return result;
    }

    // nums 输入集合
    // visited 当前递归标记过的元素
    // list 临时结果集(路径)
    // result 最终结果
    private void backtrack(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 已经添加过的元素，直接跳过
            if (visited[i]) {
                continue;
            }
            // 添加元素
            list.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, list, result);
            // 移除元素
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permute permute = new Permute();
        System.out.println(permute.permute(nums));
    }
}
