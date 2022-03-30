package crackingthecodinginterview.ch2;

import java.math.BigInteger;

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
    long val1,val2;
        while(l1!=null||l2!=null){
        if(l1!=null) val1= l1.val; else val1=0;
        if(l2!=null) val2 = l2.val; else val2=0;
        multi = (long)Math.pow(10,i++);
        digit = digit + (val1 + val2)*multi;
        node.next = new ListNode((int) ( digit%(multi*10)/multi));
        if(l1!=null) l1=l1.next;
        if(l2!=null) l2=l2.next;
        node =node.next;
    }
        if(digit/(multi*10)!=0) node.next = new ListNode((int)( digit / (multi * 10)));
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
        long val1,val2;
        while(l1!=null||l2!=null){
            if(l1!=null) val1= l1.val; else val1=0;
            if(l2!=null) val2 = l2.val; else val2=0;
            multi = BigInteger.valueOf((long) Math.pow(10,i++));
            digit = multi.multiply(BigInteger.valueOf(val1 + val2)).add(digit);
            node.next = new ListNode((int) ( (digit.mod((multi.multiply(BigInteger.valueOf(10L)))).divide(multi)).longValue()));
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            node =node.next;
        }
        if(digit.divide(multi.multiply(BigInteger.valueOf(10L))).longValue()!=0) node.next = new ListNode((int)(digit.divide(multi.multiply(BigInteger.valueOf(10L)))).longValue());
        System.out.println(list);
        return list.next;
    }
    // Use 1 digit to store the Number on this Position
    // Use 1 digit to store the Carry
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode list;
        ListNode node = new ListNode(0);
        list = node;
        int val1,val2;
        int carry = 0;
        int val;
        while(l1!=null||l2!=null) {
            if(l1!=null) val1= l1.val; else val1=0;
            if(l2!=null) val2 = l2.val; else val2=0;
            val = (val1+val2+carry)%10;
            node.next = new ListNode(val);
            carry = (val1+val2+carry)/10;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            node =node.next;
        }
        if(carry!=0) node.next = new ListNode(carry);
        // System.out.println(list);
        return list.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.next =new ListNode(4);
//        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next =new ListNode(9);
//        l2.next.next = new ListNode(4);
        Question2_5 q = new Question2_5();
        q.addTwoNumbers2(l1,l2);

    }
}
