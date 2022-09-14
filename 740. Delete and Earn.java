class Solution {
    public int deleteAndEarn(int[] nums) {
        // first we will sort the array so that we need to take care only one case like if any ith element we select then we only need to check just after that element we have ith value + 1 is present or not.
        Arrays.sort(nums);
        //return usingTopDown(nums,0, new Integer[nums.length]);
        return usingButtomUp(nums);
    }
    
    // now first we have two choise either we select the current index or not
    // case one if we select the current element then we need to check next element if the is same as current element +1 then we will skip that element and do recursive call with next to next different element.
    // case two if we not select then we just need to do recursive call with next different element.
    private int usingRecursion(int[] nums, int idx){
        if(nums.length == idx)  return 0;
        
        int freq = 1, i = idx+1;
        while(nums.length > i && nums[i] == nums[i-1]){
            i++; freq++;
        }
        int nextIdx = i;
        while(nums.length > nextIdx && nums[nextIdx] == nums[idx]+1)    nextIdx++;
        System.out.println(idx + " " + nextIdx + " " + i + " " + freq);
        
        int sp1 = usingRecursion(nums, nextIdx) + nums[idx]*freq;
        int sp2 = usingRecursion(nums,i);
        return Math.max(sp1, sp2);        
    }
    
    private int usingTopDown(int[] nums, int idx, Integer[] dp){
        if(nums.length == idx)  return 0;
        
        if(dp[idx] != null) return dp[idx];
        
        int freq = 1, i = idx+1;
        while(nums.length > i && nums[i] == nums[i-1]){
            i++; freq++;
        }
        int nextIdx = i;
        while(nums.length > nextIdx && nums[nextIdx] == nums[idx]+1)    nextIdx++;
        System.out.println(idx + " " + nextIdx + " " + i + " " + freq);
        
        int sp1 = usingTopDown(nums, nextIdx, dp) + nums[idx]*freq;
        int sp2 = usingTopDown(nums,i, dp);
        dp[idx] = Math.max(sp1, sp2);
        return dp[idx];
    }
    
    private int usingButtomUp(int[] nums){
        int[] dp = new int[nums.length+1];
        for(int idx = nums.length-1; idx>=0; idx--){
             int freq = 1, i = idx+1;
            while(nums.length > i && nums[i] == nums[i-1]){
            i++; freq++;
            }
            int nextIdx = i;
            while(nums.length > nextIdx && nums[nextIdx] == nums[idx]+1)    nextIdx++;
            
            int sp1 = dp[nextIdx] + nums[idx]*freq;
            int sp2 = dp[i];
            dp[idx] = Math.max(sp1, sp2);
        }
        
        return dp[0];
    }    
}
