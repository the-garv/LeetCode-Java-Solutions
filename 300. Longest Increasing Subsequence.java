import java.util.*;
class Solution {
    public int lengthOfLIS(int[] nums) {
        //return usingRecursion(nums, 0, -100000);
        //return usingTopDown(nums,0, -1, new int[nums.length][nums.length]);
        //return usingBottomUp(nums);
        ArrayList<Integer> al = new ArrayList<Integer>();
        int pre = nums[0];
        al.add(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i] > al.get(al.size()-1)){
                al.add(nums[i]);
            }
            else{
                int s=0, j = al.size()-1, ans = al.size()-1;
                while(s<=j){
                    int mid = (s+j)/2;
                    if(al.get(mid) >= nums[i]){
                        ans = mid;
                        j = mid-1;
                    }
                    else   s = mid+1; 
                }
                al.set(ans, nums[i]);
                System.out.println(al + " " + s + " " + j);
            }
        }
        System.out.println(al);
        return al.size();
    }
    
    private int usingRecursion(int[] nums, int idx, int pre){
        if(nums.length == idx)  return 0;
        
        int sp1 = 0;
        if(nums[idx] > pre) sp1 = 1+ usingRecursion(nums, idx+1, nums[idx]);
        int sp2 = usingRecursion(nums, idx+1, pre);
        return Math.max(sp1, sp2);
    }
    
    private int usingTopDown(int[] nums, int idx, int preIdx, int[][] dp){
        if(nums.length == idx)  return 0;
        
        if(dp[idx][preIdx+1] != 0) return dp[idx][preIdx+1];
        
        int sp1 = 0;
        if(preIdx == -1 || nums[idx] > nums[preIdx]) sp1 = 1+ usingTopDown(nums, idx+1, idx, dp);
        int sp2 = usingTopDown(nums, idx+1, preIdx, dp);
        dp[idx][preIdx+1] = Math.max(sp1, sp2);
        return dp[idx][preIdx+1];
    }
    
    private int usingBottomUp(int[] nums){
        int[] dp = new int[nums.length+1];
        int max = 0;
        for(int idx = 1;idx< nums.length;idx++){
            for(int preIdx=0;preIdx<=idx;preIdx++){
                if(nums[idx] > nums[preIdx]){
                    dp[idx] = Math.max(1 + dp[preIdx], dp[idx]);
                    max = Math.max(dp[idx], max);
                }
            }
        }
        return max+1;
    }   
}
