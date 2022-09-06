class Solution {
    int[] dp = null;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        //return  Math.min(calculateCost(cost, cost.length-1), calculateCost(cost, cost.length-2));
        return calculateCost_itration_withoutSpace(cost);
    }
    
    //with top down approach we go with recursion + memorization where we will use one array for save each function frame result. so if other funtion frame will call call with same input so we dont need to calculate again. 
    //when we go from top to botton then only we can utlilized the calculated function frame results.
    private int calculateCost(int[] costs, int idx){
        if(idx < 0) return 0;
        if(idx == 0 || idx == 1) return costs[idx];
        if(dp[idx] != 0) return dp[idx];
        int withOneStair = calculateCost(costs, idx-1);
        int withTwoStair = calculateCost(costs, idx-2);
        dp[idx] = costs[idx] + Math.min(withOneStair, withTwoStair);
        return dp[idx];
    }
    
    
    //if you see the recursion solution we are just comparing last two setps total cost which is minimum we are using that and add currecnt and updateing the array.
    private int calculateCost_itration(int[] costs){
        for(int i=0;i<costs.length;i++){
            if(i<2) dp[i] = costs[i];
            else dp[i] = costs[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return  Math.min(dp[costs.length-1], dp[costs.length-2]);
    }
    
    //now we also not need any array we just need last two setps total cost so that we can store into variable as well.
    private int calculateCost_itration_withoutSpace(int[] costs){
        if(costs.length == 1) return 0;
        if(costs.length == 2) return Math.min(costs[0], costs[1]);
        
        int current=0, first = costs[0], secound = costs[1];
        for(int i=2;i<costs.length;i++){
            current = costs[i] + Math.min(first, secound);
            first = secound;
            secound = current;
        }
        return  Math.min(first, secound);
    }   
}
