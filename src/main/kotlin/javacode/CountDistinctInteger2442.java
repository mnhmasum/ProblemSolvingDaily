package javacode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctInteger2442 {
    static int countDistinctIntegers(int[] nums) {

        int[] tempArr = new int[nums.length + nums.length];

        for (int i = 0; i < nums.length; i++) {
            tempArr[i] = nums[i];
        }


        for (int i = 0; i < nums.length; i++) {
            int num = 0;
            while (nums[i] != 0) {
                int digit = nums[i] % 10;
                num = num * 10 + digit;
                tempArr[nums.length + i] = num;
                nums[i] /= 10;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tempArr.length; i++) {
            map.put(tempArr[i], i);
        }

        System.out.println(Arrays.toString(tempArr));
        System.out.println(map.size());


        return map.size();
    }

    public static void main(String[] args) {
        int[] arr = {1, 13, 10, 12, 31};
        countDistinctIntegers(arr);
    }
}
