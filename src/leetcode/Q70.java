package leetcode;
/**
 * 70. Climbing Stair
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 */


public class Q70 {

    private static int climbsub1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbsub1(n - 1) + climbsub1(n - 2);
    }

    // To use Recursion 递归
    public int climbStairs1(int n) {
        return climbsub1(n);
    }


    // To use Induction 递推/动态规划
    public int climbStairs2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int sum = 0;
        int s1 = 1;
        int s2 = 2;
        for (int i = 3; i <= n; i++) {
            sum = s1 + s2;
            s1 = s2;
            s2 = sum;
        }
        return sum;
    }


    public static void main(String[] args) {
        Q70 q = new Q70();
        System.out.println(q.climbStairs2(45));
    }
}
