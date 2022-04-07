//Leetcode  6-April-2022
/*
----------------------------------------------------------------923. 3Sum With Multiplicity------------------------------------------
Medium
Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.

As the answer can be very large, return it modulo 109 + 7.

 

Example 1:

Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation: 
Enumerating by the values (arr[i], arr[j], arr[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.
Example 2:

Input: arr = [1,1,2,2,2,2], target = 5
Output: 12
Explanation: 
arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways,
and two 2s from [2,2,2,2] in 6 ways.
 

Constraints:

3 <= arr.length <= 3000
0 <= arr[i] <= 100
0 <= target <= 300
*/

class Solution923 {
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int mod=1_00_00_00_00_7;
        long count=0;
        int n=arr.length;
        for(int i=0;i<n-2;i++){
            int l=i+1;
            int r=n-1;
            while(l<r){
                int sum=arr[i]+arr[l]+arr[r];
                
                if(sum==target){
                    if(arr[l]==arr[r]){
                    long m=r-l+1;
                    count+=(m*(m-1)/2);
                    break;
                    }
                    int c1=1,c2=1;
                    while(l+1<r && arr[l]==arr[l+1]){
                        c1++;
                        l++;
                    }
                    while(l+1<r && arr[r]==arr[r-1]){
                        c2++;
                        r--;
                    }
                    l++;
                    r--;
                    count+=(c1*c2);
                    //count%=mod;
                }
                else if(sum>target) r--;
                else if(sum<target) l++;
            }
        }
        return (int)(count%mod);
    }
}