package org.example.utils.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pc
 * @description 全排列2
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * @create 2023/10/27 22:02
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        // 标记这个元素是否已经添加到结果集
        boolean[] visited = new boolean[nums.length];
        // 先排序
        Arrays.sort(nums);
        backtrack(nums, visited, list, result);
        return result;
    }

    // nums 输入集合
    // visited 当前递归标记过的元素
    // list 临时结果集
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
            // 上一个元素和当前相同，并且没有访问过就跳过
            if (i != 0 && nums[i] == nums[i-1] && !visited[i-1]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, list, result);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        PermuteUnique permuteUnique = new PermuteUnique();
        System.out.println(permuteUnique.permuteUnique(nums));
    }
}
