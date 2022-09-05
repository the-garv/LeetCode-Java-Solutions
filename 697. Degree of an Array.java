import java.util.Hashtable;
import java.util.Map;
class Solution {
    public int findShortestSubArray(int[] nums) {
        //keeping track of left index, rigth index and the total count of an element;
        Hashtable<Integer, Integer> left = new Hashtable<Integer, Integer>();
        Hashtable<Integer, Integer> right = new Hashtable<Integer, Integer>();
        Hashtable<Integer, Integer> count = new Hashtable<Integer, Integer>();
        //updating value in the hashtables.
        for(int i=0;i<nums.length;i++){
            int value = nums[i];
            //for left we need first occerance of any element.
            if(left.get(value) == null) left.put(value,i);
            right.put(value,i);
            count.put(value, count.getOrDefault(value, 0) +1);
        }
        int ans = nums.length;
        //geting the max digree and then counput the min length for that digree
        int degree = Collections.max(count.values());
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }
}
