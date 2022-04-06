package crackingthecodinginterview.ch3;

import java.util.Stack;

/**
 * 面试题 03.02. Min Stack
 * How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 * <p>
 * Example:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> return -3.
 * minStack.pop();
 * minStack.top();      --> return 0.
 * minStack.getMin();   --> return -2.
 */

public class Question3_2 {

    /**
     * 1.GIST: The gist is to use the Second stack to store the MinValue
     * Synchronize the state‘s minValue to miniStack (in order to make getMin() in O(1) time)
     * 2.MinValue: The mini value can be calculated
     * by just comparing (the least pushing value IN miniStack) and (the value that will be pushed IN stack)
     * That is newMin = Min(miniStack.peek(), value)
     * THEN miniStack.push(newMin)
     */
    private Stack<Integer> miniStack;
    private Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public Question3_2() {
        miniStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (miniStack.isEmpty()) miniStack.push(x);
        else {
            int min = miniStack.peek();
            int newMin = x < min ? x : min;
            miniStack.push(newMin);
        }
    }

    public void pop() {
        stack.pop();
        miniStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return miniStack.peek();
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    public static void main(String[] args) {

    }
}
