//Leetcode 18-Feb-2022
/*
------------------------------------------------------402. Remove K Digits-------------------------------------------------------
Medium

5848

242

Add to List

Share
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

 

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 

Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.
*/
class Solution402 {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack=new Stack<>();
        Stack<Integer> help=new Stack<>(); 
        stack.push(num.charAt(0)-'0');
        for(int i=1;i<num.length();i++){
            int a=num.charAt(i)-'0';
            while(k>0 && !stack.isEmpty() && stack.peek()>a){
                    stack.pop();
                    k--;
                }
            stack.push(a);
            
        }
        while(k>0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        //System.out.println("stack size ="+stack.size()+"  "+stack.peek());
        String res="";
        while(!stack.isEmpty()){
            help.push(stack.pop());
        }
        while(!help.isEmpty() && help.peek()==0) help.pop();
        while(!help.isEmpty()){
            res=res+(char)(help.pop()+'0');
        }
        if(res.length()==0) return "0";
        return res;
    }
}