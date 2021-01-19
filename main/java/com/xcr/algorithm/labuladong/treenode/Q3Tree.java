package com.xcr.algorithm.labuladong.treenode;

import java.util.*;

/**
 * @Author: xia
 * @Date: 2021/1/19 16:10
 * @Version: v1.0
 */
public class Q3Tree {
    /**
     * 652
     * 寻找重复子树
     * @param root
     * @return
     */
    public Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> nodes = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return nodes;
    }

    public String traverse(TreeNode root) {
        if (root == null) return "#";
        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + "," + root.val;

        if (!map.containsKey(subTree)) {
            map.put(subTree, 1);
        } else {
            Integer count = map.get(subTree);
            if (count == 1) {
                nodes.add(root);
            }
            map.put(subTree, count +1);
        }
        return subTree;
    }


    /**
     * 297
     * 二叉树的序列化与反序列化
     * @param root
     * @return
     */
    public static String NULL = "#";
    public static String SPLIT = ",";
    public StringBuffer stringBuffer = new StringBuffer();
    // 把一棵二叉树序列化成字符串

    public String serialize(TreeNode root) {
        if(root == null) {
            stringBuffer.append(NULL).append(SPLIT);
            return stringBuffer.toString();
        }
        stringBuffer.append(root.val).append(SPLIT);
        serialize(root.left);
        serialize(root.right);
        return stringBuffer.toString();
    }

    // 把字符串反序列化成二叉树

    public TreeNode deserialize(String data) {
        List<String> list = new LinkedList<>(Arrays.asList(data.split(SPLIT)));
        return helpDeserialize(list);
    }

    public TreeNode helpDeserialize(List<String> list) {
        if (list.size() == 0) return null;
        String first = list.remove(0);
        if (first.equals(NULL)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(first));

        node.left = helpDeserialize(list);
        node.right = helpDeserialize(list);
        return node;
    }

    /**
     * 层级遍历
     */
    public void traverse2(TreeNode node) {
        if (node == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

}
