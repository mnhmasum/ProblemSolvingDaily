package javacode;

class MaximumCountPositiveNegative2529 {
    public static int maximumCount(int[] nums) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                l++;
            }

            if (nums[i] > 0) {
                r++;
            }
        }

        if (r > l) {
            return r;
        } else {
            return l;
        }

    }

    public static void main(String[] args) {
        int[] input = {-1, -1, -2, 3, 8};
        int result = maximumCount(input);
        System.out.println(result);
    }

}