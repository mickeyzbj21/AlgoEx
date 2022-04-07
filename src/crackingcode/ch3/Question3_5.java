package crackingcode.ch3;

import java.util.Stack;

/**
 * 面试题 03.05. Sort of Stacks
 * Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty. When the stack is empty, peek should return -1.
 * <p>
 * Example1:
 * <p>
 * Input:
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 * Output:
 * [null,null,null,1,null,2]
 * Example2:
 * <p>
 * Input:
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 * Output:
 * [null,null,null,null,null,true]
 * Note:
 * <p>
 * The total number of elements in the stack is within the range [0, 5000].
 */

public class Question3_5 {

    private Stack<Integer> stack;

    // Method 1. Use a auxiliary array: when pushing a item, sort the all stack
    public Question3_5() {
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // Arrays.sort(stack.toArray());
        stack.sort((x1, x2) -> {
            if (x1 > x2) return 1;
            else if (x1 < x2) return -1;
            else return 0;
        });
    }// Nlog(N) * M

    public void pop() {
        stack.pop();
    }

    public int peek() {
        if (stack.isEmpty()) return -1;
        else return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Your SortedStack object will be instantiated and called as such:
     * SortedStack obj = new SortedStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.isEmpty();
     */
    public static void main(String[] args) {

    }
}
