package javacode;

import java.util.Arrays;

public class RotateArray {
    public static void rotate2(int[] nums, int k) {
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[(i+k)%nums.length]=nums[i];
        }
        for(int i=0; i<ans.length; i++){
            nums[i]=ans[i];
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for(int i = k; i < nums.length;i++){
            result[i] = nums[i-k];
        }

        if(nums.length == 1) {
            return;
        }

        if(nums.length == 2 && k > nums.length) {
            int x = nums[1];
            nums[1] = nums[0];
            nums[0] = x;
            return;
        }

        for(int i = 0; i < k;i++){

            result[i] = nums[nums.length - k + i];


        }


        for(int i = 0; i < result.length;i++){
            nums[i] = result[i];
        }

        System.out.println(Arrays.toString(nums));

    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        rotate2(nums, 4);

    }
}
