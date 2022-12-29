package javacode;

import java.util.Arrays;

public class Array1Dto2D {
    public static int[][] construct2DArray(int[] original, int m, int n) {
        int[][] r = new int[m][n];
        if (original.length != m * n)
            return new int[][] {};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                r[i][j] = original[(i * m) + j];
            }
        }


        return r;
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 5};
        int[][] b = construct2DArray(x, 1, 4);
        for (int i = 0; i < b.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < b[i].length; j++) { //this equals to the column in each row.
                System.out.print(b[i][j] + " ");
            }
        }
    }
}
