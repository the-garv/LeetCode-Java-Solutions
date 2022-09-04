class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //check can we place at first index because in loop it will throw error because we need to check both side as well zero exsists or not.
        if(n>0 && flowerbed[0] == 0 && ( flowerbed.length == 1 || flowerbed[1] == 0)){
            flowerbed[0] = 1;
            n--;
        }
        //checking ever element is zero it adjacent elements are also zero or not.
        for(int i=1;i<flowerbed.length-1 && n>0 ; i++){
            if(flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                n--;
            }
        }
        //checking the last element can we place elements there also or not.
        if(n>0 && flowerbed[flowerbed.length-1] == 0 && flowerbed.length > 1 && flowerbed[flowerbed.length-2] == 0)  n--;
        
        return n == 0 ? true : false;
    }
}
