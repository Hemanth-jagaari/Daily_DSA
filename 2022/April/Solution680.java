//Leetcode 2-April-2022
/*
--------------------------------------------------------680. Valid Palindrome II---------------------------------------------------
Easy

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:

Input: s = "aba"
Output: true
Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.
Example 3:

Input: s = "abc"
Output: false
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
*/
class Solution680 {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            char a=s.charAt(i),b=s.charAt(j);
            if(a!=b) return false;
                i++;
                j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
      int l=0,h=s.length()-1;
        while(l<h){
            char a=s.charAt(l),b=s.charAt(h);
            if(a==b){
                l++;
                h--;
            }
            else{
                return isPalindrome(s.substring(l+1,h+1)) || isPalindrome(s.substring(l,h));
            }
        }
        return true;
    }
}