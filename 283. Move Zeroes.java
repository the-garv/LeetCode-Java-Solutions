class Solution {
    public void moveZeroes(int[] nums) {
        int k=0;
        //first shifting all non zero values and then placing 0 with hard code. because we not how man zero we need to put.
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0)    nums[k++] = nums[i];
        }
        while(k<nums.length){
            nums[k++] = 0;
        }
    }
}
