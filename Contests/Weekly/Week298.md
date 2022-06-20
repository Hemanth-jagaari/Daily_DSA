## Leetcode Weekly Contest 298
<details><summary>Greatest English Letter in Upper and Lower Case</summary>
  
    Problem Statement:
    Given a string of English letters s, 
    return the greatest English letter which occurs as both a lowercase and uppercase letter in s. 
    The returned letter should be in uppercase. If no such letter exists, return an empty string.
    An English letter b is greater than another letter a if b appears after a in the English alphabet.

```java
class Solution {
    public String greatestLetter(String s) {
        int[] a=new int[26];
        int[] b=new int[26];
        for(char ch:s.toCharArray()){
            if(ch>=97){
                b[ch-'a']++;
            }
            else{
                a[ch-'A']++;
            }
        }
        char ans='1';
        s=s.toUpperCase();
        for(char ch:s.toCharArray()){
            char small=(char)(ch+32);
            if(a[ch-'A']!=0 && b[small-'a']!=0){
                if(ans!='1'){
                    if(ans<ch) ans=ch;
                }
                else ans=ch;
            }
        }
        if(ans=='1') return "";
        return ans+"";
    }
}
```

</details>
<details><summary>Sum of Numbers With Units Digit K </summary>
  
    Problem Statement:
    Given two integers num and k, consider a set of positive integers with the following properties:

    The units digit of each integer is k.
    The sum of the integers is num.
    Return the minimum possible size of such a set, or -1 if no such set exists.

    Note:
    The set can contain multiple instances of the same integer, and the sum of an empty set is considered 0.
    The units digit of a number is the rightmost digit of the number.
```java
class Solution {
    public int minimumNumbers(int num, int k) {
        if(num==0) return 0;
        if(k==0){
            return num%10==0?1:-1;
        }
        int n=Math.min(num/k,10);
        for(int i=1;i<=n;i++){
            if((num-i*k)%10==0) return i;
        }
        return -1;
    }
}
```
  
</details>
<details><summary>Longest Binary Subsequence Less Than or Equal to K</summary>
  
    Problem Statement:
    You are given a binary string s and a positive integer k.
    Return the length of the longest subsequence of s that makes up a binary number less than or equal to k.
    Note:
    The subsequence can contain leading zeroes.
    The empty string is considered to be equal to 0.
    A subsequence is a string that can be derived from another string by deleting 
    some or no characters without changing the order of the remaining characters.
```java
class Solution {
    int[][] dp;
    public int solve(String s,int i,long sum,int pow,int k){
        
        if(sum>k) return Integer.MIN_VALUE-1;
        if(i>=s.length()) return 0;
        if(dp[i][pow]!=-1) return dp[i][pow];
        int res=0;
        if(pow<32){
            long val=sum+(long)((long)(s.charAt(i)-'0')<<pow);
            if(val<=k) res=Math.max(1+solve(s,i+1,val,pow+1,k),solve(s,i+1,sum,pow,k));
            else res=solve(s,i+1,sum,pow,k);
        }
        else if(s.charAt(i)=='0'){
            res=Math.max(1+solve(s,i+1,sum,pow+1,k),solve(s,i+1,sum,pow,k));
        }
        else{
            res=solve(s,i+1,sum,pow,k);
        }
        dp[i][pow]=res;
        return res;
    }
    public int longestSubsequence(String s, int k) {
        int n=s.length();
        dp=new int[n+1][n+1];
        char[] arr=s.toCharArray();
        for(int i=0;i<n/2;i++){
            char c=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=c;
        }
        s=new String(arr);
        for(int[] d:dp) Arrays.fill(d,-1);
        return solve(s,0,0L,0,k);
    }
}
```
  
</details>
<details><summary>Selling Pieces of Wood</summary></details>
