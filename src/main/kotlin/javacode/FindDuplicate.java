package javacode;

import java.util.Hashtable;
import java.util.Set;

public class FindDuplicate {

    public static int findDuplicate(int[] nums) {
        Hashtable<Integer, Integer> map = new Hashtable<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        Set<Integer> keys = map.keySet();
        for(int key: keys){
            System.out.println("Value of "+key+" is: "+ map.get(key));
            if(map.get(key) > 1){
                return key;
            }
        }

        return 0;
    }
    
    public static void main(String[] args) {
        int[] arrayInt = {1,1,2,1,3};
        int duplicate = findDuplicate(arrayInt);
        System.out.println(duplicate);
    }
}
