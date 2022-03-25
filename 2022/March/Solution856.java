//Leetcode 17-March-2022
/*
-----------------------------------------------------------------856. Score of Parentheses--------------------------------------------------
Medium

Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: s = "()"
Output: 1
Example 2:

Input: s = "(())"
Output: 2
Example 3:

Input: s = "()()"
Output: 2
 

Constraints:

2 <= s.length <= 50
s consists of only '(' and ')'.
s is a balanced parentheses string.
*/
class Solution856 {
    public int scoreOfParentheses(String s) {
        /*Stack<String> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(') stack.push(ch+"");
            else{
                int temp=0;
                while(!stack.peek().equals("(")){
                    temp+=Integer.parseInt(stack.pop());
                }
                stack.pop();
                if(temp==0) stack.push("1");
                else stack.push((2*temp)+"");
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum+=Integer.parseInt(stack.pop());
        }
        return sum;*/
        //method 2
        Stack<Integer> stack=new Stack<>();
        int sum=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(sum);
                sum=0;
            }
            else{
                sum=stack.pop()+Math.max(2*sum,1);
            }
        }
        return sum;
    }
}
