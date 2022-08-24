class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lstOfLst = new ArrayList<List<Integer>>();
        for(int i=0;i<numRows;i++){
            List<Integer> lst = new ArrayList<Integer>();
            //first value for every row will be always 1.
            int ncr = 1;
            for(int j=0;j<=i;j++){
                lst.add(ncr);
                // here we are calculating new the value for next collumn. like ncr = n!/r!(n-r)! when we expand it it will be
                // (n)*(n-1)....r!/r!(n-r)! which we can write like n*(n-1)*(n-2).....(n-r)/1*2*3....r
                // now we can also write like this n*((n-1)/1)*((n-2)/2).....((n-r)/r)
                //here n=i and r=j
                ncr = ncr*(i-j)/(j+1);
            }
            lstOfLst.add(lst);
        }
        return lstOfLst;
    }
}

//for complete understanding please checkout this link https://www.geeksforgeeks.org/pascal-triangle/
