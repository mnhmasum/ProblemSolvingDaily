package javacode.admissiontest;

import java.util.*;
import java.util.stream.Collectors;

public class ProgrammingTest {
    //1
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

    //2
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

    //3
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
            sum += i;
        }

        System.out.println("$Result " + map.values());

        if (sum == a.length) {
            return 1;
        }

        return 0;
    }

    //4
    private static int largestPrimeFactor(int number) {
        List<Integer> primeFactorList = new ArrayList<>();
        if (number < 2) return 0;

        while (number % 2 == 0) {
            primeFactorList.add(2);
            number = number / 2;
        }

        for (int i = 3; i <= number; i = i + 2) {
            while (number % i == 0) {
                primeFactorList.add(i);
                number = number / i;
            }

        }

        for (int i = 0; i < primeFactorList.size(); i++) {
            System.out.println(primeFactorList.get(i));

        }

        return primeFactorList.get(primeFactorList.size() - 1);
    }

    //5
    public static boolean doIntegerBasedRounding(int[] arr, int n) {
        if (n <= 0) {
            System.out.println(Arrays.toString(arr));
            return false;
        }

        List<Integer> list = new ArrayList<>();
        for (int number : arr) {
            int lowerBound = (number / n) * n;
            int upperBound = lowerBound + n;

            boolean isEquidistant = Math.abs(number - lowerBound) == Math.abs(number - upperBound);

            if (isEquidistant) {
                list.add(Math.max(upperBound, lowerBound));
            } else {
                if (Math.abs(number - lowerBound) < Math.abs(number - upperBound)) {
                    list.add(lowerBound);
                } else {
                    list.add(upperBound);
                }
            }
        }

        String result = list.stream().map(String::valueOf).collect(Collectors.joining(" "));

        // Print the result
        System.out.println(result);
        return false;
    }

    //6
    public static int isCubePowerful(int num) {
        if (num <= 0) {
            return 0;
        }
        int originalNum = num;
        int sum = 0;

        while (num != 0) {
            int digit = num % 10;
            sum += digit * digit * digit;
            num = num / 10;
        }

        if (sum == originalNum) {
            return 1;
        }
        return 0;
    }

    //7
    public static int decodeArray(int[] arr) {
        int multiplier = 1;
        int encodeNum = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            encodeNum = Math.abs(arr[i - 1] - arr[i]) * multiplier;
            multiplier = multiplier * 10;
        }

        if (arr[0] < 0) {
            encodeNum = encodeNum * -1;
        }

        return encodeNum;
    }

    //8
    public static int countPrimeNumber(int start, int end) {
        int countPrime = 0;
        for (int i = start; i <= end; i++) {
            if (isPrimeNumber(i)) {
                countPrime += 1;
            }
        }
        return countPrime;
    }

    public static boolean isPrimeNumber(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0) return false;
        int limit = num / 2;
        for (int i = 3; i <= limit; i = i + 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int nextPerfect(int num) {
        if (num < 0) {
            return 0;
        }

        if (num == 0) {
            return 1;
        }

        int squareValue = 1;

        while (num >= squareValue * squareValue) {
            squareValue++;
        }

        return squareValue * squareValue;
    }


    public static int nUpCount(int[] a, int n) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (sum > n) {
                count = count + 1;
            }
        }
        return count;
    }

    static int a6(int[] a) {
        if (a.length < 3) return -1;
        int i = 0;
        int j = a.length - 1;
        int idx = 1;
        int leftSum = a[i];
        int rightSum = a[j];

        for (int k = 1; k < a.length - 2; k++) {
            if (leftSum < rightSum) {
                i++;
                leftSum += a[i];
                idx = i + 1;
            } else {
                j--;
                rightSum += a[j];
                idx = j - 1;
            }
        }

        if (leftSum == rightSum)
            return idx;
        else
            return -1;
    }

    static int q6(int[] a) {
        int leftSum = a[0];
        int rightSum = a[a.length - 1];
        int i = 0;
        int j = a.length - 1;

        for (int k = 1; k < a.length - 2; k++) {
            System.out.println("Result " + a[k]);
            if (leftSum < rightSum) {
                i++;
                leftSum += a[i];

            } else {
                j--;
                rightSum +=a[j];
            }
        }

        if(leftSum == rightSum) {
            return i + 1;
        }

        return -1;

    }

    //Sample 6
    public static int f(int[] A) {
        int n = A.length;

        // Edge case: if array has fewer than two elements, no POE exists
        if (n < 2) {
            return -1;
        }

        // Calculate the total sum of elements in array A
        int total_sum = 0;
        for (int num : A) {
            total_sum += num;
        }

        int left_sum = 0;

        // Iterate through each index idx to find the POE
        for (int idx = 0; idx < n; idx++) {
            int right_sum = total_sum - (left_sum + A[idx]);

            if (left_sum == right_sum) {
                return idx;
            }

            left_sum += A[idx];
        }

        // If no POE is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] a1 = {-111, 115, 118, 117, 115};
        int[] a2 = {2, 3, 1, -6, 8, -3, -1, 2};
        int[] a3 = {1, 5, 3, 1, 1, 1, 1, 1, 1};
        //System.out.println(equivalentArrays(a1, a2));
        //System.out.println(hasSingleMaximum(a2));
        //System.out.println(is123Array(a1));
        //System.out.println(is123Array(a1));
        //System.out.println(doIntegerBasedRounding(a2, 5));
        //System.out.println(isCubePowerful(-87));
        //System.out.println(decodeArray(a1));
        //System.out.println(countPrimeNumber(-10, 6));
        //System.out.println(nextPerfect(6));
        //System.out.println(nextPerfect(36));
        //System.out.println(nextPerfect(0));
        //System.out.println(nextPerfect(-5));
        //System.out.println(nUpCount(a2, 5));
        System.out.println(f(a3));
    }
}
