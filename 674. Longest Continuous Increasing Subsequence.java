class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxCount = 1, currentCount = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] < nums[i]) currentCount++;
            else{ 
                if(maxCount < currentCount) maxCount = currentCount;
                currentCount = 1;
            }
        }
        if(maxCount < currentCount) maxCount = currentCount;
        return maxCount;
    }
}
