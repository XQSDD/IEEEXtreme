package org.example.utils.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author pc
 * @description 递归遍历
 * @create 2023/10/27 21:14
 */
public class PreorderTraversal {
    /**
     * Definition for a binary tree node.
     * */
     public static class TreeNode {
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
    // 递归遍历写法，以前序遍历为例
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        traverse(root, result);
        return result;
    }

    public void traverse(TreeNode p, List<Integer> result) {
        if (p == null) {
            return;
        }
        // 其他遍历调整这里的语句顺序即可
        result.add(p.val);
        traverse(p.left, result);
        traverse(p.right, result);
    }

    // 通过非递归遍历
    public List<Integer> preorderTraversalWhitout(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || ! stack.isEmpty()) {
            while (p != null) {
                // 前序遍历，所以先保存结果
                result.add(p.val);
                stack.push(p);
                p = p.left;
            }
            // pop出栈顶元素
            if (! stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        PreorderTraversal p = new PreorderTraversal();
        System.out.println(p.preorderTraversal(root));
    }
}
