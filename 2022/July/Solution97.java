//Leetcode 7-July-2022
/*
-----------------------------------------------97. Interleaving String----------------------------------------------------------------------
Medium

Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

 

Example 1:


Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true
 

Constraints:

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lowercase English letters.
 

Follow up: Could you solve it using only O(s2.length) additional memory space?
*/
class Solution {
    int[][] dp;
    int x,y,z;
    public int solve(char[] a,char[] b,char[] c,int i,int j){
        if(i==a.length && j==b.length) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(i<x && a[i]==c[i+j] && j<y && b[j]==c[i+j]){
            int p=solve(a,b,c,i+1,j);
            int q=solve(a,b,c,i,j+1);
            dp[i][j]= p | q;
        }
        else if(i<x && a[i]==c[i+j]){
            dp[i][j]=solve(a,b,c,i+1,j);
        }
        else if(j<y && b[j]==c[i+j]){
            dp[i][j]=solve(a,b,c,i,j+1);
        }
        else dp[i][j]=0;
        return dp[i][j];
    }
    public boolean isInterleave(String s1, String s2, String s3) {
            x=s1.length();
            y=s2.length();
            z=s3.length();
            if(x+y!=z) return false;
            dp=new int[x+1][y+1];
            for(int[] d:dp) Arrays.fill(d,-1);
            return solve(s1.toCharArray(),s2.toCharArray(),s3.toCharArray(),0,0)==1?true:false;
    }
}