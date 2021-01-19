package com.xcr.algorithm.labuladong.bst;

/**
 * @Author: xia
 * @Date: 2021/1/18 17:47
 * @Version: v1.0
 */
public class TreeNode {

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
