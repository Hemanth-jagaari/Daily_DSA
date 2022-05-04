//Leetcode 4-May-2022
/*
----------------------------------------1679. Max Number of K-Sum Pairs----------------------------------------------------------------------------------------
Medium
You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

 

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.
Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109
*/
class Solution1679 {
	/*
	//Method-1
    public int maxOperations(int[] nums, int k) {
        int c=0,low=0,high=nums.length-1;
        Arrays.sort(nums);
        while(low<high){
            if(nums[low]+nums[high]==k){
                low++;
                high--;
                c++;
            }
            else if(nums[low]+nums[high]<k){
                low++;
            }
            else{
                high--;
            }
        }
        return c;
    }
    //Method -2
    */
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int c=0;
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            int rem=k-val;
            if(map.containsKey(rem) && map.get(rem)>0){
               
                map.put(rem,map.get(rem)-1);
                c++;
            }
            else{
                map.put(val,map.getOrDefault(val,0)+1);
            }
        }
        return c;
    }
}
