package org.example.utils.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pc
 * @description 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * @create 2023/10/27 22:04
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> answer = new ArrayList();
        List<List<Integer>> result = new ArrayList();
        // 先排序
        Arrays.sort(candidates);
        backtrack(candidates, 0, target, answer, result);
        return result;
    }

    // candidates 输入集合
    // pos 当前标记位置，标记前的元素不再考虑
    // target 求和目标
    // answer 临时解法
    // result 最终结果
    private void backtrack(int[] candidates, int pos, int target, List<Integer> answer, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(answer));
        }
        for (int i = pos; i < candidates.length; i++) {
            // 剪枝：后续元素都比目标大，直接break（比continue要快）
            if (candidates[i] > target) {
                break;
            }
            // 添加元素
            answer.add(candidates[i]);
            // 元素可以重复取，所以从当前位置继续
            backtrack(candidates, i, target - candidates[i], answer, result);
            // 移除元素
            answer.remove(answer.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7, 5};
        int target = 7;
        List<List<Integer>> result = new CombinationSum().combinationSum(candidates, target);
        System.out.println(result);
    }
}
