//Leetcode 11-Feb-2022
/*
-------------------------------------------------567. Permutation in String-------------------------------------------------------
Medium

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
*/
class Solution567 {
    public boolean isPossible(int[] arr){
        for(int i=0;i<26;i++){
            if(arr[i]<0) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(m<n) return false;
        int[] arr=new int[26];
        for(int i=0;i<n;i++){
            arr[s2.charAt(i)-'a']++;
            arr[s1.charAt(i)-'a']--;
        }
        for(int i=0;i<m-n;i++){
           if(isPossible(arr)) return true;
            arr[s2.charAt(i)-'a']--;
            arr[s2.charAt(i+n)-'a']++;
        }
        if(isPossible(arr)) return true;
        return false;
    }
}