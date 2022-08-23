import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> ht = new Hashtable<>();
        for(int i=0;i<nums.length;i++)
        {
            int otherValue = target - nums[i];
            if(ht.containsKey(otherValue)){
                return new int[] { ht.get(otherValue), i};
            }
            ht.put(nums[i], i);
        }
        
        return new int[2];
    }
}
