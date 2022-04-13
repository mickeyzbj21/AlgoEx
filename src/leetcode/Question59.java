package leetcode;

/**
 * 59. Spiral Matrix II
 * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * Example 1:
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * Example 2:
 * Input: n = 1
 * Output: [[1]]
 * Constraints:
 * 1 <= n <= 20
 */

public class Question59 {

    public int[][] generateMatrix(int n) {
        int a = 0;
        int b = 1;
        int[][] array = new int[n][n];
        int x = 1;
        for (int i = n - 1; 0 < i; i -= 2) {
            int k = 0;
            k = a;
            for (int j = 0; j < i; j++) {
                array[a][k++] = x++;
            }
            k = a;
            for (int j = 0; j < i; j++) {
                array[k++][n - b] = x++;
            }
            k = n - b;
            for (int j = 0; j < i; j++) {
                array[n - b][k--] = x++;
            }
            k = n - b;
            for (int j = 0; j < i; j++) {
                array[k--][a] = x++;
            }
            a++;
            b++;
        }
        if (n % 2 != 0) array[n / 2][n / 2] = x;
        return array;
    }

    public static void main(String[] args) {
        Question59 q = new Question59();
        q.generateMatrix(5);
    }

}
