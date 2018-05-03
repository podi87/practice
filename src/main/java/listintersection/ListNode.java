package com.evosoft.listintersection;

/**
 * Node in a linked list.
 * 
 * DO NOT MODIFY.
 */
public class ListNode {

     int val;
     ListNode next;

     public ListNode(int value) {
         this.val = value;
         this.next = null;
     }

    public ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }

}
