import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Hashtable<Integer, Integer> hs = new Hashtable<Integer, Integer>();
        for(int i=0;i<nums.length;i++){
            if(hs.containsKey(nums[i]))    return true;
            hs.put(nums[i], 0);
        }
        return false;
    }
}
