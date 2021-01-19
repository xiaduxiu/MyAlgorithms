package com.xcr.algorithm.labuladong.treenode;

/**
 * @Author: xia
 * @Date: 2021/1/19 15:15
 * @Version: v1.0
 */
public class Q2Tree {

    /**
     * 654
     * 构建最大二叉树
     */
    public TreeNode constructMaximumBinaryTree(int[] nums){
        return build(nums, 0, nums.length-1);
    }

    private TreeNode build(int[] nums, int front, int rear) {
        if (front > rear) {
            return null;
        }
        // 找出最大数
        int index=-1, maxVal = Integer.MIN_VALUE;
        for (int i = front; i <= rear; i++) {
            if(nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        // 创建
        TreeNode node = new TreeNode(maxVal);

        node.left = build(nums, front, index-1);
        node.right = build(nums, index+1, rear);
        return node;
    }

    /**
     * 105
     * 前序： root->root.left->root.right
     * 中序： root.left->root->root.right
     * 通过前序和中序遍历结果构建二叉树
     * @param
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length-1,
                inorder, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int preIndex, int preEnd,
                          int[] inorder, int inIndex, int inEnd) {
        if (preIndex > preEnd) {
            return null;
        }
        // 先序遍历的首个元素就是 root
        int rootVal = preorder[preIndex];
        // 在中序遍历中根据先序遍历中确定的root的值确定 root 所在的下标
        int index = 0;
        for (int i = inIndex; i <= inEnd; i++) {
            if(inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        // 确定好中序遍历中root的index后，可以知道 左子树的长度
        int leftLength = index-inIndex;

        // 创建 TreeNode
        TreeNode root = new TreeNode(rootVal);

        // 根据前序和中序遍历的数据分布可以得出
        // 前序： root->root.left->root.right
        // 中序： root.left->root->root.right
        root.left = build(preorder, preIndex+1, preIndex + leftLength,
                inorder, inIndex, index-1);
        root.right = build(preorder, preIndex + leftLength+1, preEnd,
                inorder, index+1, inEnd);
        return root;
    }


    /**
     * 106
     * 中序： root.left->root->root.right
     * 后序： root.left->root.right->root
     * 通过中序和后序遍历结果构建二叉树
     * @param
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        return build2(inorder, 0, inorder.length-1,
                postorder, 0, postorder.length-1);
    }

    public TreeNode build2(int[] inorder, int inIndex, int inEnd,
                          int[] postorder, int postIndex, int postEnd) {
        if (inIndex > inEnd) {
            return null;
        }
        // 先序遍历的首个元素就是 root
        int rootVal = postorder[postEnd];
        // 在中序遍历中根据先序遍历中确定的root的值确定 root 所在的下标
        int index = 0;
        for (int i = inIndex; i <= inEnd; i++) {
            if(inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        // 确定好中序遍历中root的index后，可以知道 左子树的长度
        int leftLength = index-inIndex;

        // 创建 TreeNode
        TreeNode root = new TreeNode(rootVal);

        // 根据后序和中序遍历的数据分布可以得出
        // 中序： root.left->root->root.right
        // 后序： root.left->root.right->root
        root.left = build2(inorder, inIndex, index-1,
                postorder, postIndex, postIndex + leftLength-1);
        root.right = build2(inorder, index+1, inEnd,
                postorder, postIndex + leftLength, postEnd-1);
        return root;
    }

    public static void main(String[] args) {

    }
}
