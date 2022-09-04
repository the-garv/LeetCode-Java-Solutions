class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int kThsum = 0;
        //calculate the first kth element window sum.
        for(int i=0;i<k;i++){
            kThsum+=nums[i];
        }
        int maxKthSum = kThsum;
        //for next kth element window we just need to subtract the current index - k and add current element value.
        for(int i = k;i<nums.length;i++){
            kThsum = kThsum - nums[i-k] + nums[i];
             if(kThsum > maxKthSum)  maxKthSum = kThsum;
        }
        
        return (double)maxKthSum/k;
    }
}
