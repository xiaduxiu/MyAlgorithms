package com.xcr.algorithm.labuladong.bst;

/**
 * @Author: xia
 * @Date: 2021/1/19 18:39
 * @Version: v1.0
 */
public class Q2BST {

    public boolean isValidBST(TreeNode node) {
        return helpValid(node, null, null);
    }

    public boolean helpValid(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null) return true;

        if (min != null && min.val >= node.val) return false;
        if (max != null && max.val <= node.val) return false;

        return helpValid(node.left, min, node) && helpValid(node.right, node, max);
    }

    // 查找

    public boolean isInBST(TreeNode node, int k) {
        if (node == null) return false;

        if (node.val == k) {
            return true;
        } else if (node.val > k) {
            return isInBST(node.left, k);
        } else {
            return isInBST(node.right, k);
        }
    }

    // 插入
    public TreeNode insertBST(TreeNode node, int k) {
        if (node == null) {
            node = new TreeNode(k);
        }

        if (node.val > k) {
            node.left = insertBST(node.left, k);
        }
        if (node.val < k) {
            node.right = insertBST(node.right, k);
        }
        return node;
    }

    // 删除
    public TreeNode deleteBST(TreeNode node, int k) {
        if (node == null) return null;
        if (node.val == k) {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            TreeNode minNode = getMinNode(node.right);
            node.val = minNode.val;
            node.right = deleteBST(node.right, minNode.val);
        } else if (node.val > k) {
            node.left = deleteBST(node.left, k);
        } else {
            node.right = deleteBST(node.right, k);
        }
        return node;
    }

    private TreeNode getMinNode(TreeNode right) {
        while (right.left != null) right = right.left;
        return right;
    }

}
