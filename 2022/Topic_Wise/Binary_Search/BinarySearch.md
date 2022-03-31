## Binary Search

<details><summary>Split Array Largest Sum</summary>
    
    Question:
    Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
    Write an algorithm to minimize the largest sum among these m subarrays.
    Solution Approach:
    Range Based Binary Search.
[Question Link](https://leetcode.com/problems/split-array-largest-sum/)
```java
class Solution {
    public boolean isPossible(int mid,int[] nums,int m){
        int count=1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                sum=nums[i];
                count++;
                if(count>m) return false;
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int m) {
        int max=nums[0];
        int sum=0;
        for(int val:nums){
            if(val>max) max=val;
            sum+=val;
        }
        int low=max;
        int high=sum;
        while(low<high){
            int mid=low+(high-low)/2;
            if(isPossible(mid,nums,m)){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}
```


</details>
