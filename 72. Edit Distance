class Solution {
    public int minDistance(String word1, String word2) {
       //return usingTopDownDp(word1, word2, 0, 0, new Integer[word1.length()+1][word2.length()+1]);
        return usingBottomUp(word1, word2);
    }
    
    public int usingRecursion(String wOne, String wTwo, int idxOne, int idxTwo){
        if(idxOne == wOne.length() || idxTwo == wTwo.length()){
            //if any one string is complete then we know the exact total opterations. they can be any of them.
            int remaningOne = wOne.length() - idxOne;
            int remaningTwo = wTwo.length() - idxTwo;
            return Math.max(remaningOne, remaningTwo);
        }
        //if both string char match then there is no operation required so we simply increment both indexs.
        if(wOne.charAt(idxOne) == wTwo.charAt(idxTwo))  return usingRecursion(wOne, wTwo, idxOne+1, idxTwo+1);
        else {
            // consider the following three operation with example first. consider w1 = horse, w2 = ros then how we will construct the solution tree.
            // insert - w1 = rhorse, w2 = ros we can also consider this as w1 = horse, w2 = os. so respective index will be idxW1, idxW2+1
            // delete - w1 = orse, w2 = ros. so respective index will be idxW1+1, idxW2
            // replace - w1 = rorse, w2 = ros we cam also write this as w1 = orse and w2 = os. so respective index will be idxW1+1, idxW2+1
            int insertOp = usingRecursion(wOne, wTwo, idxOne, idxTwo+1);
            int deleteOp = usingRecursion(wOne, wTwo, idxOne+1, idxTwo);
            int replaceOp = usingRecursion(wOne, wTwo, idxOne+1, idxTwo+1);
            return Math.min(insertOp, Math.min(deleteOp, replaceOp)) + 1;
        }
    }
    
    public int usingTopDownDp(String wOne, String wTwo, int idxOne, int idxTwo, Integer[][] dp){        
        if(dp[idxOne][idxTwo] != null)  return dp[idxOne][idxTwo];
        if(idxOne == wOne.length() || idxTwo == wTwo.length()){
            int remaningOne = wOne.length() - idxOne;
            int remaningTwo = wTwo.length() - idxTwo;
            dp[idxOne][idxTwo] = Math.max(remaningOne, remaningTwo);
            return dp[idxOne][idxTwo];
        }
        if(wOne.charAt(idxOne) == wTwo.charAt(idxTwo))  return usingTopDownDp(wOne, wTwo, idxOne+1, idxTwo+1, dp);
        else {
            int insertOp = usingTopDownDp(wOne, wTwo, idxOne, idxTwo+1, dp);
            int deleteOp = usingTopDownDp(wOne, wTwo, idxOne+1, idxTwo, dp);
            int replaceOp = usingTopDownDp(wOne, wTwo, idxOne+1, idxTwo+1, dp);
            dp[idxOne][idxTwo] = Math.min(insertOp, Math.min(deleteOp, replaceOp)) + 1;
            return dp[idxOne][idxTwo];
        }
    }
    
    public int usingBottomUp(String wOne, String wTwo){
        int[][] dp = new int[wOne.length()+1][wTwo.length()+1];
        for(int idxOne = wOne.length(); idxOne >= 0; idxOne--){
            for(int idxTwo = wTwo.length(); idxTwo >= 0; idxTwo--){
                if(idxOne == wOne.length() || idxTwo == wTwo.length()){
                    int remaningOne = wOne.length() - idxOne;
                    int remaningTwo = wTwo.length() - idxTwo;
                    dp[idxOne][idxTwo] = Math.max(remaningOne, remaningTwo);
                }
                else if(wOne.charAt(idxOne) == wTwo.charAt(idxTwo))  dp[idxOne][idxTwo] = dp[idxOne+1][idxTwo+1];
                else {
                    int insertOp = dp[idxOne][idxTwo+1];
                    int deleteOp = dp[idxOne+1][idxTwo];
                    int replaceOp = dp[idxOne+1][idxTwo+1];
                    dp[idxOne][idxTwo] = Math.min(insertOp, Math.min(deleteOp, replaceOp)) + 1;
                }
            }
        }
        return dp[0][0];
    }
}
