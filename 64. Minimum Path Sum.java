class Solution {
    public int minPathSum(int[][] grid) {
        //return usingRecursion(grid, 0, 0);
        //return usingTopDown(grid, 0,0, new Integer[grid.length][grid[0].length]);
        //return usingBottomUp(grid);
        return usingBottomUpWithoutExtraSpace(grid);
    }
    
    //on each place we have two choise either we go down or right of we go both side and check which is having minimum sum.
    public int usingRecursion(int[][] grid, int row, int col){
        if(row == grid.length)  return  20000;
        if(col == grid[0].length)   return 20000;
        
        if(row == grid.length-1 && col == grid[0].length-1) return grid[row][col];
        
        int sp1 = usingRecursion(grid, row+1, col);
        int sp2 = usingRecursion(grid, row, col+1);
        return Math.min(sp1, sp2) + grid[row][col];
    }
    
    public int usingTopDown(int[][] grid, int row, int col, Integer[][] dp){
        if(row == grid.length)  return  20000;
        if(col == grid[0].length)   return 20000;
        
        if(row == grid.length-1 && col == grid[0].length-1) return grid[row][col];
        
        if(dp[row][col] != null) return dp[row][col];
        
        int sp1 = usingTopDown(grid, row+1, col, dp);
        int sp2 = usingTopDown(grid, row, col+1, dp);
        dp[row][col] = Math.min(sp1, sp2) + grid[row][col];
        return dp[row][col];
    }
    
    public int usingBottomUp(int[][] grid){
        int[][] dp = new int[grid.length+1][grid[0].length+1];
        for(int row = grid.length;row>=0;row--){
            for(int col=grid[0].length;col>=0;col--){
                if(row == grid.length || col == grid[0].length){
                    dp[row][col] = 20000;
                    continue;
                }
                
                if(row == grid.length-1 && col == grid[0].length-1) dp[row][col] = grid[row][col];
                else {
                    int sp1 = dp[row+1][col];
                    int sp2 = dp[row][col+1];
                    dp[row][col] = Math.min(sp1, sp2) + grid[row][col];
                }
            }
        }
        return dp[0][0];
    }
    
    public int usingBottomUpWithoutExtraSpace(int[][] grid){
        int[][] dp = new int[2][grid[0].length+1];
        for(int row = grid.length;row>=0;row--){
            for(int col=grid[0].length;col>=0;col--){
                if(row == grid.length || col == grid[0].length){
                    dp[0][col] = 20000;
                    continue;
                }
                
                if(row == grid.length-1 && col == grid[0].length-1) dp[0][col] = grid[row][col];
                else {
                    int sp1 = dp[1][col];
                    int sp2 = dp[0][col+1];
                    dp[0][col] = Math.min(sp1, sp2) + grid[row][col];
                }
            }
            dp[1] = dp[0];
            dp[0] = new int[grid[0].length+1];
            
        }
        return dp[1][0];
    }
}
