//LeetCode 6-May-2022
/*
-----------------------------------------------------1209. Remove All Adjacent Duplicates in String II--------------------------------------------------------
Medium

You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 105
2 <= k <= 104
s only contains lower case English letters.
*/
class Solution1209 {
    class Pair{
        char ch;
        int count;
        Pair(char c,int x){
            this.ch=c;
            this.count=x;
        }
    };
    public String removeDuplicates(String s, int k) {
        int n=s.length();
        Stack<Pair> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(new Pair(c,1));
            }
            else if(stack.peek().ch==c){
                stack.peek().count++;
                if(stack.peek().count==k) stack.pop();
            }
            else{
                stack.push(new Pair(c,1));
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            Pair curr = stack.pop();
            for(int i=0; i< curr.count; i++){
                res.append(curr.ch);
            }
        }
        return res.reverse().toString();
    }
}