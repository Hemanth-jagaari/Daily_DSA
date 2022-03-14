//Leetcode 13-March-2022
/* 
----------------valid parentheses-------------------------
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

*/class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        int n=s.length();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='[' || ch=='{' || ch=='('){
                stack.push(ch);
                continue;
            }
            if(stack.empty()){
                return false;
            }
            char temp;
            switch(ch){
                case ')':
                    temp=stack.pop();
                    if(temp=='{' || temp=='[') return false;
                    break;
                    case ']':
                    temp=stack.pop();
                    if(temp=='{' || temp=='(') return false;
                    break;
                    case '}':
                    temp=stack.pop();
                    if(temp=='[' || temp=='(') return false;
                    break;
            }
            
        }
                   return stack.empty();
        
    }
}