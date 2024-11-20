package org.example.utils.binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author pc
 * @description 中序非递归
 * @create 2023/10/27 21:26
 */
public class InorderTraversal {
    // 思路：通过stack 保存已经访问的元素，用于原路返回
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || ! stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);
                p = node.right;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
