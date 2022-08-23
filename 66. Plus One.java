class Solution {
    public int[] plusOne(int[] digits) {
        int idx = digits.length-1;
        //Putting 0 from last for continues 9 digits because we will get Carryforword only if we have 9 as value.
        while(idx >=0 && (digits[idx]+1)%10 == 0){
            digits[idx--]=0;
        }
        //if all IDX is -1 that means we have all digits 9 now we have to increase the size of the array by one. so created one array has 0th index as 1 rest of all will be 0
        if(idx ==-1){
            int[] nDigits = new int[digits.length+1];
            nDigits[0] = 1;
            return nDigits;
        }
        digits[idx] = digits[idx]+1;
        return digits; 
    }
}
