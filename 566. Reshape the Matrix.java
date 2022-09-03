class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        //if the total number of count of mat array and reshaped array then we can not transform then array hence send mat as it is.
        if((mat.length*mat[0].length) != (r*c))   return mat;
        else {
            int[][] reshapedMat = new int[r][c];
            int row = 0, col = 0;
            //traverse the mat and copying in the new reshaped array with row and column variable we just incrementing column by 1 ater inserting element and
            // checking if col is graterthen total then increnting row by one and update column to 0 because now we have to insert from next row and first column.
            for(int i=0;i<mat.length;i++){
                for(int j=0;j<mat[0].length;j++){
                    reshapedMat[row][col++] = mat[i][j];
                    if(col >= c){
                        col = 0;
                        row++;
                    }
                }
            }
            return reshapedMat;
        }
    }
}
