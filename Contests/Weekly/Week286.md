## Weekly Contest 286
<details><summary>Find the Difference of Two Arrays</summary>
  
    Problem Statement:
    Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

    answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
    answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
    Note that the integers in the lists may be returned in any order.
```java
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<Integer> one=new HashSet<>();
        HashSet<Integer> two=new HashSet<>();
        for(int val:nums1) one.add(val);
        for(int val:nums2) two.add(val);
        List<Integer> lst=new ArrayList<>();

        for(int val:one){
            if(!two.contains(val)) lst.add(val);
        }
        ans.add(lst);
        List<Integer> lst2=new ArrayList<>();
        for(int val:two){
            if(!one.contains(val)) lst2.add(val);
        }
        ans.add(lst2);
        return ans;
    }
}
```


</details>
<details><summary>Minimum Deletions to Make Array Beautiful</summary>
  
    Problem Statement:
    You are given a 0-indexed integer array nums. The array nums is beautiful if:

    nums.length is even.
    nums[i] != nums[i + 1] for all i % 2 == 0.
    Note that an empty array is considered beautiful.

    You can delete any number of elements from nums. 
    When you delete an element, all the elements to the right of the deleted element will be shifted one unit to the left to fill the gap created 
    and all the elements    to the left of the deleted element will remain unchanged.

    Return the minimum number of elements to delete from nums to make it beautiful.
```java
class Solution {
    public int minDeletion(int[] nums) {
        int n=nums.length;
        int count=0;
        int i=0;
        while(i<n-1){
            if(count%2==0){
                if(i%2==0 && nums[i]==nums[i+1]){
                    count++;
                }
            }
            else{
                if(i%2==1 && nums[i]==nums[i+1]){
                    count++;
                }
            }
            i=i+1;
        }
        if((n-count)%2==1) count++;
        return count;
        
    }
}
```
  
  
  
</details>
<details><summary>Find Palindrome With Fixed Length</summary>
  
    Problem Statement:
    Given an integer array queries and a positive integer intLength, 
    return an array answer where answer[i] is either the queries[i]th smallest positive palindrome of    
    length intLength or -1 if no such palindrome exists.

    A palindrome is a number that reads the same backwards and forwards. Palindromes cannot have leading zeros.
```java
class Solution {
    public long reverse(long n){
        long sum=0;
        while(n>0){
            sum=sum*10 + n%10;
            n/=10;
        }
        return sum;
    }
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n=queries.length;
        long[] ans=new long[n];
        long first=0L;
        if(intLength%2==0) first=(long)Math.pow(10,intLength/2-1);
        else first=(long)Math.pow(10,intLength/2);
        long digits=(long)Math.floor(intLength/2);
        long count=(long)(intLength/2);
        if(intLength%2==0) count--;
        count=9*(long)Math.pow(10,count);
        //System.out.println("first="+first+" count="+count+" digits="+digits);
        for(int i=0;i<n;i++){
            int val=queries[i];
            if(val>count) ans[i]=-1;
            else{
                long half=val-1+first;
                long num=half*(long)Math.pow(10,digits);
                if(intLength%2!=0) half=half/10;
                num+=reverse(half);
                ans[i]=num;
            }
        }
        return ans;
    }
}        
```
  
  
</details>
<details><summary>Maximum Value of K Coins From Piles</summary>
  
    Problem Statement:
    There are n piles of coins on a table. Each pile consists of a positive number of coins of assorted denominations.

    In one move, you can choose any coin on top of any pile, remove it, and add it to your wallet.

    Given a list piles, where piles[i] is a list of integers denoting the composition of the ith pile from top to bottom, 
    and a positive integer k, return the maximum total value of coins you can have in your wallet if you choose exactly k coins optimally.
```java
class Solution {
    int[][] dp;
    public int solve(List<List<Integer>> piles,int i,int k){
        if(i==piles.size() || k==0) return 0;
        if(dp[i][k]!=-1) return dp[i][k];
        int ans=solve(piles,i+1,k);
        int sum=0;
        int size=Math.min(piles.get(i).size(),k);
        for(int j=0;j<size;j++){
            sum+=piles.get(i).get(j);
            ans=Math.max(sum+solve(piles,i+1,k-(j+1)),ans);
        }
        dp[i][k]=ans;
        return ans;
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n=piles.size();
        dp=new int[n+1][k+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return solve(piles,0,k);
    }
}
```
  
  
  
  
</details>
