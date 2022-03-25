//Leetcode 25-Jan-2022
/*
------------------------------------------------------------941. Valid Mountain Array---------------------------------------------------------
Easy
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

 

Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104
*/
class Solution941 {
    public boolean validMountainArray(int[] arr) {
        int n=arr.length;
        int i=0,j=n-1;
        while(i<n-1){
            if(arr[i]<arr[i+1]) i++;
            else break;
        }
        if(i==n-1) return false;
        while(j>0){
            if(arr[j]<arr[j-1]) j--;
            else break;
        }
        if(j==0) return false;
        return i==j;
    }
}