class Solution {
    
    private int max = Integer.MIN_VALUE;
    
    public int maxSubArray(int[] nums) {
        int resultSum=Integer.MIN_VALUE, currentSum = 0;
        for(int i=0;i<nums.length;i++){
            currentSum =currentSum + nums[i];
            if(currentSum > resultSum)  resultSum = currentSum;
            if(currentSum < 0)  currentSum = 0;
        }
        return resultSum;
    }
    
    public int usingRecursion(int[] nums, int idx){
        if(idx == 0){   
            max = Math.max(nums[0], max);
            return nums[0];
            
        }
        
        int sp1 = Math.max(usingRecursion(nums, idx-1)+nums[idx], nums[idx]);
        max = Math.max(sp1, max);
        return sp1;
        
    }
    private int usingBottomUp(int[] nums){
        int max = nums[0], cMax = nums[0];
        for(int i=1;i<nums.length;i++){
            cMax = Math.max(cMax+nums[i], nums[i]);
            max = Math.max(max, cMax);
        }
        return max;
    }
    
}
