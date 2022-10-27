package javacode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int toBeFound = target - nums[i];
            if(resultMap.containsKey(toBeFound)){
                return new int[]{resultMap.get(toBeFound), i};
            } else {
                resultMap.put(nums[i], i);
            }
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] arrayInt = {1,7,6,4,2};
        int[] duplicate = twoSum(arrayInt, 9);
        System.out.println(Arrays.toString(duplicate));
    }
}
