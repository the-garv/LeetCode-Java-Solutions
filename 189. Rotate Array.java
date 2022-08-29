class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%nums.length;
        if(nums.length == k) return;
        //reverse the array into 2 partation separately and convert hole array reverse.
        // [1,2,3,4,5,6,7] => [4,3,2,1, | 7,6,5] => [5,6,7,1,2,3,4].
        rotatePart(nums, 0, n-k-1);
        rotatePart(nums, n-k, n-1);
        rotatePart(nums, 0, n-1);
    }
    
    private void rotatePart(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
