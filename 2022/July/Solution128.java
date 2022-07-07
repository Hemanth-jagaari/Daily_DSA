//Leetcode 5-July-2022
/*
---------------------------------------------128. Longest Consecutive Sequence----------------------------------------------------
Medium

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
*/
class Solution128 {
    public int longestConsecutive(int[] nums) {
       /*
       //method - 1
       Arrays.sort(nums);
        int max=1;
        int c=1;
        if(nums.length==0) return 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]) continue;
            else if(nums[i]==nums[i-1]+1){
                c++;
            }
            else{
                c=1;
            }
            max=Math.max(max,c);
        }
        return max;*/
        if(nums.length==0) return 0;
        int max=1;
        HashSet<Integer> set=new HashSet<>();
        for(int val:nums){
            set.add(val);
        }
        for(int val:nums){
            if(set.contains(val-1)) continue;
            else{
                int c=1;
                while(set.contains(val+1)){
                    c++;
                    val+=1;
                }
                if(max<c) max=c;
            }
        }
        return max;
    }
}