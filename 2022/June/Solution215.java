//Leetcode 22-June-2022
/*
---------------------------------------215. Kth Largest Element in an Array---------------------------------------------------------------
Medium


Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 

Constraints:

1 <= k <= nums.length <= 104
-104 <= nums[i] <= 104
*/
class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que=new PriorityQueue<>((a,b)->(-1*(a-b)));
        for(int val:nums) que.add(val);
        int ans=0;
        while(!que.isEmpty()){
           ans=que.poll();
            k--;
            if(k==0) break;
            
        }
        return ans;
    }
}