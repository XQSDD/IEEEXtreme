package org.example.Xtreme17;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author pc
 * @description 多边形切割
 * 给你一个有 N 个顶点和 M 条对角线的严格凸多边形。这些对角线在多边形内部没有交点，
 * 并将多边形切割成 M+1 块。你的任务是选择一组块 S，使 S 中块的总面积最大，
 * 且 S 中没有两块共用一条边。S 中没有两块棋子共用一条边。输出该集合总面积的两倍。
 * @create 2023/10/28 20:48
 */
public class PolygonCutting {
    /**
     * 输入：
     * 第一行两个整数N和M，N行按顺时针熟悉怒描述多边形顶点，第i行包含两个数字，x和y，第i个顶点的坐标
     * 接下来M行包含顶点之间的对角线u和v
     * 输出：
     * 在多边形中最佳分割中输出一条总面积为较大集合总面积两倍的线
     */
    static class Piece {
        List<Point2D.Double> vertices = new ArrayList<>();
    }

    static Point2D.Double[] allVertices;

    public static double area(Piece piece) {
        double area = 0.0;
        int n = piece.vertices.size();
        for (int i = 0; i < n; i++) {
            area += piece.vertices.get(i).x * piece.vertices.get((i + 1) % n).y
                    - piece.vertices.get(i).y * piece.vertices.get((i + 1) % n).x;
        }
        return Math.abs(area) / 2.0;
    }

    public static boolean sharesEdge(Piece a, Piece b) {
        int n = a.vertices.size();
        int m = b.vertices.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a.vertices.get(i).equals(b.vertices.get(j))
                        && a.vertices.get((i + 1) % n).equals(b.vertices.get((j + 1) % m))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static double maximizeArea(List<Piece> pieces) {
        int N = pieces.size();
        double[] dp = new double[1 << N];

        for (int mask = 1; mask < (1 << N); mask++) {
            List<Integer> selectedPieces = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    selectedPieces.add(i);
                }
            }

            boolean valid = true;
            for (int i = 0; i < selectedPieces.size() && valid; i++) {
                for (int j = i + 1; j < selectedPieces.size(); j++) {
                    if (sharesEdge(pieces.get(selectedPieces.get(i)), pieces.get(selectedPieces.get(j)))) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) {
                for (int pieceIndex : selectedPieces) {
                    dp[mask] += area(pieces.get(pieceIndex));
                }
            }
        }

        double ans = 0;
        for (double a : dp) {
            ans = Math.max(ans, a);
        }
        return 2.0 * ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        allVertices = new Point2D.Double[N];
        for (int i = 0; i < N; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            allVertices[i] = new Point2D.Double(x, y);
        }

        List<Piece> pieces = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            scanner.nextLine(); // Consume newline

            Piece piece = new Piece();
            piece.vertices.add(allVertices[u]);
            while (u != v) {
                u = (u + 1) % N;
                piece.vertices.add(allVertices[u]);
            }
            pieces.add(piece);
        }

        double result = maximizeArea(pieces);
        System.out.println((int) result); // Print as an integer
    }
}
