class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lst = new ArrayList<Integer>();
        //first value for every row will be always 1.
        long ncr = 1;
        for(int j=0;j<=rowIndex;j++){
            lst.add((int)ncr);
            // here we are calculating new the value for next collumn. like ncr = n!/r!(n-r)! when we expand it it will be
            // (n)*(n-1)....r!/r!(n-r)! which we can write like n*(n-1)*(n-2).....(n-r)/1*2*3....r
            // now we can also write like this n*((n-1)/1)*((n-2)/2).....((n-r)/r)
            //here n=i and r=j
            ncr = ncr*(rowIndex-j)/(j+1);
        }
        
        return lst;
    }
}

//for complete understanding please checkout this link https://www.geeksforgeeks.org/pascal-triangle/
