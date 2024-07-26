package javacode.admissiontest;

public class MiuSample6 {
    static char[] a3(char[] a, int start, int len) {
        if (start + len > a.length) return null;
        if (start < 0 || len < 0) return null;
        if (len == 0) return new char[]{};

        int size = start + len;
        char[] output = new char[len];
        int k = 0;

        for (int i = start; i < size; i++) {
            output[k++] = a[i];
        }

        return output;
    }

    static int a4(int n) {
        int reverse = 0;
        while (n > 0) {
            int digit = n % 10;
            reverse = (reverse * 10) + digit;
            n = n / 10;
        }

        return reverse;
    }

    static int[] a5(int[] first, int[] second) {
        if (first == null || second == null) return null;
        if (first.length == 0 || second.length == 0) return new int[0];
        int min = first.length < second.length ? first.length : second.length;
        int[] a, b;
        if (min == first.length) {
            a = first;
            b = second;
        } else {
            a = second;
            b = first;
        }
        int[] c = new int[min];
        int k = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b.length; j++)
                if (a[i] == b[j]) {
                    c[k] = a[i];
                    k++;
                }
        int[] retArray = new int[k];
        for (int t = 0; t < retArray.length; t++)
            retArray[t] = c[t];
        return retArray;
    }

    static int a6(int[] a) {
        for (int i = 1; i < a.length - 2; i++) {
            System.out.println(a[i]);
        }
        return 0;
    }

    public static int findEquilibriumIndex(int[] numbers) {
        if (numbers.length < 3) {
            return -1;
        }

        int left = 0;
        int right = numbers.length - 1;
        int leftSum = numbers[left];
        int rightSum = numbers[right];

        while (left < right - 1) {
            if (leftSum < rightSum) {
                left++;
                leftSum += numbers[left];
            } else {
                right--;
                rightSum += numbers[right];
            }
        }

        return leftSum == rightSum ? left + 1 : -1;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(a3(new char[]{'a', 'b', 'c'}, 0, 4)));
        //System.out.println(Arrays.toString(a3(new char[]{}, 0, 1)));
        //System.out.println(a4(1234));
        System.out.println("" + findEquilibriumIndex(new int[] {1, 2, 3}));
        System.out.println("" + findEquilibriumIndex(new int[] {3, 4, 5, 10}));
        System.out.println("" + findEquilibriumIndex(new int[] {1, 2, 10, 3, 4}));
    }
}
