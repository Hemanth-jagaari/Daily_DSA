//LeetCode 23-May-2022
/*
---------------------------------------474. Ones and Zeroes------------------------------------------------------------------------
Medium

You are given an array of binary strings strs and two integers m and n.

Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.

 

Example 1:

Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
Output: 4
Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
{"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
Example 2:

Input: strs = ["10","0","1"], m = 1, n = 1
Output: 2
Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 

Constraints:

1 <= strs.length <= 600
1 <= strs[i].length <= 100
strs[i] consists only of digits '0' and '1'.
1 <= m, n <= 100
*/
class Solution474 {
    int[][][] dp;
    public int ones(String s){
        int c=0;
        for(char ch:s.toCharArray()){
            if(ch=='1') c++;
        }
        return c;
    }
    public int solve(String[] arr,int i,int m,int n){
        if(i==arr.length){
            if(m>=0 && n>=0) return 0;
            return Integer.MIN_VALUE;
        }
        if(m<0 || n<0) return Integer.MIN_VALUE;
        if(dp[i][m][n]!=-1) return dp[i][m][n];
        int one=ones(arr[i]);
        int size=arr[i].length();
        int ans=0;
        if(one<=n && (size-one)<=m){
            ans=Math.max(1+solve(arr,i+1,m-(size-one),n-one),solve(arr,i+1,m,n));
        }
        else ans=solve(arr,i+1,m,n);
        dp[i][m][n]=ans;
        return ans;
    }
    public int findMaxForm(String[] strs, int m, int n) {
        dp=new int[strs.length][m+1][n+1];
        for(int[][] d:dp){
            for(int[] a:d) Arrays.fill(a,-1);
        }
        int ans=solve(strs,0,m,n);
        return ans<0?0:ans;
    }
}