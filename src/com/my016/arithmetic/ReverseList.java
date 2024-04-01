package com.my016.arithmetic;

import com.my016.list.ListNode;
import com.my016.list.Node;

public class ReverseList {

    public static void main(String[] args) {
        Integer[] arr = {1,2,3};
        ListNode node = new ListNode(arr);
        System.out.println(node);
        System.out.println(new Solution().ReverseList(node));
    }

    private static class Solution {
        public Node ReverseList(Node head) {
            if (head == null){
                return null;
            }
            Node p = head;
            p =  p.next;
            head.next = null;
            while (p!=null){
                Node t =  p.next;
                p.next = head;
                head = p;
                p = t;
            }
            return head;
        }
    }

}
