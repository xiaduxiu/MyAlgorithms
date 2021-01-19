package com.xcr.algorithm.labuladong.bst;

/**
 * @Author: xia
 * @Date: 2021/1/19 18:39
 * @Version: v1.0
 */
public class Q1BST {

    /**
     * 230
     * 二叉搜索树中第K小的元素
     */
    int result = 0, index =0;
    public int kthSmallest(TreeNode root, int k) {
        // 利用二叉搜索树中序遍历是升序的特征，进行查找第k个
        traverse(root, k);
        return result;
    }

    private void traverse(TreeNode root, int k) {

        if (root == null) return;

        traverse(root.left, k);

        index ++;
        if (k == index) {
            result = root.val;
            return;
        }

        traverse(root.right, k);
    }

    /**
     * 538
     * BST 转化累加树
     *
     * @param root
     * @return
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {

        if (root == null) return;

        traverse(root.right);

        sum += root.val;
        root.val = sum;

        traverse(root.left);
    }

}
