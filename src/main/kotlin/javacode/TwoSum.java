package javacode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int toBeFound = target - nums[i];
            if(resultMap.containsKey(toBeFound)){
                int[] arr = new int[2];
                arr[0] = resultMap.get(toBeFound);
                arr[1] = i;
                return arr;
            } else {
                resultMap.put(nums[i], i);
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] arrayInt = {1,7,2,4,9};
        int[] duplicate = twoSum(arrayInt, 9);
        System.out.println(Arrays.toString(duplicate));
    }
}
