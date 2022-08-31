class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        return approachOne(nums);
    }
    
    public List<Integer> approachOne(int[] nums){
        List<Integer> lst = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int element = nums[i];
            //checking the element is prsent is no correct place or not of not then will correct one by one
            //once we found that element at correct place we stop and start again for another index.
            while(element != nums[element-1]){
                int nextElement = nums[element-1];
                nums[element-1] = element;
                element = nextElement;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i+1 != nums[i])  lst.add(i+1);
        }
        return lst;
    }
    
    public List<Integer> approachTwo(int[] nums){
        List<Integer> lst = new ArrayList<Integer>();
        //in this approch we just need to multiply correct index value for each ith element with -1. with this we can 
        //check next time like for this index we have vale. those index who is having postive value are the missing one.
        for(int i=0;i<nums.length;i++){
            int correctIndex = Math.abs(nums[i])-1;
            if(nums[correctIndex] > 0)  nums[correctIndex] = nums[correctIndex]*-1;
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0) lst.add(i+1);
        }
        System.out.print(Arrays.toString(nums));
        return lst;
        
    }
}
