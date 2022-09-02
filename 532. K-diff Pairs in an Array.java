import java.util.*;
class Solution {
    public int findPairs(int[] nums, int k) {
        Hashtable<Integer, Boolean> ht = new Hashtable<Integer, Boolean>();
        int count = 0;
        for(int i=0;i<nums.length;i++){
            //checking if nums[i] already is not contains in hast table that meain this pair is can be satisfy this condition a-b = k. 
            // now a-b = k we can writen it either as a = k+b or b = a-k. so we just need to check k+b or a-k is present in hash table.
            if(!ht.containsKey(nums[i])){
                
                if(ht.containsKey(k+nums[i])) count++;
                if(ht.containsKey(nums[i]-k)) count++;
                ht.put(nums[i], false);
            }
            //this else is responsible for what if k is 0 and then a-a = 0 is also posiable ie 1-1 = 0 where in array we have 2 one so this is also a valid pair.
            else if(k == 0 && !ht.get(nums[i])){
                count++;
                ht.put(nums[i], true);
            }
        }
        return count;
    }
}
