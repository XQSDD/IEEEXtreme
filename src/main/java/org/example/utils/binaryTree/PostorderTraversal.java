package org.example.utils.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author pc
 * @description 后序非递归
 * @create 2023/10/27 21:29
 */
public class PostorderTraversal {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        // 通过lastVisit标识右子节点是否已经弹出
        TreeNode lastVisit = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            //查看当前栈顶元素
            p = stack.peek();
            //如果其右子树也为空，或者右子树已经访问，则可以访问
            if (p.right == null || p.right == lastVisit) {
                result.add(p.val);
                stack.pop();
                // 标记当前这个节点已经弹出过
                lastVisit = p;
                p = null;
            } else {
                //否则继续遍历右子树
                p = p.right;
            }
        }
        return result;
    }
}
