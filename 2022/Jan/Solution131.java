//Leetcode 5-Jan-2022
/*
--------------------------------131. Palindrome Partitioning---------------------------------------------------------
Medium

Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
*/
class Solution131 {
    public boolean ispalindrome(String s,int i,int j){
        if(i==j) return true;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public void partition(String s,List<List<String>> res,List<String> entry,int start){
        if(start==s.length()){
            res.add(new ArrayList<>(entry));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(ispalindrome(s,start,i)){
                entry.add(s.substring(start,i+1));
                partition(s,res,entry,i+1);
                entry.remove(entry.size()-1);
                
            }
        }
    }
    public List<List<String>> partition(String s) {
       
        List<List<String>> result=new ArrayList<>();
         if (s == null || s.length() == 0) return result;
        List<String> entry=new ArrayList<>();
        partition(s,result,entry,0);
        return result;
        
        
    }
}