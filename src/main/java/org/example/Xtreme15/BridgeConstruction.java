package org.example.Xtreme15;

import java.util.*;

/**
 * @author pc
 * @description 桥梁建设，考虑在哪建桥使得最长旅行时间最小
 * 第一个岛有N1个村庄和N1-1条双向道路，第二个岛有N2个村庄和N2-1条双向道路
 * @create 2023/10/18 19:06
 */
public class BridgeConstruction {
    /**
     * 标准输入：
     * 第一行是测试用例数T
     * 村庄数N1（村庄1~N1）
     * N1-1行，表示道路，每行两个整数表示道路连接的村庄
     * 然后相同的格式第二个岛的村庄和道路
     * 标准输出：
     * 每个测试案例输出两行，第一行包含建桥后任何一对村庄之间的最小最长旅行时间。
     * 第二行是两个空格分割的整数x和y，分别在1-N1和1-N2之间。表示在村庄x和村庄y之间建桥。如果有多个方案，输出任意一个就行
     * 思路：
     * 遍历每一种建桥方案，计算每种方案的最长路径时间，最后求得最小值
     * 使用深度优先搜索(DFS)
     */
    public static void bridgeConstruction(int[][] roads1, int[][] roads2, int N1, int N2) {
        // 创建无向无环图
        List<Integer>[] adj = new ArrayList[N1 + N2];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] road : roads1) {
            adj[road[0]-1].add(road[1]-1);
            adj[road[1]-1].add(road[0]-1);
        }
        for (int[] road : roads2) {
            adj[road[0]-1 + N1].add(road[1]-1 + N1);
            adj[road[1]-1 + N1].add(road[0]-1 + N1);
        }
        // 最小时间
        int minTime = -1;
        int x = 0, y = 0;
        for (int i = 1; i <= roads1.length; i++) {
            for (int j = 1 + N1; j <= roads2.length + N1; j++) {
                adj[i-1].add(j-1);
                adj[j-1].add(i-1);
                int maxLength = 0;
                // 对每个顶点作为起点进行深度优先搜索
                for (int v = 0; v < N1 + N2; v++) {
                    boolean[] visited = new boolean[adj.length];
                    maxLength = Math.max(maxLength, dfs(v, adj, visited));
                }
                if (minTime == -1 || minTime > maxLength) {
                    minTime = maxLength;
                    x = i;
                    y = j - N1;
                }
                // 移除前面添加的桥梁位置
                adj[i-1].remove(adj[i-1].size() - 1);
                adj[j-1].remove(adj[j-1].size() - 1);
            }
        }
        System.out.println(minTime);
        System.out.println(x + " " + y);
    }

    public static int dfs(int v, List<Integer>[] adj, boolean[] visited) {
        visited[v] = true;

        int maxLength = 0;

        // 遍历当前顶点的邻接顶点
        for (int u : adj[v]) {
            if (!visited[u]) {
                int length = dfs(u, adj, visited) + 1;
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N1 = sc.nextInt();
            int[][] roads1 = new int[N1 - 1][2];
            for (int j = 0; j < N1 - 1; j++) {
                roads1[j][0] = sc.nextInt();
                roads1[j][1] = sc.nextInt();
            }
            int N2 = sc.nextInt();
            int[][] roads2 = new int[N2 - 1][2];
            for (int j = 0; j < N2 - 1; j++) {
                roads2[j][0] = sc.nextInt();
                roads2[j][1] = sc.nextInt();
            }
            bridgeConstruction(roads1, roads2, N1, N2);
        }
    }
}
