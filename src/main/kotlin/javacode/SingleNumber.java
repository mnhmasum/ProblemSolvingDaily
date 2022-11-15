package javacode;

import java.util.HashMap;
import java.util.Set;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0; i< nums.length; i++){
            if(map.containsKey(nums[i])) {
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i], 1);
            }
        }

        Set<Integer> keys = map.keySet();
        for(int key: keys){
            System.out.println("Value of "+key+" is: "+ map.get(key));
            if(map.get(key) == 1){
                return key;
            }
        }

        return 0;
    }
}
