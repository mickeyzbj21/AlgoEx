package crackingthecodinginterview.ch2;

import java.util.HashSet;


/**
 * 面试题 02.08. Linked List Cycle
 * Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
 * Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: tail connects to node index 1
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: tail connects to node index 0
 */
public class Question2_8 {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    /**
     * Solution 1:Use Hashset to store ListNode (Use extra space to solve the problem)
     * - IF Finding out adding the same ListNode
     * - THEN the ListNode is the corrupt one
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode node = null;
        HashSet<ListNode> h = new HashSet<>();
        h.add(head);
        while (head != null) {
            if (h.contains(head.next)) {
                node = head.next;
                break;
            }
            h.add(head.next);
            head = head.next;
        }
        //System.out.println(node.val);
        return node;
    }

    /**
     * Solution 2: Use Fast-Slow Pointer to detect the cycle
     * 1. 数学计算证明:倍数问题
     * 2. 注意.next的空指针问题
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode p1 = head; // Slow Pointer
        ListNode p2 = head; // Fast Pointer
        while (head != null) {
            if (null == p1.next || null == p2.next || null == p2.next.next) return null;
            else {
                p1 = p1.next;
                p2 = p2.next.next;
                if (p1 == p2) {
                    while (head != p1) {
                        head = head.next;
                        p1 = p1.next;
                    }
                    return head;
                }
            }
        }
        return head;
    }


    public static void main(String[] args) {
        Question2_8 q = new Question2_8();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l2;
//        ListNode l1 = new ListNode(1);
        ListNode p = q.detectCycle2(l1);
        System.out.println("P: " + p);
        if (p != null) System.out.println(p.val);

    }
}
