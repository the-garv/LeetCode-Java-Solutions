class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        //claculate the sum of array. which will contain left array sum + pivot + rigth array sun.
        for(int i=0;i<nums.length;i++) sum += nums[i];
        //now we just calculate left sum on evert index and comput its right sub array sum and check.
        for(int i=0;i<nums.length;i++){
            if(leftSum == (sum-nums[i]- leftSum))
                return i;
            leftSum += nums[i];
        }
        return -1;
    }
}
