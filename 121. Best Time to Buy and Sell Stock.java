class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minBuyValue = prices[0];
        for(int i=1;i<prices.length;i++){
            //Check from each element with its previous least min value if it is grather then global max value then update else increment.
            if(minBuyValue < prices[i]){
                int currentProfit = prices[i] - minBuyValue;
                if(currentProfit > maxProfit) maxProfit = currentProfit;
            }
            //if we are on minimum value element then the profit will come in - and it will be good place to purchase so update minumum value it with.
            else    minBuyValue = prices[i];
        }
        return maxProfit;
    }
}
