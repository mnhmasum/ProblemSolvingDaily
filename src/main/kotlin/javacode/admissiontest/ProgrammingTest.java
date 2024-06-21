package javacode.admissiontest;

import java.util.*;

public class ProgrammingTest {
    public static int equivalentArrays(int[] a1, int[] a2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a1) {
            map.put(i, i);
        }

        for (int i : a2) {
            if (!map.containsKey(i)) {
                return 0;
            }
        }

        return 1;

    }

    public static int hasSingleMaximum(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        if (arr.length == 1) {
            return 1;
        }

        Arrays.sort(arr);

        if (arr[arr.length - 1] == arr[arr.length - 2]) return 0;

        return 1;
    }

    public static int is123Array(int[] a) {
        int counter2Divisible = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {

            if (a[i] % 2 == 0) {
                map.put(2, map.getOrDefault(2, 0) + 1);
            }

            if (a[i] % 3 == 0) {
                map.put(3, map.getOrDefault(3, 0) + 1);
            }

            if (a[i] % 5 == 0) {
                map.put(5, map.getOrDefault(5, 0) + 1);
            }

            if (a[i] % 5 != 0 && a[i] % 3 != 0 && a[i] % 2 != 0) {
                map.put(0, map.getOrDefault(0, 0) + 1);
            }

        }

        Collection<Integer> iterator = map.values();

        int sum = 0;
        for (int i : iterator) {
            sum +=i;
        }

        System.out.println("$Result " + map.values());

        if (sum == a.length) {
            return 1;
        }

        return 0;
    }

    private static int largestPrimeFactor(int number) {
        List<Integer> primeFactorList = new ArrayList<>();
        if(number < 2) return 0;

        while(number % 2 == 0) {
            primeFactorList.add(2);
            number = number / 2;
        }

        for (int i = 3; i <= number; i = i + 2) {
            while(number % i == 0) {
                primeFactorList.add(i);
                number = number / i;
            }

        }

        for (int i = 0; i < primeFactorList.size(); i++) {
            System.out.println(primeFactorList.get(i));

        }


        return primeFactorList.get(primeFactorList.size() - 1);

    }

    public static void main(String[] args) {
        int[] a1 = {2, 3, 5, 7, 11};
        int[] a2 = {};
        //System.out.println(equivalentArrays(a1, a2));
        //System.out.println(hasSingleMaximum(a2));
        //System.out.println(is123Array(a1));
        System.out.println(is123Array(a1));
    }
}
