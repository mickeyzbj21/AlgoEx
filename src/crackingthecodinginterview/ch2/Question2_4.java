package crackingthecodinginterview.ch2;

/**
 * 面试题 02.04. Partition List LCCI
 * Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after the elements less than x (see below). The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 3->5->8->5->10->2->1, x = 5
 * Output: 3->1->2->10->5->5->8
 **/
public class Question2_4 {

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


    public ListNode partition1(ListNode head, int x) {
        if (head == null) return null;
        ListNode nodeBig = new ListNode(x);
        ListNode nodeBigHead = nodeBig;
        ListNode nodeSmall = new ListNode(x);
        ListNode nodeSmallHead = nodeSmall;
        while (head != null) {
            // Add Smaller Ones to List1
            if (head.val < x) {
                nodeSmall.next = new ListNode(head.val);
                nodeSmall = nodeSmall.next;
            }
            // Add Bigger Ones(or equal) to List2
            else {
                nodeBig.next = new ListNode(head.val);
                nodeBig = nodeBig.next;
            }
            head = head.next;
        }
        // Add List1+List2
        nodeSmallHead = nodeSmallHead.next;
        nodeBigHead = nodeBigHead.next;
        ListNode node = nodeSmallHead;
        if (node != null) {
            while (node.next != null) {
                node = node.next;
            }
            node.next = nodeBigHead;
            head = nodeSmallHead;
        } else
            head = nodeBigHead;
        return head;
    }
    // Time: O(N); Space: N

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        Question2_4 q = new Question2_4();
        ListNode list2 = q.partition1(list1, 0);
        System.out.println(list2);
    }


}
