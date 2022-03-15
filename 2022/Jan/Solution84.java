//Leetcode 29-Jan-2022
/*
-------------------------------------------------84. Largest Rectangle in Histogram-----------------------------------------------
Hard

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 

Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
*/
class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                int index=stack.pop();
                right[index]=i-1;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index=stack.pop();
            right[index]=n-1;
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                int index=stack.pop();
                left[index]=i+1;
            }
            stack.push(i);
        }
         while(!stack.isEmpty()){
            int index=stack.pop();
            left[index]=0;
        }
        int maxrect=0;
        for(int i=0;i<n;i++){
            int rect=heights[i]*(right[i]-left[i]+1);
            if(rect>maxrect){
                maxrect=rect;
            }
        }
        return maxrect;
    }
}