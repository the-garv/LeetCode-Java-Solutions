class Solution {
    public boolean canJump(int[] nums) {
        //we are starting our loop with first element value as limit and every time we check if we have bigger value then remaning value then we update the loop
        //check at last and in loop if we reached at last index then return true.
        int jump = 0, cIdx = 0;
        jump = nums[0];
        for(int i=0;i < jump; i++){
            cIdx++;
            if(cIdx >= nums.length-1){
                return true;
            }
            else if((nums[cIdx] > 0) && (jump - i) <= nums[cIdx]){
                jump = nums[cIdx];
                i = -1;
            }
        }
        return cIdx >= nums.length-1 ? true : false;
        //if(nums.length <=1) return true;
        //return usingRecursion(nums,0);
        //return usingTopDown(nums,0, new Boolean[nums.length+1]);
        //return usingBottomUp(nums);
    }
    
    //hear we have choise that we can go from the ith element to ith + ith elememnt value. so we go first at max and we reached with this choise then return true else check for ith + ith element value -1 and so on.
    private boolean usingRecursion(int[] nums, int idx){
        if(idx >= nums.length-1)  return true;
        
        for(int i=nums[idx];i>0;i--){
            if(usingRecursion(nums, idx+i)){
                return true;
            }
        }
        return false;
    }
    
    private boolean usingTopDown(int[] nums, int idx, Boolean[] dp){
        if(idx >= nums.length-1)  return true;
        if(dp[idx] != null) return dp[idx];
        for(int i=nums[idx];i>0;i--){
            if(usingTopDown(nums, idx+i, dp)){
                dp[idx] = true;
                return true;
            }
        }
        dp[idx] = false;
        return dp[idx];
    }
    
    private boolean usingBottomUp(int[] nums){
        boolean[] dp = new boolean[nums.length+1];
        for(int idx = nums.length-2;idx>=0;idx--){
            for(int i=nums[idx];i>0;i--)    {
                if(idx+i >= nums.length-1 || dp[idx+i])  dp[idx] = true;
            }
        }
        return dp[0];
    }
}
