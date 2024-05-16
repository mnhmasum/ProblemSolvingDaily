package javacode;

class BinarySearch704 {
    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target) return mid;

            if (target > nums[mid]) {
                l = mid + 1;
            }

            if (target < nums[mid]) {
                r = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        int result = search(input, 3);
        System.out.println(result);
    }

}