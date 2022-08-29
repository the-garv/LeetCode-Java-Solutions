class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for(int i=0;i<n;i++) sum += nums[i];
        we have n natural numbers in array from 0 to n. now if we want the of 0 to n then we can use the fourmal of first n natural number sum.
        return (n*(n+1)/2) - sum;
    }
}
