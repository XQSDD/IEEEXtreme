package org.example.Xtreme15;

import java.util.*;

/**
 * @author pc
 * @description 变色龙步道
 * N个路口，编号1-N，M条不同长度的双向路径，从路口1走到N。每秒一个单位速度。
 * 每条路有一个颜色，由a-e代表。最初它的颜色是a e a
 * C表示更改一次颜色所需时间（s），整个过程不变。
 * 希望找到最大的正整数C，使得到N路口需要时间K
 * @create 2023/10/20 14:33
 */
public class ChameleonWalk {
    /**
     * 输入：
     * 第一行测试用例数T
     * 每个测试用例三个整数：N,M,K。N个点。M条路和K秒
     * 然后M行描述双向道路，一个路径给出三个整数x，y，d和一个小写字母c。x和y表示连接的两个路口，d是路径距离，c是颜色。
     * 输出：
     * C的最大值。到达N口时间不超过K，如果无论怎么选择都无法及时到达N，则输出impossible，如果C无穷大，输出relaxing。
     * 思路：
     * 无向有环图
     * 找到从1到N的所有路径，计算路径花费和颜色改变次数
     * DFS
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            List<Path> paths = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int d = sc.nextInt();
                char c = sc.next().charAt(0);
                paths.add(new Path(x, y, d, c));
                paths.add(new Path(y, x, d, c));
            }
            int c = chameleonWalk(paths, N, K);
            if (c == -1) {
                System.out.println("impossible");
            } else if (c == 0) {
                System.out.println("relaxing");
            } else {
                System.out.println(c);
            }
        }
    }

    static class Path {
        int x;
        int y;
        int d;
        char c;

        Path(int from, int to, int time, char color) {
            this.x = from;
            this.y = to;
            this.d = time;
            this.c = color;
        }

        @Override
        public String toString() {
            return "Path{" +
                    "x=" + x +
                    ", y=" + y +
                    ", d=" + d +
                    ", c=" + c +
                    '}';
        }
    }

    private static int chameleonWalk(List<Path> paths, int N, int K) {
        List<List<Path>> allPaths = new ArrayList<>(100000);
        List<Path> currentPath = new ArrayList<>(100000);
        int currentTime = 0;
        dfs(1, N, K, paths, allPaths, currentPath, currentTime);
        if (allPaths.isEmpty()) {
            return -1;
        }
        int c = -1;
        for (List<Path> path : allPaths) {
            int totalTime = 0;
            char currentColor = 'a';
            int changeCount = 0;
            for (Path p : path) {
                totalTime += p.d;
                if (p.c != currentColor) {
                    changeCount++;
                    currentColor = p.c;
                }
            }
            int space = K - totalTime;
            if (changeCount > 0 && space > 0) {
                c = Integer.max(space / changeCount, c);
            } else if (changeCount == 0 && space == 0) {
                c = 0;
            }
        }
        return c;
    }

    private static void dfs(int current, int target, int maxTime, List<Path> paths, List<List<Path>> allPaths, List<Path> currentPath, int currentTime){
        if (current == target) {
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }

        for (Path path : paths) {
            if (path.x == current && !currentPath.contains(path) && currentTime + path.d <= maxTime && path.x < path.y) {
                currentPath.add(path);
                dfs(path.y, target, maxTime, paths, allPaths, currentPath, currentTime + path.d);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }
}
