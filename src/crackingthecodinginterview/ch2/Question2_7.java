package crackingthecodinginterview.ch2;

import java.util.Stack;

/**
 * 面试题 02.07. Intersection of Two Linked Lists
 * Given two (singly) linked lists, determine if the two lists intersect. Return the inter­ secting node. Note that the intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
 * <p>
 * Example 1:
 * <p>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */

public class Question2_7 {

    private ListNode head1;

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode node;
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        node = headA;
        while (node != null) {
            s1.push(node);
            node = node.next;
        }
        node = headB;
        while (node != null) {
            s2.push(node);
            node = node.next;
        }
        int s1size = s1.size();
        int s2size = s2.size();
        int size = s1size < s2size ? s1size : s2size;
        if (s1.peek() != s2.peek()) return null;
        ListNode result3 = null;
        for (int i = 0; i < size; i++) {
            ListNode result1 = s1.peek();
            ListNode result2 = s2.peek();
            if (result1 != result2) return result3;
            result3 = s1.pop();
            s2.pop();
        }
        return s1size == s2size ? headA : result3;
    }

    public static ListNode reverseLinkList(ListNode list) {
        if (list == null) return list;
        reverseLinkList(list.next);
        System.out.println(list.val);
        return list;
    }

    public static ListNode reverseLinkList2(ListNode list1, ListNode list2) {
        if (list1 == null) return list1;
        if (list2 == null) return list2;
        reverseLinkList2(list1.next, list2.next);
        System.out.println(list1.val);
        System.out.println(list2.val);
        return list1;
    }


    // TODO:Your code should preferably run in O(n) time and use only O(1) memory.
    public static void main(String[] args) {
        ListNode head1 = new ListNode(-1);
        ListNode sentinal1 = head1;
        ListNode head2 = new ListNode(-1);
        ListNode sentinal2 = head2;
        for (int i = 1; i < 10; i++) {
            ListNode ln = new ListNode(i);
            head1.next = ln;
            head1 = head1.next;
        }
        for (int i = 11; i < 16; i++) {
            ListNode ln = new ListNode(i);
            head2.next = ln;
            head2 = head2.next;
        }
        Question2_7 q = new Question2_7();
        //q.getIntersectionNode(sentinal,null);
        //ListNode test = reverseLinkList(sentinal);
        //ListNode test2 = reverseLinkList2(sentinal1,sentinal2);
        ListNode l1 = new ListNode(3);
//        l1.next = new ListNode(8);
//        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = l1;
//        l2.next = new ListNode(8);
//        l2.next.next = new ListNode(5);
        ListNode t = q.getIntersectionNode(l1, l2);
        System.out.println(t.val);
    }
}
