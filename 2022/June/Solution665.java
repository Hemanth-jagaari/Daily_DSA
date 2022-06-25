//Leetcode 25-June-2022
/*
----------------------------------665. Non-decreasing Array-----------------------------------------------------
Medium

Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

 

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.
 

Constraints:

n == nums.length
1 <= n <= 104
-105 <= nums[i] <= 105
*/
class Solution665 {
    public boolean checkPossibility(int[] nums) {
        int n=nums.length;
        int modify=0;
        for(int i=1;i<n;i++){
            if(nums[i-1]>nums[i]){
                modify++;
                if(i>=2 && nums[i-2]>nums[i]){
                    nums[i]=nums[i-1];
                }
                else{
                    nums[i-1]=nums[i];
                }
            }
        }
        return modify<=1;
    }
}