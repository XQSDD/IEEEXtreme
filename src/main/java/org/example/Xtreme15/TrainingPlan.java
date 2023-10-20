package org.example.Xtreme15;

import java.util.*;

/**
 * @author pc
 * @description 训练计划
 * 训练计划包括M个周期，每个周期X天，每周期第一天紧随前X天，每个周期从X个可用培训选择Y个，选择的M*Y次培训成绩总和最大。确保挑选训练次数相同连续不超过K。
 * @create 2023/10/20 10:28
 */
public class TrainingPlan {
    /**
     * 输入：
     * 第一行测试用例数T
     * 每个测试用例第一行四个整数M,X,Y,K
     * 然后是M行，包含X个整数，分别给出训练分数。
     * 输出：
     * 一个整数，最佳训练成绩总和，如果给定限制条件无法创建则输出IMPOSSIBLE
     * 思路：
     * 将数组按照从小到大排序，从后往前遍历，按照连续性K次限制，将每次符合条件的值和索引分别存入一个列表，后续每次判断元素是否连续和相同，K次以上就跳过
     * 如果遍历完不足Y个说明没有符合要求的计划，输出IMPOSIBLE
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int M = sc.nextInt();
            int X = sc.nextInt();
            int Y = sc.nextInt();
            int K = sc.nextInt();
            int[][] score = new int[M][X];
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < X; k++) {
                    score[j][k] = sc.nextInt();
                }
            }
            int maxScore = getMaxScore(M, X, Y, K, score);
            if (maxScore != -1) {
                System.out.println(maxScore);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static int getMaxScore(int m, int x, int y, int k, int[][] score) {
        int totalScore = 0;
        // 找到每一行最大的元素，且不会有k个连续的训练
        for (int i = 0; i < m; i++) {
            int sum = 0;
            int[] sortedScore = score[i].clone();
            Arrays.sort(sortedScore);

            List<Integer> usedIndices = new ArrayList<>();
            List<Integer> usedScores = new ArrayList<>();

            int maxCount = 0;
            for (int j = 0; j < x; j++) {
                int max = sortedScore[x - 1 - j];
                int maxIndex = -1;
                for (int l = 0; l < x; l++) {
                    if (score[i][l] == max && !usedIndices.contains(l) && !isConsecutive(usedIndices, usedScores, l, max, k)) {
                        maxIndex = l;
                        usedIndices.add(l);
                        usedScores.add(max);
                        maxCount++;
                        break;
                    }
                }

                if (maxIndex != -1) {
                    sum += max;
                }
                if (maxCount == y) {
                    break;
                }
            }
            if (maxCount != y) {
                return -1;
            }
            totalScore += sum;
        }
        return totalScore;
    }

    public static boolean isConsecutive(List<Integer> usedIndices, List<Integer> usedScores, int index, int max, int K) {
        if (usedIndices.size() < K) {
            return false;
        }

        int count = 0;
        for (int i = 1; i <= K+1; i++) {
            if (usedIndices.contains(index - i) && usedScores.get(usedIndices.size() - i) == max) {
                count++;
            } else {
                break;
            }
        }
        return count == K;
    }
}
