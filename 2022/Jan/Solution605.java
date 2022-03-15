//Leetcode 18-Jan-2022
/*
----------------------------------------------------605. Can Place Flowers--------------------------------------------------------------
Easy


Share
You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 

Constraints:

1 <= flowerbed.length <= 2 * 104
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length
*/
class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int z=0;
        if(flowerbed.length==1 && flowerbed[0]==0 && n>0){
            flowerbed[0]=1;
            n--;
        }
        if(n==0) return true;
        if(flowerbed[0]==0 && flowerbed[1]!=1){
            flowerbed[0]=1;
            n--;
        }
        for(int i=1;i<flowerbed.length-1;i++){
            if(n==0) return true;
            if(flowerbed[i]==0){
                if(flowerbed[i-1]!=1 && flowerbed[i+1]!=1){
                    flowerbed[i]=1;
                    n--;
                }
            }
        }
        if(flowerbed[flowerbed.length-1]==0 &&flowerbed[flowerbed.length-2]!=1){
            n--;
        }
        if(n==0) return true;
        return false;
    }
}