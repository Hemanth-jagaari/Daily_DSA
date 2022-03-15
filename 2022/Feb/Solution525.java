//Leetcode 4-Feb-2022
/*
-------------------------------------------525. Contiguous Array-------------------------------------------------------
Medium

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
*/
class Solution525 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i]==1?1:-1);
            if(sum==0){
                max=i+1;
            }
            if(!map.containsKey(sum)) map.put(sum,i);
            if(map.containsKey(sum-0)){
                max=Math.max(max,i-map.get(sum-0));
            }
        }
        return max;
    }
}