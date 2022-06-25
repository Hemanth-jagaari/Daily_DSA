//Leetcode 16-June-2022
/*
-----------------------------------5. Longest Palindromic Substring--------------------------------------------------------------------
Medium

Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/
class Solution5 {
    public String longestPalindrome(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        String res="";
        for(int i=0;i<n;i++) {
            dp[i][i]=1;
            if(1>res.length()) res=s.substring(i,i+1);
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;
                if(2>res.length()) res=s.substring(i,i+2);
            }
        }
        for(int j=3;j<=n;j++){
            for(int i=0;i<n-j+1;i++){
                int k=i+j-1;
                if(s.charAt(i)==s.charAt(k) && dp[i+1][k-1]==1){
                    if((k-i+1)>res.length()) res=s.substring(i,k+1);
                    dp[i][k]=1;
                    
                }
            }
        }
        return res;
    }
}