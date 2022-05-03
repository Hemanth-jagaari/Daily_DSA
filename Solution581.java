//Leetcode 3-May-2022
/*
--------------------------------581. Shortest Unsorted Continuous Subarray------------------------------------------------------------------------
Medium

Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
 
 */
class Solution581 {
	/*
	///////////////////////// Method-1
	public int findUnsortedSubarray(int[] nums) {
       int n=nums.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(nums);
        int x=-1,y=-1;
        for(int i=0;i<n;i++){
            if(arr[i]!=nums[i]){
                x=i;
                break;
            }
        }
        for(int j=n-1;j>x;j--){
            if(arr[j]!=nums[j]){
                y=j;
                break;
            }
        }
        if(x==-1 || y==-1) return 0;
        return y-x+1;
    }
	///////////////    Method -2
	public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int start=n-1,end=0;
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                start=Math.min(start,stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]<nums[i]){
                end=Math.max(end,stack.pop());
            }
            stack.push(i);
        }
        return end-start>0?end-start+1:0;
    }*/
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int start=0,end=0;
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            if(nums[i]<max) end=i;
        }
        for(int i=n-1;i>=0;i--){
            min=Math.min(min,nums[i]);
            if(nums[i]>min) start=i;
        }
        if(end>0) return end-start+1;
        return 0;
    }
}