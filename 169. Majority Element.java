// Boyer-Moore Voting Algorithm used
// the logic is that we are not accepting any sub array which is having less cound of element which we are asuming majority element because 
// we know that n/2 have same value of it is not possiable that any sub array is not having Majority Element has more count. observe this
// [2,2,1,1|,1,2,2] there first 2 2 1 1 we will ignore and then again count in 1 2 2
// [2,1|,2,1|,2,1|,2] here 2 is majority element, Now observe this example.
class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, element = nums[0];
        for(int i=1;i<nums.length;i++){
            if(count == 0){
                count = 1;
                element = nums[i];
                continue;
            }
            if(nums[i] == element) count++;
            else count--;
        }
        return element;
    }
}
