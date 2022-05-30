//LeetCode 29-May-2022
/*
-------------------------------------------318. Maximum Product of Word Lengths--------------------------------------------------------------
Medium

Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.

 

Example 1:

Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:

Input: words = ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.
 

Constraints:

2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] consists only of lowercase English letters.
*/
class Solution318 {
    public int count(int n){
        int c=0;
        while(n>0){
            if((n&1)==1) c++;
            n=n>>1;
        }
        return c;
    }
    public int convert(String s){
        int n=0;
        for(char ch:s.toCharArray()){
            int i=(ch-'a')+1;
            n=(n |(1<<i));
        }
        return n;
    }
    public int maxProduct(String[] words) {
        int max=0;
        for(int i=0;i<words.length;i++){
            int a=convert(words[i]);
            for(int j=i+1;j<words.length;j++){
                int b=convert(words[j]);
                int c= a ^ b;
                if(count(c)==(count(a)+count(b))){
                    int temp=words[i].length() * words[j].length();
                    max=Math.max(max,temp);
                }
            }
        }
        return max;
    }
}