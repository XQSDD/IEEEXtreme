package org.example.Xtreme17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author pc
 * @description 有序排列
 *  考虑一个长度为N的排列P，给你一个N-1的列表限制条件R。
 *  第i个限制条件表示Pi<Pi+1,如果Ri是第一种类型。
 *  并且Pi>Pi+1.如果Ri是第二种类型。
 *  你的任务是计算这个排列的数字遇见所有N-1个规则。这个数字可能很大，你应该输出10^9 + 7的模
 * @create 2023/10/28 23:20
 */
public class OrderedPermutations {
    /**
     * 输入：
     * 第一行数字N
     * 第二行是N-1个字符R，代表规则。第i个字符是<或>，意味着Ri是第一或第二种类型
     * 输出：
     * 一个整数，表示可能的排列数
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[] R = sc.next().toCharArray();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++){
            nums[i] = i + 1;
        }

        int count = 0;
        permute(nums, R, count);
        // for (List permute : result) {
        //     int subCount = 0;
        //     for (int i = 0; i < N - 1; i++) {
        //         if ((R[i] == '<' && (int)permute.get(i) < (int)permute.get(i + 1)) || (R[i] == '>' && (int)permute.get(i) > (int)permute.get(i + 1))) {
        //             subCount++;
        //         }
        //     }
        //     if (subCount == N - 1) {
        //         count++;
        //     }
        // }
        System.out.println(count % 1000000007);
    }

    public static void permute(int[] nums, char[] R, int count) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        // 标记这个元素是否已经添加到结果集
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, list, result, R, count);
    }

    private static void backtrack(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result, char[] R, int count) {
        if (list.size() == nums.length) {
            int subCount = 0;
            for (int i = 0; i < R.length; i++) {
                if ((R[i] == '<' && list.get(i) < list.get(i + 1)) || (R[i] == '>' && list.get(i) > list.get(i + 1))) {
                    subCount++;
                } else {
                    break;
                }
            }
            if (subCount == R.length) {
                count++;
                result.add(new ArrayList<>(list));
                return;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            // 已经添加过的元素，直接跳过
            if (visited[i]) {
                continue;
            }
            // 添加元素
            list.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, list, result, R, count);
            // 移除元素
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
