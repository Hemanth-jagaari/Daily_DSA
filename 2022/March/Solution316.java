//Leetcode 18-March-2022
/*
---------------------------------------------------------316. Remove Duplicate Letters-----------------------------------------------
Medium

Given a string s, remove duplicate letters so that every letter appears once and only once.
 You must make sure your result is the smallest in lexicographical order among all possible results.

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.
*/
class Solution316 {
    public String removeDuplicateLetters(String s) {
        int[] arr=new int[26];
        int[] b=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
        }
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            while(!stack.isEmpty() && stack.peek()>ch && arr[stack.peek()-'a']>0 && b[ch-'a']==0){
                b[stack.pop()-'a']=0;
            }
            if(arr[ch-'a']>0 && b[ch-'a']==0){
                stack.push(ch);
                
                b[ch-'a']=1;
            }
            arr[ch-'a']--;
            
        }
        String res="";
        while(!stack.isEmpty()){
            res=stack.pop()+res;
        }
        return res;
    }
}
