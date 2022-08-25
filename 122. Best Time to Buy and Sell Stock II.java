class Solution {
    public int maxProfit(int[] prices) {
        int totalProfit = 0, minBuyValue = prices[0];
        for(int i=1;i<prices.length;i++){
            //just checking if the curent day price is minimun then minBuyValue then update it with min value because in this case the profit will be in negative.
            if(prices[i] < minBuyValue) minBuyValue = prices[i];
            else {
            // checking if our buy is less then selling then sum that profit into totalProfit and again updating minBuyValue so that we preform the same process for next day. 
                totalProfit += prices[i]-minBuyValue;
                minBuyValue = prices[i];
            }
        }
        return totalProfit;
    }
}
