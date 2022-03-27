package leetcode;
//53. 最大子数组和
//https://leetcode-cn.com/problems/maximum-subarray/
//贪心算法：What is Greedy Algorithm? As proceeding a step, just find the locally optimal solution.

public class Solution2 {
    public int maxSubArray(int[] nums) {
        int max = 0;
        max = nums[0];
        if (nums.length == 1) return max;
        int sumsub = 0;
        for (int num : nums) {
            if (sumsub < 0) sumsub = 0; //贪心算法: 当i前面条目之和为负数，舍弃，sumsub重新开始。
            sumsub += num;
            if (sumsub > max) max = sumsub; //Max为Sumsub中最大的那个。
        }
        System.out.println(max);
        return max;
    }


    public static void main(String[] args) {
        int[] nums = {-2, -1,-3, -4};
        new Solution2().maxSubArray(nums);
    }
}