package crackingcode.ch2;

import java.util.HashSet;
import java.util.Set;

/**
 * 面试题 02.01. Remove Duplicate Node
 * Write code to remove duplicates from an unsorted linked list.
 * <p>
 * Example1:
 * Input: [1, 2, 3, 3, 2, 1]
 * Output: [1, 2, 3]
 * <p>
 * Example2:
 * Input: [1, 1, 1, 1, 2]
 * Output: [1, 2]
 * <p>
 * Note:
 * The length of the list is within the range[0, 20000].
 * The values of the list elements are within the range [0, 20000].
 * <p>
 * Follow Up:
 * How would you solve this problem if a temporary buffer is not allowed?
 */

public class Question2_1 {

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

    /**
     * Method1: To Use Hashset to store Non-repeated Node.val, THEN rebuilt the List
     * Time O(N)
     * BUT Space O(M)
     */
    public ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null) return null;
        ListNode resultHead = new ListNode(-1);
        ListNode result;
        result = resultHead;
        HashSet<Integer> h = new HashSet<>();
        while (head != null) {
            if (!h.contains(head.val)) {
                result.next = new ListNode(head.val);
                result = result.next;
                h.add(head.val);
            }
            head = head.next;
        }
        return resultHead.next;
    }

    public ListNode removeDuplicateNodes11(ListNode head) {
        if (head == null) return null;
        ListNode resultHead = new ListNode(-1);
        resultHead.next = head; // DummyNode(Head)
        ListNode pre = head; // For Iteration
        ListNode node = head.next;
        HashSet<Integer> h = new HashSet<>();
        h.add(pre.val);
        while (node != null) {
            if (!h.contains(node.val)) {
                h.add(node.val);
                pre = node;
                node = pre.next;
            } else {
                pre.next = node.next;
                node = node.next;
            }
        }
        return resultHead.next;
    }

    public ListNode removeDuplicateNodes111(ListNode head) {
        if (head == null) return null;
        ListNode resultHead = new ListNode(-1);
        resultHead.next = head; // DummyNode(Head)
        ListNode node = resultHead; // For Iteration
        HashSet<Integer> h = new HashSet<>();
        while (node.next != null) {
            if (!h.contains(node.next.val)) {
                h.add(node.next.val);
                node = node.next;
            } else {
                node.next = node.next.next; // Delete the Node
            }
        }
        return resultHead.next;
    }

    /**
     * 单链表，删除节点Node
     * node.next -> node.next.next
     */
    public ListNode removeDuplicateNodes1111(ListNode head) {
        if (head == null) return null;
        ListNode node = head; // to Use THE NODE for iteration
        Set<Integer> h = new HashSet<>();
        h.add(head.val);
        while (node.next != null) {
            if (!h.contains(node.next.val)) {
                h.add(node.next.val);
                node = node.next;
            } else { // IF the Value is already in the Buffer(h)
                node.next = node.next.next; // Delete the Node
            }
        }
        return head;
    }

    /**
     * Method2: Delete One Node(in a link)
     * 单链表，删除节点Node
     * node.next -> node.next.next
     */
    public ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null) return null;
        ListNode node = new ListNode(-1);
        ListNode first = new ListNode(-1);
        ListNode second = new ListNode(-1);
        first = head;
        second = head.next;
        node = head;
        while (first != null) {
            while (second != null) {
                if (first.val == second.val) node.val = -1;
                second = second.next;
            }
            first = first.next;

        }
        return node.next;
    }

    //TODO: Use Time O(N^2) Space O(1) To Exercise Delete a Node(in a singly list)
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        Question2_1 q = new Question2_1();
        q.removeDuplicateNodes1111(l1);
    }
}
