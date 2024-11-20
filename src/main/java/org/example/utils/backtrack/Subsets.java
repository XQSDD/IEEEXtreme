package org.example.utils.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pc
 * @description 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * @create 2023/10/27 21:55
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        // 保存中间结果
        List<Integer> subSet = new ArrayList<>();
        // 保存最终结果
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, subSet, result);
        return result;
    }

    // nums 给定的集合
    // pos 下次添加到集合中的元素位置索引
    // subSet 临时结果集合(每次需要复制保存)
    // result 最终结果
    private static void backtrack(int[] nums, int pos, List<Integer> subSet, List<List<Integer>> result) {
        // 把临时结果复制出来保存到最终结果
        result.add(new ArrayList<>(subSet));
        for (int i = pos; i < nums.length; i++) {
            // 选择、处理结果、再撤销选择
            subSet.add(nums[i]);
            backtrack(nums, i+1, subSet, result);
            subSet.remove(subSet.size() - 1);
        }
    }

    // 第二种求子集
    public static List<List<Integer>> subsets2(int[] nums) {
        // 保存中间结果
        List<Integer> subSet = new ArrayList<>();
        // 保存最终结果
        List<List<Integer>> result = new ArrayList<>();
        // 先排序
        Arrays.sort(nums);
        backtrack2(nums, 0, subSet, result);
        return result;
    }

    // nums 给定的集合
    // pos 下次添加到集合中的元素位置索引
    // subSet 临时结果集合(每次需要复制保存)
    // result 最终结果
    private static void backtrack2(int[] nums, int pos, List<Integer> subSet, List<List<Integer>> result) {
        // 把临时结果复制出来保存到最终结果
        result.add(new ArrayList<>(subSet));
        for (int i = pos; i < nums.length; i++) {
            // 排序之后，如果再遇到重复元素，则不选择此元素
            if (i != pos && nums[i] == nums[i-1]) {
                continue;
            }
            // 选择、处理结果、再撤销选择
            subSet.add(nums[i]);
            backtrack(nums, i+1, subSet, result);
            subSet.remove(subSet.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
        System.out.println(subsets2(nums));
    }
}
