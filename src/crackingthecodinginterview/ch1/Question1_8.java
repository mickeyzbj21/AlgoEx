package crackingthecodinginterview.ch1;

import java.util.Arrays;

/**
 * 面试题 01.08. Zero Matrix LCCI
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * Output:
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * Example 2:
 * <p>
 * Input:
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * Output:
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 **/
public class Question1_8 {

    public void setZeroes1(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        /** to Use an Auxiliary Array to store the final version **/
        int[][] matrixCopy = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                } else matrixCopy[i][j] = matrix[i][j];
                for (int k = 0; k < N; k++) {
                    if (matrix[i][k] == 0) {
                        matrixCopy[i][j] = 0;
                        break;
                    }
                    ;
                }
                if (matrixCopy[i][j] != 0)
                    for (int k = 0; k < M; k++) {
                        if (matrix[k][j] == 0) {
                            matrixCopy[i][j] = 0;
                            break;
                        }
                        ;
                    }
            }
        } // ~ O(N*M)


        /** Deep Copy the Array **/
        for (int i = 0; i < M; i++) {
            matrix[i] = Arrays.copyOf(matrixCopy[i], N);
        } // ~ O(N*M)
//        matrix = Arrays.copyOf(matrixCopy);
//        for (int[] a : matrix) {
//            System.out.println(Arrays.toString(a));
//        }


    } // ~ O(N*M)


    public static void main(String[] args) {
        Question1_8 q = new Question1_8();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        q.setZeroes1(matrix);
//        for (int[] a : matrix) {
//            System.out.println(Arrays.toString(a));
//        }
    }


}
