package crackingcode.ch2;



/***面试题 02.02. Kth Node From End of List
 Implement an algorithm to find the kth to last element of a singly linked list. Return the value of the element.
 Note: This problem is slightly different from the original one in the book.
 Example:
 Input:  1->2->3->4->5 和 k = 2
 Output:  4
 Note:
 k is always valid.*/
public class Question2_2 {

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

    public int kthToLast1(ListNode head, int k) {
        if (head == null) return -1;
        int count = 0;
        ListNode node = head; // node For Iteration
        while (node != null) {
            count++;
            node = node.next;
        }
        int i = 0;
        while (i++ < count - k) { // head for Iteration
            head = head.next;
        }
        System.out.println("count: " + count);
        System.out.println("val: " + head.val);
        return head.val;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        Question2_2 q = new Question2_2();
        q.kthToLast1(l1, 2);
    }
}
