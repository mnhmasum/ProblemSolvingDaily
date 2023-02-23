package javacode;

public class MinimumSubarraySum209 {

    public static int minSubArrayLen(int[] arr, int target) {
        int currentSum = 0;
        int start = 0;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            while (currentSum >= target) {
                int soFarIndexCount = i - start + 1;
                minCount = Math.min(minCount, soFarIndexCount);
                currentSum = currentSum - arr[start];
                start = start + 1;
            }
        }

        if (minCount == Integer.MAX_VALUE) {
            return 0;
        }

        return minCount;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1, 2, 3};
        int x = minSubArrayLen(arr, 4);
        System.out.println(x);

        int target = 5;
        int sumForTarget = 0;
        int start = 0;
        int minimumLength = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sumForTarget = sumForTarget + arr[i];
            while (sumForTarget >= target) {
                minimumLength = Math.min(minimumLength, i - start + 1);
                sumForTarget = sumForTarget - arr[start];
                start = start + 1;
            }
        }

        if (minimumLength == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(minimumLength);
        }


    }
}
