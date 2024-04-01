package com.my016.arithmetic.t3;


import java.util.Objects;

public class Tree {

    //树节点定义
    private static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    //列表简单设计
    private static class List<T>{

        private Tree.Node<T> tNode;

        private int num;

        public int length(){
            return num;
        }

        public boolean isEmpty(){
            return num == 0;
        }

        public T get(int index){
            if (index >= num || index <0){
                return null;
            }
            Tree.Node<T> p = tNode.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            return p.item;
        }

        public void add(T t){
            Tree.Node<T> p = tNode;
            while (p.next != null){
                p = p.next;
            }
            Tree.Node<T> temp = new Tree.Node<>();
            temp.item = t;
            temp.next = null;
            p.next = temp;
            num++;
        }

        public void add(int index, T t){
            if (index > num || index <0){
                return;
            }
            if(index == num){
                add(t);
                return;
            }
            Tree.Node<T> p = tNode;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            Tree.Node<T> last = p.next;
            p.next = new Tree.Node<>();
            p.next.item = t;
            p.next.next = last;
            num++;
        }

        public List(){
            tNode = new Tree.Node<>();
            tNode.item = null;
            tNode.next = null;
            num = 0;
        }

        @Override
        public String toString() {
            return tNode.next.toString();
        }
    }

    //栈简单设计
    private static class Stack<T>{
        private Tree.Node<T> root;
        private int num;

        public Stack(){
            root = new Tree.Node<>();
            root.item = null;
            root.next  = null;
            num = 0;
        }

        public void push(T t){
            Tree.Node<T> p = root.next;
            root.next = new Tree.Node<>();
            root.next.item = t;
            root.next.next = p;
            num++;
        }

        public int length(){
            return num;
        }

        public boolean isEmpty(){
            return  num == 0;
        }

        public T pop(){
            if (isEmpty()){
                return null;
            }
            Tree.Node<T> p = root.next;
            root.next = root.next.next;
            num--;
            return p.item;
        }

        @Override
        public String toString() {
            return root.next.toString();
        }
    }

    //公共节点设计
    private static class Node<T>{
        public T item;
        public Node<T> next ;

        public Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }

        public Node(){

        }

        public Node(T[] t){
            Node<T> p = this;
            for (int i = 0; i < t.length; i++) {
                assert p != null;
                p.item = t[i];
                p.next = i < t.length -1 ? new Node<>() : null ;
                p = p.next;
            }
        }

        @Override
        public String toString() {
            return "[" +
                    forNode() +
                    ']';
        }

        private String forNode(){
            if (item==null){
                return null;
            }
            StringBuilder stringBuffer = new StringBuilder();
            Node<T> p = this;
            while (p.next!=null){
                stringBuffer.append(p.item.toString()).append(",");
                p=p.next;
            }
            stringBuffer.append(p.item.toString());
            return stringBuffer.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(item, node.item) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(item, next);
        }

    }

    //非递归后序遍历树
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new List<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return result;
        }

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(0, current.val);  // 将当前节点值插入结果列表的开头

            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.right != null) {
                stack.push(current.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // 构建一个二叉树
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        // 输出后序遍历结果
        List<Integer> result = postorderTraversal(root);
        System.out.println(result);  // 应该输出 [3, 2, 1]
    }
}
