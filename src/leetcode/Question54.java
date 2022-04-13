package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 54.Spiral Matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */

public class Question54 {

    public List<Integer> spiralOrder1(int[][] matrix) {
        int n = matrix[0].length; // column
        int m = matrix.length; // row
        List<Integer> list = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                list.add(matrix[i][0]);
            }
            return list;
        }
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                list.add(matrix[0][i]);
            }
            return list;
        }
        int a = 0;
        int b = 1;
        int in = n - 1;
        int im = m - 1;
        while ((in > 0 && im > 0) || (in == 0 && im >= 0) || (in >= 0 && im == 0)) {
            int k = 0;
            k = a;
            for (int j = 0; j < in; j++) {
                list.add(matrix[a][k++]);
            }
            k = a;
            for (int j = 0; j < im; j++) {
                list.add(matrix[k++][n - b]);
            }
            k = n - b;
            for (int j = 0; j < in; j++) {
                list.add(matrix[m - b][k--]);
            }
            k = m - b;
            for (int j = 0; j < im; j++) {
                list.add(matrix[k--][a]);
            }
            a++;
            b++;
            in -= 2;
            im -= 2;
        }
//        if (m % 2 != 0) {
//            int k = a;
//            for (int j = list.size(); j <=m*n; j++) {
//                list.add(matrix[a][k++]);
//            }
//        }
        System.out.println("[SIZE1-1]: " + list.size());
        if (list.size() < m * n) {
            if (m % 2 != 0) {
                list.add(matrix[m / 2][n / 2]);
            }
        }
        System.out.println("[SIZE1-2]: " + list.size());
        return list.subList(0, n * m);
    }

    // Method: By using QL56, but the diff is the 2-D array(QL56 is n*n Array but QL54 is n*m Array)
    public List<Integer> spiralOrder2(int[][] matrix) {
        int n = matrix[0].length; // column
        int m = matrix.length; // row
        List<Integer> list = new ArrayList<>();
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                list.add(matrix[i][0]);
            }
            return list;
        }
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                list.add(matrix[0][i]);
            }
            return list;
        }
        int a = 0;
        int b = 1;
        int in = n - 1;
        int im = m - 1;
        //while((in>0||im>0)&&list.size()<n*m) { // TIP: When size>=n*m, it has all nums
        while ((in > 0 || im > 0) && (a < m && a < n)) { // TIP: a>m||a>n matrix[a][k++] will be out of bound E.g.{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}};
            int k = 0;
            k = a;
            for (int j = 0; j < in; j++) {
                list.add(matrix[a][k++]);
            }
            k = a;
            for (int j = 0; j < im; j++) {
                list.add(matrix[k++][n - b]);
            }
            k = n - b;
            for (int j = 0; j < in; j++) {
                list.add(matrix[m - b][k--]);
            }
            k = m - b;
            for (int j = 0; j < im; j++) {
                list.add(matrix[k--][a]);
            }
            a++;
            b++;
            in -= 2;
            im -= 2;
        }
        System.out.println("[SIZE2]: " + list.size());
        if (list.size() < m * n) {
            if (m % 2 != 0) {
                list.add(matrix[m / 2][n / 2]);
            }
        }
        System.out.println("[SIZE2]: " + list.size());
        return list.subList(0, n * m);
    }

    public static void main(String[] args) {
        Question54 q = new Question54();
        int[][] m0 = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}};
        int[][] m1 = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}};//12
        int[][] m2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};//9
        int[][] m3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};//12
        int[][] m4 = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {14, 15, 16}};//15
        int[][] m5 = {{2, 3, 4}, {5, 6, 7}, {8, 9, 10}, {11, 12, 13}, {111, 112, 113}, {211, 212, 213}};//18

        List a0 = q.spiralOrder2(m0);
        System.out.println(Arrays.toString(a0.toArray()));
//        List a1 = q.spiralOrder2(m1);
//        System.out.println(Arrays.toString(a1.toArray()));
//        System.out.println(Arrays.toString(q.spiralOrder1(m1).toArray()));
//        List a2 = q.spiralOrder2(m2);
//        System.out.println(Arrays.toString(a2.toArray()));
//        System.out.println(Arrays.toString(q.spiralOrder1(m2).toArray()));
//        List a3 = q.spiralOrder2(m3);
//        System.out.println(Arrays.toString(a3.toArray()));
//        System.out.println(Arrays.toString(q.spiralOrder1(m3).toArray()));
//        List a4= q.spiralOrder2(m4);
//        System.out.println(Arrays.toString(a4.toArray()));
//        System.out.println(Arrays.toString(q.spiralOrder1(m4).toArray()));
    }

}
