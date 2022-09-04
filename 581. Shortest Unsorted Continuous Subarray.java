class Solution {
    public int findUnsortedSubarray(int[] nums) {
        return usingSorting(nums);
    }
    
    private int usingSorting(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
    
    private int withoutExtraSpace(int[] nums){
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        boolean flag = false;
        //getting min value from array only when next value is smaller and previous value is grater from starting.
        for(int i=1;i<nums.length;i++){
            if(nums[i] < nums[i-1]) flag = true;
            if(flag) min = Math.min(min, nums[i]);
        }
        flag = false;
        //getting max value from array only when previous value is gratter then next value from ending.
        getting max
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] > nums[i+1]) flag = true;
            if(flag) max = Math.max(max, nums[i]);
        }
        //now we know that min and max of unsorted array. and with that if we going from starting and we get any elememnt which is grater then min that means from that index the unsorted array will start and same with end like will start from end and check if any element which is smaller then max that means that index will be end of unsorted array.
        int l=0, r = nums.length-1;
        for(;l<nums.length;l++){
            if(nums[l] > min) break;
        }
        for(;r>=0;r--){
            if(nums[r] < max) break;
        }
        
        return r-l < 0 ? 0: r- l + 1;
    } 
    
    
    private int usingStack(int[] nums){
                Stack<Integer> stk = new Stack<Integer>();
        int minIdx = nums.length, maxIdx = 0;
        // We are finding the next smaller element with this we will get the index which is not containing correct value from starting.
        for(int i=0;i<nums.length;i++){
            while(!stk.empty() && nums[stk.peek()] > nums[i])  minIdx = Math.min(minIdx, stk.pop());
            stk.push(i);
        }
        stk.clear();
        //Finding the previous grater element with this we will get the index which is not containing correct value from ending.
        for(int i=nums.length-1;i>=0;i--){
            while(!stk.empty() && nums[stk.peek()] < nums[i])  maxIdx = Math.max(maxIdx, stk.pop());
            stk.push(i);
        }
        return maxIdx != 0 ? maxIdx-minIdx+1 : 0;        
    }
}
