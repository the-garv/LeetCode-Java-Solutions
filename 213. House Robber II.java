class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)  return nums[0];
        //return Math.max(usingRecursion(nums, 0, nums.length-2), usingRecursion(nums, 1, nums.length-1));
        //return  Math.max(usingTopDown(nums, 0, nums.length-2, new Integer[nums.length]), usingTopDown(nums, 1, nums.length-1, new Integer[nums.length]));
        //return  Math.max(usingBottomUp(nums, 0, nums.length-2), usingBottomUp(nums, 1, nums.length-1));
        return Math.max(usingBottomUpWithoutSpace(nums, 0, nums.length-2), usingBottomUpWithoutSpace(nums, 1, nums.length-1));
    }
    
    // to select one element we have two choise either we select or not select.
    // now if we select the current element then we add that with element th index +2.
    // else we skip the current element and then calculate from next element.
    private int usingRecursion(int[] nums, int idx, int endIdx){
        if(idx > endIdx)  return 0;
        
        int spOne = usingRecursion(nums, idx+2, endIdx) + nums[idx];
        int spTwo = usingRecursion(nums, idx+1, endIdx);
        //returning max from both cases.
        return Math.max(spOne, spTwo);
    }
    
    private int usingTopDown(int[] nums, int idx, int endIdx, Integer[] dp){
        if(idx > endIdx)  return 0;
        if(dp[idx] != null) return dp[idx];
        int spOne = usingTopDown(nums, idx+2, endIdx, dp) + nums[idx];
        int spTwo = usingTopDown(nums, idx+1, endIdx, dp);
        dp[idx] = Math.max(spOne, spTwo);
        return dp[idx];
    }
    
    private int usingBottomUp(int[] nums, int startIdx, int endIdx){
        int[] dp = new int[nums.length+2];
        for(int idx = endIdx;idx>=startIdx;idx--){
            int spOne = dp[idx+2] + nums[idx];
            int spTwo = dp[idx+1];
            dp[idx] = Math.max(spOne, spTwo);
        }
        return dp[startIdx];
    }
    
    private int usingBottomUpWithoutSpace(int[] nums, int startIdx, int endIdx){
        int p1 = 0, p2 = 0;
        for(int idx = endIdx;idx>=startIdx;idx--){
            int current = Math.max(p2+nums[idx], p1);
            p2 = p1;
            p1 = current;
        }
        return p1;
    }
}
