//Leetcode 27-Jan-2022
/*
------------------------------------------------421. Maximum XOR of Two Numbers in an Array-----------------------------------------------
Medium

3772

319

Add to List

Share
Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

 

Example 1:

Input: nums = [3,10,5,25,2,8]
Output: 28
Explanation: The maximum result is 5 XOR 25 = 28.
Example 2:

Input: nums = [14,70,53,83,49,91,36,80,92,51,66,70]
Output: 127
 

Constraints:

1 <= nums.length <= 2 * 105
0 <= nums[i] <= 231 - 1
*/
class Solution421 {
    public int findMaximumXOR(int[] nums) {
        int max=0;
        HashSet<Integer> set=new HashSet<>();
        int mask=0;
        for(int i=30;i>=0;i--){
            mask=mask | (1<<i);
            System.out.println("mask ="+mask+"   "+(1<<i));
            for(int val:nums){
                set.add(val&mask);
            }
            int temp=max|(1<<i);
            for(int val:set){
                if(set.contains(temp^val)){
                    max=temp;
                    break;
                }
            }
            set.clear();
        }
        return max;
        
    }
}
