package leetcode;//88. 合并两个有序数组
//https://leetcode-cn.com/problems/merge-sorted-array/

import java.util.Arrays;
import java.util.HashSet;

public class Solution1 {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        System.out.println(Arrays.toString(nums1));
        nums1 = ShellSort(nums1);
        System.out.println(Arrays.toString(nums1));
    }


    public static int[] sort(int[] nums1, int m, int[] nums2, int n) {
        int j = m - 1;
        int i = n - 1;
        for (int k = 0; k < m + n; k++) {
            if (i < 0) break;
            if (j < 0||nums1[j] < nums2[i]) {
                nums1[m + n - 1 - k] = nums2[i];
                i--;
            } else {
                nums1[m + n - 1 - k] = nums1[j];
                j--;
            }
        }
        System.out.println("nums1:" + Arrays.toString(nums1));
        return nums1;
    }


    public static int[] ShellSort(int[] array) {
        int N = array.length;
        int h = 1;
        while (h < N / 3) h = h * 3 + 1; // 1,4,13...
        while (1 <= h) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && array[j] < array[j - h]; j -= h) {
                    int ech = array[j];
                    array[j] = array[j - h];
                    array[j - h] = ech;
                }
            }
            h = h / 3;
        }
        return array;
    }


    public static void main(String[] args) {
        int[] nums1 = {3,3,4,0,0,0};
        int[] nums2 = {2,2,2};
        Solution1 solution = new Solution1();
        nums1 = solution.sort(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        HashSet hs = new HashSet();
    }
}