//Leetcode 2-Jan-2022
/*
---------------------------------------------438. Find All Anagrams in a String-------------------------------------------
Medium


Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
*/
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
         int n=s.length();
        int m=p.length();
        List<Integer> res=new ArrayList<>();
        if(n<m) return res;
        int[] a=new int[26];
        int[] b=new int[26];
        for(int i=0;i<m;i++){
            a[p.charAt(i)-'a']++;
            
        }
        for(int i=0;i<m-1;i++){
            b[s.charAt(i)-'a']++;
        }
        int j=0;
        for(int i=m-1;i<n;i++){
            b[s.charAt(i)-'a']++;
           if(Arrays.equals(a,b)) res.add(j);
            b[s.charAt(j)-'a']--;
            j++; 
        }
        return res;
    }
}