//Leetcode 9-April-2022
/*
--------------------------------------------------347. Top K Frequent Elements-----------------------------------------------------
Medium

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

Solution Approach:
->count the frequency of each number store it in hashmap
->ues prorityque to maintain top k elemnts based on frequency.

*/
class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:nums) map.put(val,map.getOrDefault(val,0)+1);
        int[] ans=new int[k];
        int i=0;
        PriorityQueue<Map.Entry<Integer,Integer>> que=new PriorityQueue<>((a,b)->(a.getValue()-b.getValue()));
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            que.add(entry);
            if(que.size()>k) que.poll();
        }
        while(!que.isEmpty()){
            ans[i++]=que.poll().getKey();
        }
        return ans;
    }
}