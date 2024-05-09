package javacode;

public class PalindromeNumber9 {
    public static void main(String[] args) {
        System.out.println("sdfsfd");
        int x = 1241;
        int div = 1;

        while (x >= div * 10) {
            div = div * 10;
            System.out.println(div);
        }

        while (x != 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) {
                System.out.println("False");
            }
            x = (x % div) / 10;
            div = div / 100;
        }

    }
}
