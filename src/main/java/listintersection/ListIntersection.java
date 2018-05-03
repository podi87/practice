package com.evosoft.listintersection;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * Intersection could be considered
 * <p>
 * For example, the following two linked lists:
 * <p>
 * A:          a1 -> a2
 * \
 * c1 -> c2 -> c3
 * /
 * B:   b1 -> b2 -> b3
 * <p>
 * begin to intersect at node c1.
 * <p>
 * Notes:
 * - If the two linked lists have no intersection at all, return null.
 * - The linked lists must retain their original structure after the function returns.
 * - You may assume there are no cycles anywhere in the entire linked structure.
 */

public class ListIntersection {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        while (tempA.next != null) {
            ListNode tempB = headB;
            while (tempB.next != null) {
                if (tempA.equals(tempB)) {
                    return tempA;
                } else {
                    tempB = tempB.next;
                }
            }
            tempA = tempA.next;
        }
        return null;
    }
}
