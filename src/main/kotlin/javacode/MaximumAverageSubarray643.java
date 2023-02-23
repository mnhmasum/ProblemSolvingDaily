package javacode;

public class MaximumAverageSubarray643 {
    public static void main(String[] args) {
        int[] arr = {-1};
        int target = 1;
        float sumForTarget = 0;
        int start = 0;
        int counter = 0;
        double maxAvg = (double) Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sumForTarget = sumForTarget + (float) arr[i];
            counter += 1;

            if (counter == target) {
                counter = counter - 1;
                maxAvg = Math.max(maxAvg, sumForTarget / target);
                float val = arr[i - counter];
                sumForTarget = sumForTarget - val;
            }
        }



        if (maxAvg == Float.MIN_VALUE) {
            System.out.println("0");
        } else {
            System.out.println("Result: " + maxAvg);
        }

    }
}
