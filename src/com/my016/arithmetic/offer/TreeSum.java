package com.my016.arithmetic.offer;

import com.my016.arithmetic.Scanner;

import java.util.LinkedList;
import java.util.Queue;

public class TreeSum {

    public static void main(String[] args) {

        String s = "[4,9,0,5,1]";

        s = s.replaceAll("\\[", "");
        s = s.replaceAll("]", "");
        s = s.replaceAll(",", "");
        s = s.replaceAll(" ", "");
        //字符串转数字数组
        int[] nums = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            nums[i] = s.charAt(i) - '0';
        }
        TreeNode treeNode = buildTree(nums);
        long start = System.currentTimeMillis();
        int nt = new Solution().sumNumbers(treeNode);
        long end = System.currentTimeMillis();
        System.out.println("结果为：" + nt + "，耗时：" + (end - start) + "ms");
    }

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

    //构建树的函数，形如[4,9,0,5,1]，或[1,2,3]
    public static TreeNode buildTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        queue.offer(root);

        int index = 1; // Start from the second element in the array

        while (index < nums.length) {
            TreeNode currentNode = queue.poll();

            if (nums[index] != -1) { // Assuming -1 represents a null node in the array
                currentNode.left = new TreeNode(nums[index]);
                queue.offer(currentNode.left);
            }

            index++;

            if (index < nums.length && nums[index] != -1) { // Assuming -1 represents a null node in the array
                currentNode.right = new TreeNode(nums[index]);
                queue.offer(currentNode.right);
            }

            index++;
        }

        return root;
    }

    private static class Solution {

        int sum = 0;

        int[] value = new int[10];


        public int sumNumbers(TreeNode root) {

            travel(root, 0);

            return sum;

        }

        /**
         * 将指定长度的数组元素转换为一个整数。
         * @param length 数组的长度，表示要转换的元素个数。
         * @return 转换后的整数值。
         * @throws IllegalArgumentException 如果数组中的元素不在0到9之间，则抛出异常。
         */
        public int valueToInt(int length){
            int result = 0; // 初始化结果为0
            int[] array = value; // 使用类成员变量value作为要转换的数组

            // 遍历数组，将每个元素转换为整数
            for (int i = 0; i < length; i++) {
                // 检查数组元素是否在合法范围内
                if (array[i] < 0 || array[i] > 9) {
                    throw new IllegalArgumentException("Array elements must be between 0 and 9");
                }
                // 将每个数字添加到结果中
                result = result * 10 + array[i];
            }

            return result; // 返回转换后的整数
        }

        public void travel(TreeNode node, int nowtLayer){
            if (node == null){
                return;
            }
            value[nowtLayer] = node.val;
            if (node.left != null){
                travel(node.left, nowtLayer + 1);
            }
            if (node.right != null){
                travel(node.right, nowtLayer + 1);
            }
            if (node.left == null && node.right == null){
                sum += valueToInt(nowtLayer + 1);
            }
        }

    }

}
