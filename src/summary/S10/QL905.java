package summary.S10;

import java.util.Arrays;

/**
 * 905. Sort Array By Parity
 */
//TAG: Sort
public class QL905 {

    // Method: to use the Partitioning Method in QuickSort(in place swap)
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (true) {
            if (j <= i) break;
            while (nums[i] % 2 == 0) { // to get an Odd
                if (i >= j) break;
                i++;
            }
            while (nums[j] % 2 != 0) { // to get an Even
                if (j <= i) break;
                j--;
            }
            swap(nums, i++, j--);
        }
        return nums;
    }
    // Method : to check a num is odd or even
    // Even num%2==0
    // Odd  num%2!=0

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        QL905 q = new QL905();
        int[] nums = new int[]{0};
        int[] res = q.sortArrayByParity(nums);
        System.out.println(Arrays.toString(res));
    }
}
