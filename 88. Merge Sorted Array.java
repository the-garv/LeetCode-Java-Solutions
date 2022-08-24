class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //take two index for each array and assigned last index
        //take k as index from big one array and assign it the size-1 value. 
        int i = m-1, k = nums1.length-1, j = n-1;
        
        //compare values of both array from end and put grather one in end of big array.
        while(i >= 0 && j >= 0){
            if(nums1[i]>nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
        
        while(i >= 0) nums1[k--] = nums1[i--];
        while(j >= 0) nums1[k--] = nums2[j--];
    }
}
