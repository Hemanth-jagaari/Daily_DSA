//LeetCode 11-May-2022
/*
-----------------------------------------1641. Count Sorted Vowel Strings----------------------------------------------------------------------------------
Medium

Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

 

Example 1:

Input: n = 1
Output: 5
Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
Example 2:

Input: n = 2
Output: 15
Explanation: The 15 sorted strings that consist of vowels only are
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
Example 3:

Input: n = 33
Output: 66045
 

Constraints:

1 <= n <= 50 
*/
class Solution1641 {
    /*int[][] dp;
    public int solv2(int n,int i){
        if(n==0) return 1;
        if(i==5){
            return 0;
        }
        if(dp[n][i]!=-1) return dp[n][i];
        int ans=0;
        ans+=solv2(n-1,i);
        ans+=solv2(n,i+1);
        dp[n][i]=ans;
        return ans;
    }*/
    public int countVowelStrings(int n) {
        /*dp=new int[n+1][6];
        for(int[] d:dp) Arrays.fill(d,-1);
        return solv2(n,0);*/
        int[] dp=new int[]{0,1,1,1,1,1};
        for(int i=0;i<n;i++){
            for(int j=1;j<=5;j++){
                dp[j]+=dp[j-1];
            }
        }
        return dp[5];
    }
}