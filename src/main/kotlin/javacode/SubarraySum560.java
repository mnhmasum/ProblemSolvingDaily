package javacode;

import java.util.Arrays;

public class SubarraySum560 {
    public static boolean isPresentInPrefixSumArray(int[] prefixSumArray, int value, int index) {
        for (int i1 = 0; i1 < index; i1++) {
            if (value == prefixSumArray[i1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(Arrays.toString(nums));
        int k = 3;
        int sumForTarget = 0;
        int subArrayCounter = 0;

        int[] prefixSumArray = new int[nums.length];
        prefixSumArray[0] = nums[0];

        for (int i = 1; i < prefixSumArray.length; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + nums[i];
        }

        System.out.println(Arrays.toString(prefixSumArray));

        for (int i = 0; i < nums.length; i++) {
            sumForTarget = sumForTarget + nums[i];
            if (sumForTarget == k) {
                subArrayCounter++;
            }
            int value = sumForTarget - k;
            if (isPresentInPrefixSumArray(prefixSumArray, value, i)) {
                subArrayCounter++;
            }
        }

        System.out.println(subArrayCounter);
    }
}
