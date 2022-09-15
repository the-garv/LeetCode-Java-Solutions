class Solution {
    public int jump(int[] nums) {
        //return usingRecursion(nums,0);
        //return usingTopDown(nums, 0, new Integer[nums.length]);
        return usingBottomUp(nums);
    }
    
    //hear we have choise that we can go from the ith element to ith + ith elememnt value. so we go first at max and we reached with this choise then return  previous returned valaue + 1.
    private int usingRecursion(int[] nums, int idx){
        if(idx >= nums.length-1)    return 0;
        
        int currentMinCost = Integer.MAX_VALUE-1;
        for(int i=nums[idx];i>0;i--){
            currentMinCost = Math.min(currentMinCost,usingRecursion(nums, idx+i));
        }
        return currentMinCost+1;
    }
    
     private int usingTopDown(int[] nums, int idx, Integer[] dp){
        if(idx >= nums.length-1)    return 0;
        
         if(dp[idx] != null)    return dp[idx];
         
        int currentMinCost = Integer.MAX_VALUE-1;
        for(int i=nums[idx];i>0;i--){
            currentMinCost = Math.min(currentMinCost,usingTopDown(nums, idx+i, dp));
        }
        dp[idx] = currentMinCost+1;
        return dp[idx];
    }
    
    private int usingBottomUp(int[] nums){
        int[] dp = new int[nums.length];
        for(int idx=nums.length-2;idx>=0;idx--){
            int currentMinCost = Integer.MAX_VALUE-1;
            for(int i=nums[idx];i>0;i--)    currentMinCost = Math.min(currentMinCost, idx+i < nums.length ? dp[idx+i] : 0);
            dp[idx] = currentMinCost+1;
        }
        return dp[0];
    }
}
