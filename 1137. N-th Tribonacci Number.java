class Solution {
    public int tribonacci(int n) {
        int dp[] = {0, 1, 1};
        for (int i = 3; i <= n; ++i)
            dp[i % 3] = dp[0] + dp[1] + dp[2];
        return dp[n % 3];
    }
    
    private int usingRecursion(int n){
        if(n==0)    return 0;
        if(n == 1 || n == 2)  return 1;
        
        return usingRecursion(n-1) + usingRecursion(n-2) + usingRecursion(n-3);
    }
    
    private int usingTopDown(int n, int[] dp){
        if(n==0){
            return 0;
        }
        
        if(dp[n] != 0) return dp[n];
        
        if(n == 1 || n == 2){
            dp[n] = 1;
            return dp[n];
        }
        
        dp[n] = usingTopDown(n-1, dp) + usingTopDown(n-2, dp) + usingTopDown(n-3, dp);
        return dp[n];
    }
    
    private int usingBottomUp(int n, int[] dp){
        if(n <=1) return n;
        if(n == 2 ) return 1;
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];   
    }
    
    private int usingBottomUpWithoutSpace(int n, int[] dp){
        if(n <=1) return n;
        if(n == 2 ) return 1;
        
        int p0 = 0;
        int p1 = 1;
        int p2 = 1;
        
        for(int i=3;i<=n;i++){
            int pCurrent = p0 + p1+ p2;
            p0 = p1;
            p1 = p2;
            p2 = pCurrent;
        }
        return p2;  
    }
    
}
