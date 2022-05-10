//LeetCode 10-May-2022
/*
-----------------------------------------------216. Combination Sum III----------------------------------------------------------------------------------------
Medium

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 

Constraints:

2 <= k <= 9
1 <= n <= 60
*/
class Solution216 {
    public void solve(int k,int sum,int n,List<Integer> lst,List<List<Integer>> ans){
        if(k==0){
            if(sum==0){
                ans.add(new ArrayList<>(lst));
            }
            return;
        }
        if(sum<0 || n==10) return;
        lst.add(n);
        solve(k-1,sum-n,n+1,lst,ans);
        lst.remove(lst.size()-1);
        solve(k,sum,n+1,lst,ans);
        
        
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lst=new ArrayList<>();
        
        solve(k,n,1,new ArrayList<>(),lst);
        return lst;
    }
}