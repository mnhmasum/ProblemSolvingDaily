package javacode;

public class ValidPalindrome125 {
    public static boolean isPalindrome(String s) {

        StringBuilder stringBuilder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                stringBuilder.append(Character.toLowerCase(c));
            }
        }

        String mainString = stringBuilder.toString();

        if (mainString.length() == 0) return true;

        char[] chars = mainString.toCharArray();

        int left_ptr = 0;
        int right_ptr = chars.length - 1;

        for (int i = 0; i <= Math.round(chars.length / 2); i++) {

            if (chars[left_ptr] != chars[right_ptr]) {
                return false;
            }

            left_ptr++;
            right_ptr--;

        }

        return true;
    }

    public static void main(String[] args) {
        String s = "xyz";

        System.out.println();

    }
}
