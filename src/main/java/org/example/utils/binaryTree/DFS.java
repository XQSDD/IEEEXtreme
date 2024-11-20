package org.example.utils.binaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pc
 * @description DFS深度搜索
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * @create 2023/10/27 21:30
 */
public class DFS {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder path = new StringBuilder();
        List<String> paths = new LinkedList<>();
        dfs(root, path, paths);
        return paths;
    }

    public void dfs(TreeNode p, StringBuilder path, List<String> paths) {
        if (p == null) {
            return;
        }
        path.append(p.val);
        // 当前节点是叶子节点
        if (p.left == null && p.right == null) {
            // 把路径加入结果
            paths.add(path.toString());
        } else {
            path.append("->");
            // 这里需要复制创建新的StringBuilder对象
            dfs(p.left, new StringBuilder(path), paths);
            dfs(p.right, new StringBuilder(path), paths);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<String> paths = new DFS().binaryTreePaths(root);
        System.out.println(paths);
    }
}
