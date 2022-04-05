//Leetcode 5-April-2022
/*
---------------------------------------------11. Container With Most Water----------------------------------------------------------
Medium
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

 

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1
 

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*/
class Solution11 {
    public int maxArea(int[] height) {
        int n=height.length;
        int start=0;
        int end=n-1;
        int maxcap=0;
        while(start<end){
            int min=Math.min(height[start],height[end]);
            int cap=min*(end-start);
            if(cap>maxcap) maxcap=cap;
            if(height[start]<height[end]){
                start++;
            }
            else if(height[start]>height[end]){
                end--;
            }
            else{
                start++;
                end--;
            }
        }
        return maxcap;
        
    }
}