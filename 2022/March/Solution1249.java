//Leetcode 15-March-2022
/*
------------------------------------------------------------1249. Minimum Remove to Make Valid Parentheses------------------------------
Medium

Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 

Constraints:

1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.
*/
class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        String res="";
        int open=0;
        Stack<String> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='('){
               open++;
               stack.push("(");
           }
           else if(s.charAt(i)==')'){
                if(open>0){
                    String temp="";
                    while(!stack.peek().equals("(")){
                        temp=stack.pop()+temp;
                    }
                    stack.pop();
                    stack.push("("+temp+")");
                    open--;
                    //System.out.println(" else if temp ="+temp);
                }
            }
            else{
               stack.push(s.charAt(i)+"");
            }
        }
        while(!stack.isEmpty()){
            String temp=stack.pop();
            if(!temp.equals("("))
            res=temp+res;
        }
        return res;
    }
}