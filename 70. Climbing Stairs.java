class Solution {
    public int climbStairs(int n) {
        //return climbWithLoop(n, new int[n+1]);
        return climbWithoutExtraSpace(n);
    }
    
    //(Bottom up apporach)recursion with memorisation where we store our previous calculated results into array and if we again need to complut that same input then we will send pre calculated output.
    //the logic is suppose at any position we have only two options. like if we are on two then we have 2 options (1,1 and 2 ). now if you want for 4 then first we break down it like (4-1) + (4-2) => 3 + 2 so for we have calculated and for three only we need to call.
    private int climb(int n, int[] dp){
        if(n==0) return 1;
        if(n <0) return 0;
        if(dp[n] != 0) return dp[n];
        dp[n] = climb(n-1, dp) + climb(n-2, dp);
        return dp[n];
    }
    
    //Top bottom uproach. if you clearlly see here the current result is depends on n-1 and n-2 so we can start from 0 and then we can reach to n.
    private int climbWithLoop(int n, int[] dp){
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    
    //now if you clear understand the above code then we only need last two calculated results so we can same then into two variable and update accordingly or evey iteration.
    private int climbWithoutExtraSpace(int n){
        int sp1 = 1;
        int sp2 = 1;
        for(int i=2;i<=n;i++){
            int current = sp1 + sp2;
            sp2 = sp1;
            sp1 = current;
        }
        return sp1;
    }
}
