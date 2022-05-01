//Leetcode 1-May-2022
/*
------------------------------------------------844. Backspace String Compare-----------------------------------------------------------
Easy

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 

Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.
*/
//Method -1
class Solution844 {
    public String make(String s){
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='#') {
                if(!stack.isEmpty())
                stack.pop();
            }
            else stack.push(c);
        }
        s="";
        while(!stack.isEmpty()){
            s=stack.pop()+s;
        }
        return s;
    }
    public boolean backspaceCompare(String s, String t) {
        
        if(make(s).equals(make(t))) return true;
        return false;
    }
}
//Method-2
class Solution844_2 {
    public boolean backspaceCompare(String s, String t) {
        int n=s.length();
        int m=t.length();
        int i=n-1,j=m-1;
        int cs=0,ct=0;
        while(i>=0 || j>=0){
            while(i>=0){
                if(s.charAt(i)=='#'){
                    cs++;
                    i--;
                }
                else if(cs>0){
                    cs--;
                    i--;
                }
                else break;
            }
            while(j>=0){
                if(t.charAt(j)=='#'){
                    ct++;
                    j--;
                }
                else if(ct>0){
                    ct--;
                    j--;
                }
                else break;
            }
            if(i>=0 && j>=0 && s.charAt(i)!=t.charAt(j)) return false;
            if((i>=0) !=(j>=0)) return false;
            i--;j--;
        }
        return true;
    }
}