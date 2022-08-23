class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int j = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1] != nums[i])
                nums[++k] = nums[i];
        }
        return k+1;
    }
}
