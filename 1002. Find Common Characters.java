class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<String>();
        int[] firstElementDetails = getCharectorDetails(words[0]);
        int[] secoundElementDetails = null;
        //create hasted array of character and then update first array with min value from ith and ith+1 array value.
        for(int i=1;i<words.length;i++){
            secoundElementDetails = getCharectorDetails(words[i]);
            for(int j=1;j<27;j++)   firstElementDetails[j] = Math.min(firstElementDetails[j], secoundElementDetails[j]);
        }
        
        for(int i=1;i<27;i++){
            while(firstElementDetails[i]-- > 0) result.add("" + (char)(96+i));
        }
        return result;
    }
    
    //creating a hasted array where each index represent the charector and value whill be the count;
    private int[] getCharectorDetails(String word){
        int[] elementDetails = new int[27];
        for(int i=0;i<word.length();i++){
            elementDetails[word.charAt(i) - 96]++;
        }
        return elementDetails;
    }
}
