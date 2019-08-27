package com.xhk.practice.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 启动类
 *
 * @author xuhaikun
 * @date 2019-07-14
 */
public class TreeMain {

    /**
     *      1
     *   2    3
     *    4  5 6
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode lr = new TreeNode(4);
        TreeNode rl = new TreeNode(5);
        TreeNode rr = new TreeNode(6);
        root.left = left;
        root.right = right;
        left.right = lr;
        right.left = rl;
        right.right = rr;
        // 从上往下遍历
        //printlnTree(root);
        // 递归前序遍历
        traverseTreeUseBeforeUseRecursion(root);

        // 非递归前序遍历
        traverseTreeUseBefore(root);

        // 非递归中序遍历
        traverseTreeUseMiddle(root);

    }

    /**
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
     *
     * @param node 根节点
     */
    public static void printlnTree(TreeNode node) {
        System.out.println("同层节点从左至右打印");
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode nodeInside = queue.remove();
            System.out.println(nodeInside.val);
            if (nodeInside.left != null) {
                queue.add(nodeInside.left);
            }
            if (nodeInside.right != null) {
                queue.add(nodeInside.right);
            }
        }
    }

    /**
     * 二叉树的递归前序遍历
     *
     * @param node
     */
    public static void traverseTreeUseBeforeUseRecursion(TreeNode node) {
        System.out.println("二叉树的递归前序遍历");
        if (node != null) {
            System.out.println(node.val);
            traverseTreeUseBeforeUseRecursion(node.left);
            traverseTreeUseBeforeUseRecursion(node.right);
        }
    }

    /**
     * 二叉树的非递归前序遍历 根左右
     * <p>
     * 思路是直接把根打印，把当前节点的右节点入栈，再处理左节点
     *
     * @param node
     */
    public static void traverseTreeUseBefore(TreeNode node) {
        System.out.println("二叉树的非递归前序遍历");
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || node != null) {
            if (node != null){
                System.out.println(node.val);
                if (node.right != null){
                    stack.push(node.right);
                }
                node = node.left;
            } else {
                node = stack.pop();
            }
        }
    }

    /**
     * 二叉树中序遍历 左根右
     *
     * 遍历到左节点为空，便pop
     *
     * @param node
     */
    public static void traverseTreeUseMiddle(TreeNode node){
        System.out.println("二叉树中序遍历 左根右");
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
    }

    /**
     * 二叉树非递归后序遍历 左右根
     *
     * @param treeNode 根节点
     */
    public static void traverseTreeUseAfter(TreeNode treeNode){
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() && treeNode != null){
            if (treeNode != null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                treeNode = stack.pop();
                System.out.println(treeNode.val);
                if (treeNode.right != null){
                    stack.push(treeNode.right);
                }
            }
        }
    }
}
