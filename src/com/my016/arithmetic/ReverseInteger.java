package com.my016.arithmetic;

public class ReverseInteger {

    public static void main(String[] args) {
        int data = Scanner.nextInt();
        int finalInt = new Solution().reverse(data);
        System.out.println(finalInt);
    }

    private static class Solution {
        public int reverse(Integer x) {
            try {
                return   Integer.parseInt(nodeToString(x.toString()));
            } catch (NumberFormatException e) {
                return 0;
            }
        }

        private String nodeToString(String s){
            Node node = new Node();
            for (int i = 0; i < s.length(); i++) {
                node.insertHeard(s.charAt(i));
            }
            return node.toString();
        }

        private static class Node{
           private   char val ;
           private   Node next;

          public void insertHeard(char val){

                  Node temp = new Node();
                  temp.setVal(val);
                  temp.setNext(this.next);
                  this.next = temp;

          }

          public Node(){
              this.val = ' ';
              this.next = null;
          }

            public char getVal() {
                return val;
            }

            public void setVal(char val) {
                this.val = val;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            private String forEachNode(){
              StringBuilder sb = new StringBuilder();
              Node p = this.next;
              while (p!= null){
                  if (p.val == '-'){
                      return '-'+sb.toString();
                  }
                  sb.append(p.val);
                  p = p.next;
              }
              return sb.toString();
            }

            @Override
            public String toString() {
                return forEachNode();
            }
        }
    }

    private static class Solution1{
        
    }
}

