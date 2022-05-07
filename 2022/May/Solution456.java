//LeetCode 7-May-2022
/*
----------------------------------------------------456. 132 Pattern--------------------------------------------------------------------------------------
Medium
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

 

Example 1:

Input: nums = [1,2,3,4]
Output: false
Explanation: There is no 132 pattern in the sequence.
Example 2:

Input: nums = [3,1,4,2]
Output: true
Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
Example 3:

Input: nums = [-1,3,2,0]
Output: true
Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 

Constraints:

n == nums.length
1 <= n <= 2 * 105
-109 <= nums[i] <= 109
*/
class Solution456 {
   class Pair{
       int min;
       int num;
       Pair(int m,int n){
           this.min=m;
           this.num=n;
       }
   }
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stack=new Stack<>();
        int n=nums.length;
        int min=nums[0];
        for(int i=1;i<n;i++){
            while(!stack.isEmpty() && nums[i]>=stack.peek().num){
                stack.pop();
            }
            if(!stack.isEmpty() && nums[i]>stack.peek().min) return true;
            stack.push(new Pair(min,nums[i]));
            min=Math.min(nums[i],min);
         

        }
        return false;
    }
}
