package com.xcr.algorithm.labuladong.treenode;

import com.xcr.algorithm.labuladong.listnode.ListNode;

/**
 * @Author: xia
 * @Date: 2021/1/19 14:15
 * @Version: v1.0
 */
public class Q1Tree {
    /**
     * 翻转二叉树
     */
    public TreeNode reverse(TreeNode node) {
        if (node == null) return null;

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        reverse(node.left);
        reverse(node.right);
        return node;
    }

    /**
     * 填充二叉树节点的右侧指针
     */
    public TreeNode connect(TreeNode root) {
        if (root == null) return null;
        connectTwoNode(root.left, root.right);
        return root;
    }

    public void connectTwoNode(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;

        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);

        connectTwoNode(left.right, right.left);

    }


    /**
     * 将二叉树展开成链表
     */
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }



    /***
     * 统计二叉树的节点数
     */
    public static int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode l = root, r = root;
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl ++;
        }
        while (r != null) {
            r = r.right;
            hr ++;
        }
        if (hl == hr) {
            return (int)Math.pow(2, hl) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        int i = countNodes(treeNode);
        System.out.println(i);
    }

}
