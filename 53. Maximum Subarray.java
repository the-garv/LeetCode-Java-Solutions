class Solution {
    public int maxSubArray(int[] nums) {
        int resultSum=Integer.MIN_VALUE, currentSum = 0;
        for(int i=0;i<nums.length;i++){
            currentSum =currentSum + nums[i];
            if(currentSum > resultSum){
                resultSum = currentSum;
            }
            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return resultSum;
    }
}
