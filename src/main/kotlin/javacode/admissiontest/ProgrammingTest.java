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

        if (leftSum == rightSum) return idx;
        else return -1;
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
                rightSum += a[j];
            }
        }

        if (leftSum == rightSum) {
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


    static int nextPerfectSquare(int num) {
        if (num == 0 || num < 0) return 0;
        float p = (float) Math.sqrt(num);
        int x = (int) p;

        return (x + 1) * (x + 1);
    }

    static int madhav(int[] a) {
        int lastSum = a[0];
        int lastIndex = 1;
        int limit = 2;

        while (lastIndex < a.length) {
            int newSum = 0;

            for (int i = 0; i < limit; i++) {
                if (lastIndex > a.length - 1) return 0;
                newSum += a[lastIndex];
                lastIndex++;
            }

            if (lastSum == newSum) {
                lastSum = newSum;
            } else {
                return 0;
            }

            limit++;

        }

        return 1;

    }

    static int isGuthrieSequence(int[] a) {
        int n = a[0];
        int counter = 1;
        int[] arr = new int[n];
        arr[0] = n;

        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
            arr[counter++] = n;
        }

        if (counter != a.length) return 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != arr[i]) {
                return 0;
            }
        }

        return 1;
    }

    static int repsEqual(int[] a, int n) {
        int multiple = 1;
        int sum = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            sum += a[i] * multiple;
            multiple = multiple * 10;
        }

        System.out.println(sum);

        if (n == sum) {
            return 1;
        } else {
            return 0;
        }
    }

    static int center15(int[] a) {
        int i = 0;
        int j = 0;
        int sum = 0;

        if (a.length % 2 == 0) {
            j = a.length / 2;
            i = a.length / 2 - 1;
            sum = a[i] + a[j];
        } else {
            j = a.length / 2;
            i = a.length / 2;
            sum = a[j];
        }

        while (i > 0 && j < a.length) {
            if (sum == 15 && i == a.length - 1 - j) {
                return 1;
            } else {
                i--;
                j++;
                sum = sum + a[i] + a[j];
            }
        }

        if (sum == 15 && i == a.length - 1 - j) {
            return 1;
        }

        return 0;

    }

    static int isDivisible(int[] a, int divisor) {
        if (a.length == 0) return 1;

        for (int i : a) {
            if (i % divisor != 0) {
                return 0;
            }
        }

        return 1;
    }

    static int henry(int i, int j) {
        if (i > j) {
            int small = j;
            j = i;
            i = small;
        }

        int num = 1;
        int counter = 0;

        int first = 0;
        int second = 0;

        while (counter != j) {
            int sum = 0;

            for (int k = 1; k < num; k++) {
                if (num % k == 0) {
                    sum += k;
                }
            }

            if (sum == num) {
                counter++;
            }

            if (counter == i && first == 0) {
                first = num;
            }

            if (counter == j && second == 0) {
                second = num;
            }

            num++;

        }

        return first + second;
    }

    public static int isNunique(int[] a, int n) {
        if (a == null || a.length < 2) return 0;
        int count = 0;
        for (int i = 0; i < a.length - 1; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[i] + a[j] == n) {
                    count++;
                    if (count == 2) return 0;
                }
        if (count == 0) return 0;
        return 1;
    }

    static int isSequence(int[] a) {
        if (a.length == 0) return 0;
        int num = a[0];
        int counter = 0;

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1] || a[i] < 0) {
                return 0;
            }
        }

        int i = 0;

        while (i < a.length) {
            if (a[i] == num) {
                i++;
                counter++;

                if (counter >= num) return 0;

            } else {
                num = a[i];
                counter = 1;
                i++;
            }
        }

        return 1;
    }

    static int isMinMaxDisjoint(int[] a) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max_index = -1;
        int min_index = -1;

        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
                max_index = i;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
                min_index = i;
            }
        }

        int max_counter = 0;
        for (int i = 0; i < a.length; i++) {
            if (max == a[i]) {
                max_counter++;
            }
        }

        int min_counter = 0;
        for (int i = 0; i < a.length; i++) {
            if (min == a[i]) {
                min_counter++;
            }
        }

        if (max_index + 1 == min_index || max_index - 1 == min_index) {
            return 0;
        }

        if (max != min && max_counter == 1 && min_counter == 1) {
            return 1;
        }

        return 0;
    }

    static int smallest(int n) {
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            int counter = 0;
            for (int j = 1; j <= n; j++) {
                int num = i * j;

                while (num != 0) {
                    int digit = num % 10;
                    num = num / 10;

                    if (digit == 2) {
                        counter++;
                        break;
                    }
                }

                if (counter == n) {
                    return i;
                }
            }
        }

        return 0;

    }

    static int cluster(int[] a) {
        int num = a[0];
        int numberOfCluseter = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != num) {
                num = a[i];
                numberOfCluseter++;
            }
        }

        int[] clusterArray = new int[numberOfCluseter];
        num = a[0];
        int cnt = 0;
        clusterArray[cnt++] = num;

        for (int i = 1; i < a.length; i++) {
            if (a[i] != num) {
                num = a[i];
                clusterArray[cnt++] = num;
            }
        }

        System.out.println(Arrays.toString(clusterArray));

        return numberOfCluseter;
    }

    static int smartArray(int num) {
        int sum = 1;
        int i = 0;
        while (true) {
            sum = sum + i;
            System.out.println(sum);
            if (sum == num) {
                return 1;
            }
            if (sum > num) {
                return 0;
            }
            i++;
        }
    }

    static int isFactorEqual(int a, int b) {
        int countA = 0;
        int countB = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                countA = countA + 1;
            }
        }

        for (int i = 1; i <= b; i++) {
            if (a % i == 0) {
                countB = countB + 1;
            }
        }

        if (countA == countB) {
            return 1;
        } else {
            return 0;
        }

    }

    static int isFabonacci(int num) {
        int i = 1;
        int j = 1;
        while (true) {
            int temp = j;
            j = j + i;
            i = temp;
            System.out.print(" " + j);
            if (j == num) return 1;
            if (j > num) return 0;
        }
    }

    static int isMeera(int[] a) {
        boolean isFoundPrime = false;
        boolean isFoundZero = false;

        for (int i = 0; i < a.length; i++) {
            if (isPrimeNumber(a[i])) {
                isFoundPrime = true;
            }

            if (a[i] == 0) {
                isFoundZero = true;
            }
        }

        if (isFoundPrime && isFoundZero) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] a1 = {-111, 115, 118, 117, 115};
        int[] a2 = {2, 3, 1, -6, 8, -3, -1, 2};
        int[] a3 = {1, 5, 3, 1, 1, 1, 1, 1, 1};
        int[] a4 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, -2, -1};
        int[] a5 = {8, 4, 2, 1};
        int[] a6 = {3, 2, 0, 5, 3};
        int[] a7 = {1, 1, 15 - 1, -1};
        int[] a8 = {1, 1, 8, 3, 1, 1};

        //System.out.println(equivalentArrays(a1, a2));
        //System.out.println(hasSingleMaximum(a2));
        //System.out.println(is123Array(a1));
        //System.out.println(doIntegerBasedRounding(a2, 5));
        //System.out.println(isCubePowerful(-87));
        //System.out.println(decodeArray(a1));
        //System.out.println(countPrimeNumber(-10, 6));
        //System.out.println(nextPerfect(6));
        //System.out.println(nUpCount(a2, 5));
        //System.out.println(f(a3));
        //System.out.println(f1(-5));
        //System.out.println(madhav(a4));
        //System.out.println(isGuthrieSequence(a5));
        //System.out.println(repsEqual(new int[]{3, 2, 0, 5, 3}, 32053));
        //System.out.println(center15(a8));
        //System.out.println(isDivisible(new int[]{4}, 2));
        //System.out.println(henry(2, 3));
        //System.out.println(isSequence(new int[]{2}));
        //System.out.println(isMinMaxDisjoint(new int[]{1, 2}));
        //System.out.println(smallest(7));
        //System.out.println(fx(4));
        //System.out.println(cluster(new int[]{8, 8, 6, 6, -2, -2, -2}));
        //System.out.println(smartArray(22));
        //System.out.println(isFactorEqual(10, 9));
        //System.out.println(" = " + isFabonacci(6765));


        System.out.println(isMeera(new int[]{7, 6, 10, 0}));
    }
}
