package javacode;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList();
        int maxNumber = nums.length;
        int[] auxArray = new int[maxNumber];
        for(int i = 0; i < nums.length; i++){
            auxArray[nums[i]-1] +=1;
        }

        for(int j=0; j< auxArray.length; j++) {
            if(auxArray[j] == 0) {
                result.add(j+1);
            }
        }

        return result;
    }
}
