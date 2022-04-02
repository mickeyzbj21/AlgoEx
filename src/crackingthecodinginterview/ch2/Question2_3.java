package crackingthecodinginterview.ch2;

import java.util.Random;

/**
 * 面试题 02.03. Delete Middle Node
 * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.
 * <p>
 * Example:
 * Input: the node c from the linked list a->b->c->d->e->f
 * Output: nothing is returned, but the new linked list looks like a->b->d->e->f
 */

public class Question2_3 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // To be you, and kill you.
    public void deleteNode0(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public void deleteNode1(ListNode node) {
        ListNode i = node;
        int count = 0;
        while (i != null) {
            count++;
            i = i.next;
        }
        if (count != 1 || count != 2) {
            int num = new Random().nextInt(count);
            i = node;
            int j = 0;
            while (j++ < num) {
                i = i.next;
            }
            i.next = i.next.next;
        }
        System.out.println("END");
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode sentinal = head;
        for (int i = 1; i < 10; i++) {
            ListNode ln = new ListNode(i);
            head.next = ln;
            head = head.next;
        }
        Question2_3 q = new Question2_3();
        q.deleteNode1(sentinal);
    }
}
