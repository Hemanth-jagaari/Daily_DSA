//LeetCode 9-May-2022
/*
---------------------------------------------------------17. Letter Combinations of a Phone Number----------------------------------------------------------
Medium
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/
class Solution17 {
    public String[] alpha=new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void solve(String s,int n,String ans,List<String> lst){
        if(n<0){
            lst.add(ans);
            return;
        }
        String temp=new String(ans);
        String letter=alpha[s.charAt(n)-'2'];
        for(int i=0;i<letter.length();i++){
            solve(s,n-1,letter.charAt(i)+ans,lst);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits.length()==0) return res;
        solve(digits,digits.length()-1,"",res);
        return res;
    }
}