package javacode;

public class PalindromeNumber9 {
    public static void main(String[] args) {
        System.out.println("sdfsfd");


        int x = 1410110141;
        long div = 1;
        int[] y;

        while (x > 10 * div) {
            div = 10 * div;
            System.out.println(div);
        }

        while (x != 0) {
            long left = x / div;
            long right = x % 10;
            if (left != right) {
                System.out.println("False");
            }
            x =(int) ((x % div) / 10);
            div = div / 100;
        }


    }
}
