package org.example.Xtreme17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author pc
 * @description 他热爱数据结构
 * 吉列尔莫喜欢数据结构，尤其是树形数据结构。他能用他所知道的数据结构解决他遇到的所有问题。有一天，他遇到了下面这个问题：
 * 给定一棵有 n 个节点的树，节点编号从 1 到 n，根节点为 1，每个节点的值最初都设为 0：
 * 1 vlr： 在 v 的子树中，为每个与 v 的距离不大于 r-l 的节点 u 赋值。
 * value(u) = phi(l+dist(v,u)，其中phi代表欧拉图腾函数
 * 2 v: 确定特定节点 v 的值。
 * @create 2023/10/29 1:25
 */
public class HeLovesDataStructures {
    /**
     * 第一行包含整数 n，表示树中节点的数量。
     * 接下来的 n-1 行分别包含整数 a 和 b，表示树中的 a 和 b 之间有一条长度为 1 的边。
     * 下面一行包含一个整数 q，表示问题的查询次数。
     * 下面 q 行表示查询次数，每行一个。
     */

    static int n;
    static List<List<Integer>> tree;
    static int[] values;
    static int[] eulerTour;
    static int[] eulerDepth;
    static int[] firstOccurrence;
    static int eulerIndex;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        values = new int[n + 1];
        eulerTour = new int[2 * n];
        eulerDepth = new int[2 * n];
        firstOccurrence = new int[n + 1];
        eulerIndex = 0;

        dfs(1, 0);

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            int v = scanner.nextInt();
            if (type == 1) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                updateValues(v, l, r);
            } else if (type == 2) {
                System.out.println(values[v]);
            }
        }
    }

    private static void dfs(int node, int depth) {
        eulerIndex++;
        eulerTour[eulerIndex] = node;
        eulerDepth[eulerIndex] = depth;
        if (firstOccurrence[node] == 0) {
            firstOccurrence[node] = eulerIndex;
        }

        for (int child : tree.get(node)) {
            if (firstOccurrence[child] == 0) {
                dfs(child, depth + 1);
                eulerIndex++;
                eulerTour[eulerIndex] = node;
                eulerDepth[eulerIndex] = depth;
            }
        }
    }

    private static void updateValues(int v, int l, int r) {
        for (int i = l; i <= r; i++) {
            int dist = eulerDepth[firstOccurrence[v]] - i;
            int node = eulerTour[firstOccurrence[v]];
            System.out.println(node);
            values[node] = eulerTotemFunction(i + dist);
        }
    }

    private static int eulerTotemFunction(int n) {
        // TODO: Implement Euler Totem Function
        int result = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        if (n > 1) {
            result -= result / n;
        }
        return result;
    }
}
