class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> listOfGroupIndexDetails = new ArrayList<List<Integer>>();
        int i=0, n = s.length();
        //just need to track starting point of when the new group start and end we be the currect index. for starting and ending we can get the length as well.
        for(int j=0;i<n;j++){
            if(j==n-1 || s.charAt(j) != s.charAt(j+1)){
                if(j-i+1>=3)  listOfGroupIndexDetails.add(new ArrayList<Integer>(Arrays.asList(i,j)));
                i = j+1;
            }
        }
        return listOfGroupIndexDetails;
    }
}
