import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(ht.containsKey(nums[i]))    return true;
            ht.put(nums[i], 0);
        }
        return false;
    }
}
