package crackingthecodinginterview.ch1;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 01.07. Rotate Matrix LCCI
 * <p>
 * Given an image represented by an N x N matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 * <p>
 * Example 1:
 * Given matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * Rotate the matrix in place. It becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 **/


public class Question1_7 {


    public void rotate(int[][] matrix) {
        int N = matrix.length;
        int count = 0;
        HashSet<Integer> h = new HashSet<>();
        int rowline = 0;
        int temp = 0;
        int[] index = new int[2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 && j == 0) {
                    h.add(1);
                    temp = matrix[j][matrix.length - 1 - i];
                    index = recurR(matrix, i, j);
                    rowline = index[0] * N + index[1] + 1;

                }
                while (!h.contains(rowline)) {
                    h.add(rowline);
                    //matrix[index[0]][index[1]] = temp;
                    matrix[index[1]][matrix.length - 1 - index[0]] = temp;
                    index = recurR(matrix, index[0], index[1]);
                    temp = matrix[index[0]][index[1]];
                    rowline = index[0] * N + index[1] + 1;
                }

            }
        }

    }

    private static int[] recurR(int[][] matrix, int i, int j) {
        int[] index = new int[2];
        matrix[j][matrix.length - 1 - i] = matrix[i][j];
        index[0] = j;
        index[1] = matrix.length - 1 - i;
        return index;
    }

    public static void main(String[] args) {
        Question1_7 q = new Question1_7();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }
        q.rotate(matrix);
        System.out.println("----");
        for (int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }

    }


}
