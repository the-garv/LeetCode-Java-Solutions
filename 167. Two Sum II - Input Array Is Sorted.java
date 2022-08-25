class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        while(i<j){
            int currentSum = numbers[i] + numbers[j];
            
            // checking if the sum of ith place and jth place is equal to the target.
            // using two pointer technique only.
            
            if(target == currentSum) return new int[] {i+1, j+1};
            
            //Now if we are have less current sum then target then we need to get bigger
            //number and the array is sorted hence we need to increse ith place because
            //jth is alrady big. now if we have grather then target then we need smaller 
            //value so we do -1 in jth index.
            
            else if(target > currentSum) i++;
            else j--;
        }
        return new int[] {-1, -1};
    }
}
