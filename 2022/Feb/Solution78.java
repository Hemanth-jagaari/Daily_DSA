//Leetcode 13-Feb-2022
/*
----------------------------------------------78. Subsets-------------------------------------------
Medium

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
*/
class Solution78 {
    public void solve(int[] nums,int i,List<Integer> lst,List<List<Integer>> ans){
        if(i==nums.length){
            ans.add(new ArrayList<>(lst));
            return;
        }
        
        lst.add(nums[i]);
        solve(nums,i+1,lst,ans);
        lst.remove(lst.size()-1);
        solve(nums,i+1,lst,ans);
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(nums,0,new ArrayList<>(),ans);
        return ans;
    }
}