package org.example.utils.binaryTree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pc
 * @description BFS层次遍历
 * 给你一个二叉树，请你返回其按  层序遍历  得到的节点值。 （即逐层地，从左到右访问所有节点）
 * 思路：用一个队列记录一层的元素，然后扫描这一层元素添加下一层元素到队列（一个数进去出来一次，所以复杂度 O(logN)）
 * @create 2023/10/27 21:32
 */
public class BFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> numList = new LinkedList<>();
        queue.add(root);
        numList.add(root.val);
        while (! queue.isEmpty()) {
            // 保存这一层的元素
            result.add(numList);
            numList = new LinkedList<>();
            // 记录当前层有多少元素（遍历当前层，再添加下一层）
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                // 出队列
                TreeNode p = queue.pop();
                if (p.left != null) {
                    queue.add(p.left);
                    numList.add(p.left.val);
                }
                if (p.right != null) {
                    queue.add(p.right);
                    numList.add(p.right.val);
                }
            }
        }
        return result;
    }
}
