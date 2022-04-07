package crackingcode.ch2;

import java.math.BigInteger;

/**
 * 面试题 02.05. Sum Lists LCCI
 * You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * Example:
 * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2). That is, 617 + 295.
 * Output: 2 -> 1 -> 9. That is, 912.
 * Follow Up: Suppose the digits are stored in forward order. Repeat the above problem.
 * Example:
 * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5). That is, 617 + 295.
 * Output: 9 -> 1 -> 2. That is, 912.
 **/
public class Question2_5 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 一般情况可以通过，除非大于Long的情况
    public ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
        ListNode list;
        ListNode node = new ListNode(0);
        list = node;
        long i = 0L;
        long digit = 0L;
        long multi = 0L;
        long val1, val2;
        while (l1 != null || l2 != null) {
            if (l1 != null) val1 = l1.val;
            else val1 = 0;
            if (l2 != null) val2 = l2.val;
            else val2 = 0;
            multi = (long) Math.pow(10, i++);
            digit = digit + (val1 + val2) * multi;
            node.next = new ListNode((int) (digit % (multi * 10) / multi));
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            node = node.next;
        }
        if (digit / (multi * 10) != 0) node.next = new ListNode((int) (digit / (multi * 10)));
        // System.out.println(list);
        return list.next;
    }

    // Cannot Go Through (Even BigInteger)
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode list;
        ListNode node = new ListNode(0);
        list = node;
        int i = 0;
        BigInteger digit = BigInteger.valueOf(0L);
        BigInteger multi = BigInteger.valueOf(0L);
        long val1, val2;
        while (l1 != null || l2 != null) {
            if (l1 != null) val1 = l1.val;
            else val1 = 0;
            if (l2 != null) val2 = l2.val;
            else val2 = 0;
            multi = BigInteger.valueOf((long) Math.pow(10, i++));
            digit = multi.multiply(BigInteger.valueOf(val1 + val2)).add(digit);
            node.next = new ListNode((int) ((digit.mod((multi.multiply(BigInteger.valueOf(10L)))).divide(multi)).longValue()));
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            node = node.next;
        }
        if (digit.divide(multi.multiply(BigInteger.valueOf(10L))).longValue() != 0)
            node.next = new ListNode((int) (digit.divide(multi.multiply(BigInteger.valueOf(10L)))).longValue());
        System.out.println(list);
        return list.next;
    }

    // Use 1 digit to store the Number on this Position
    // Use 1 digit to store the Carry
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode list;
        ListNode node = new ListNode(0);
        list = node;
        int val1, val2;
        int carry = 0;
        int val;
        while (l1 != null || l2 != null) {
            if (l1 != null) val1 = l1.val;
            else val1 = 0;
            if (l2 != null) val2 = l2.val;
            else val2 = 0;
            val = (val1 + val2 + carry) % 10;
            node.next = new ListNode(val);
            carry = (val1 + val2 + carry) / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            node = node.next;
        }
        if (carry != 0) node.next = new ListNode(carry);
        // System.out.println(list);
        return list.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next =new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(4);
        Question2_5 q = new Question2_5();
        q.addTwoNumbers2(l1, l2);

    }
}
