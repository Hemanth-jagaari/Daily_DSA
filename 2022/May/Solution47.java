//LeetCode 12-May-2022
/*
----------------------------------------------47. Permutations II----------------------------------------------------------------------------------------
Medium

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
*/
class Solution47 {
    public void solve(int i,List<Integer> lst,List<List<Integer>> ans){
        if(i==lst.size()){
            ans.add(new ArrayList<>(lst));
            return;
        }
        HashSet<Integer> set=new HashSet<>();
        set.add(-11);
        for(int j=i;j<lst.size();j++){
            if(!set.contains(lst.get(j))){
            Collections.swap(lst,i,j);
            solve(i+1,lst,ans);
            Collections.swap(lst,i,j);
                set.add(lst.get(j));
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lst=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        for(int val:nums) temp.add(val);
        solve(0,temp,lst);
        return lst;
    }
}