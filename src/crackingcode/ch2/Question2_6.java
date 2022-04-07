package crackingcode.ch2;

import java.util.Stack;

/**
 * 面试题 02.06. Palindrome Linked List
 * Implement a function to check if a linked list is a palindrome.
 * <p>
 * Example 1:
 * Input:  1->2
 * Output:  false
 * <p>
 * Example 2:
 * Input:  1->2->2->1
 * Output:  true
 * <p>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */

public class Question2_6 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * Wrongly understand the question
     */
    public boolean isPalindrome0(ListNode head) {
        ListNode i = head;
        int count = 0;
        while (i != null) {
            count++;
            i = i.next;
        }
        if (count % 2 != 0) return false;
        else {
            count /= 2;
            int j = 0;
            i = head;
            while (j++ < count) {
                i = i.next;
            }
            while (i.next != null) {
                if (head.val != i.val) return false;
            }
            return true;
        }
    }

    /**
     * Method 1: to use the Stack ds to reverse a link list
     */
    public boolean isPalindrome1(ListNode head) {
        ListNode i = head;
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        while (i != null) {
            count++;
            stack.push(i.val);
            i = i.next;
        }
        // [1,2,1] is a palindrome
        // [Definition] palindrome: a word or phrase such as 'deed' or 'level', which is the same when you spell it backwards
        // if (count % 2 != 0) return false;
        count /= 2;
        int j = 0;
        i = head;
        while (j++ < count) {
            if (i.val != stack.pop()) return false;
            i = i.next;
        }
        return true;

    }

    // TODO:Could you do it in O(n) time and O(1) space?
    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(1);
//        ln.next.next.next = new ListNode(1);
        Question2_6 q = new Question2_6();
        boolean b = q.isPalindrome1(ln);
        System.out.println(b);
    }

}
