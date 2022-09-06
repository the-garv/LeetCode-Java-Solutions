class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        //started the matrix from 1,1.
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                //we just need to check that the correct element is equal or not with its immediate perivous digonally.
                if(matrix[i-1][j-1] != matrix[i][j]) return false;
            }
        }
        return true;
    }
}
