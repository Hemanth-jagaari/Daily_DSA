//Leetcode 24-Jan-2022
/*
---------------------------------------------------------520. Detect Capital-----------------------------------------------------------
Easy

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

 

Example 1:

Input: word = "USA"
Output: true
Example 2:

Input: word = "FlaG"
Output: false
 

Constraints:

1 <= word.length <= 100
word consists of lowercase and uppercase English letters.
*/
class Solution520 {
    public boolean detectCapitalUse(String word) {
        for(int i=1;i<word.length();i++){
            if(word.charAt(0)>='A' && word.charAt(0)<='Z'){
                if(word.charAt(1)>='A' && word.charAt(1)<='Z'){
                    if(word.charAt(i)>='A' && word.charAt(i)<='Z') continue;
                    else return false;
                }
                else{
                    if(word.charAt(i)>='a' && word.charAt(i)<='z') continue;
                else return false;
                }
            }
            else{
                if(word.charAt(i)>='a' && word.charAt(i)<='z') continue;
                else return false;
            }
        }
        return true;
    }
}