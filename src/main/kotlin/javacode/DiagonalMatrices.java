package javacode;

public class DiagonalMatrices {
    public static void main(String[] args) {
        int[][] x = {{1,2,3},{2,3,4},{2,3,4}};

        int total = 0;
        for (int i = 0; i < 3; i++) {
            total += x[i][i];
            total += x[i][2-i];
        }

        int centerPosition = x.length/2;
        total = total - x[centerPosition][centerPosition];
        System.out.println(total);
        
    }
}