class Solution {
    public int rob(int[] nums) {
        //return usingTopDown(nums, 0, new Integer[nums.length]);
        //return usingBottomUp(nums);
        return usingBottomUpWithoutSpace(nums);
    }
    
    // to select one element we have two choise either we select or not select.
    // now if we select the current element then we add that with element th index +2.
    // else we skip the current element and then calculate from next element.
    private int usingRecursion(int[] nums, int idx){
        if(idx >= nums.length)  return 0;
        
        int spOne = usingRecursion(nums, idx+2) + nums[idx];
        int spTwo = usingRecursion(nums, idx+1);
        //returning max from both cases.
        return Math.max(spOne, spTwo);
    }
    
    private int usingTopDown(int[] nums, int idx, Integer[] dp){
        if(idx >= nums.length)  return 0;
        if(dp[idx] != null) return dp[idx];
        int spOne = usingTopDown(nums, idx+2, dp) + nums[idx];
        int spTwo = usingTopDown(nums, idx+1, dp);
        dp[idx] = Math.max(spOne, spTwo);
        return dp[idx];
    }
    
    private int usingBottomUp(int[] nums){
        int[] dp = new int[nums.length+2];
        for(int idx = nums.length-1;idx>=0;idx--){
            int spOne = dp[idx+2] + nums[idx];
            int spTwo = dp[idx+1];
            dp[idx] = Math.max(spOne, spTwo);
        }
        return dp[0];
    }
    
    private int usingBottomUpWithoutSpace(int[] nums){
        int p1 = 0, p2 = 0;
        for(int idx = nums.length-1;idx>=0;idx--){
            int current = Math.max(p2+nums[idx], p1);
            p2 = p1;
            p1 = current;
        }
        return p1;
    }
}
