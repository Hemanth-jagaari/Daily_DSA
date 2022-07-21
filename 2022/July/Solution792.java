//Leetcode 20-July-2022
/*
----------------------------------------------792. Number of Matching Subsequences --------------------------------------------------------------
Medium


Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
 

Example 1:

Input: s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
Example 2:

Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2
 

Constraints:

1 <= s.length <= 5 * 104
1 <= words.length <= 5000
1 <= words[i].length <= 50
s and words[i] consist of only lowercase English letters.
*/
class Solution792 {
    
    public int numMatchingSubseq(String s, String[] words) {
        int count=0;
       HashMap<Character,Queue<String>> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.putIfAbsent(ch,new LinkedList<>());
        }
        for(String wrd:words){
            char start=wrd.charAt(0);
            if(map.containsKey(start)){
                map.get(start).add(wrd);
            }
        }
        for(char ch:s.toCharArray()){
            Queue<String> temp=map.get(ch);
            int size=temp.size();
            for(int i=0;i<size;i++){
                String curr=temp.poll();
                if(curr.substring(1).length()==0){
                    count++;
                }
                else{
                    if(map.containsKey(curr.charAt(1))){
                        map.get(curr.charAt(1)).add(curr.substring(1));
                    }
                }
            }
        }
        return count;
    }
}