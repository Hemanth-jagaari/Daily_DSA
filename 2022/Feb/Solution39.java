//Leetcode 17-Feb-2022
/*
-------------------------------------------------39. Combination Sum--------------------------------------------------------
Medium

10122

219

Add to List

Share
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500
*/
class Solution39 {
    public void solve(int[] candidates,int target,int n,List<Integer> lst,List<List<Integer>> res){
        if(target==0){
            res.add(new ArrayList<>(lst));
            return;
        }
        else if(target<0 || n==candidates.length) return; 
        lst.add(candidates[n]);
        solve(candidates,target-candidates[n],n,lst,res);
        lst.remove(lst.size()-1);
        solve(candidates,target,n+1,lst,res);  
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        solve(candidates,target,0,new ArrayList<>(),res);
        return res;
    }
}