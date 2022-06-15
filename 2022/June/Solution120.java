//Leetcode 13-June-2022
/*
--------------------------------------120. Triangle----------------------------------------------------------------------------
Medium

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
*/
class Solution120 {
    int[][] dp;
    public int solve(List<List<Integer>> tri,int i,int j){
        if(j>=tri.get(i).size()) return Integer.MAX_VALUE;
        if(i==tri.size()-1) return tri.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=Math.min(solve(tri,i+1,j),solve(tri,i+1,j+1))+tri.get(i).get(j);
        dp[i][j]=ans;
        return ans;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        dp=new int[n][n];
        for(int[] d:dp) Arrays.fill(d,-1);
        return solve(triangle,0,0);
    }
}