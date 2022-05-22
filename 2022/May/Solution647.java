//LeetCode 22-May-2022
/*
-------------------------------------647. Palindromic Substrings---------------------------------------------------------------------------------
Medium

Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
*/
class Solution647 {
    public int countSubstrings(String s) {
        int n=s.length();
        int[][] dp=new int[n][n];
        int c=0;
        for(int i=0;i<n;i++) {
            dp[i][i]=1;
            c++;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=1;
                c++;
            }
        }
        for(int j=3;j<=n;j++){
            for(int i=0;i<n-j+1;i++){
                int k=i+j-1;
                if(s.charAt(i)==s.charAt(k) && dp[i+1][k-1]==1){
                    c++;
                    dp[i][k]=1;
                    
                }
            }
        }
        return c;
    }
}