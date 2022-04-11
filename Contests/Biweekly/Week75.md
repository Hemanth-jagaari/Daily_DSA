## Biweekly Contest 75
<details><summary>Minimum Bit Flips to Convert Number</summary>
  
    Problem Statement:
    A bit flip of a number x is choosing a bit in the binary representation of x and flipping it from either 0 to 1 or 1 to 0.
```java
class Solution {
    public int minBitFlips(int start, int goal) {
        int c=0;
        start=start^goal;
        while(start>0){
            if((start & 1)==1) c++;
            start=start>>1;
        }
        return c;
    }
}
```



</details>
<details><summary>Find Triangular Sum of an Array</summary>
  
    Problem Statement:
    You are given a 0-indexed integer array nums, where nums[i] is a digit between 0 and 9 (inclusive).

    The triangular sum of nums is the value of the only element present in nums after the following process terminates:

    Let nums comprise of n elements. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n - 1.
    For each index i, where 0 <= i < n - 1, assign the value of newNums[i] as (nums[i] + nums[i+1]) % 10, where % denotes modulo operator.
    Replace the array nums with newNums.
    Repeat the entire process starting from step 1.
    Return the triangular sum of nums.
```java
class Solution {
    public int triangularSum(int[] nums) {
        int n=nums.length;
        while(n>0){
            for(int i=0;i<n-1;i++) nums[i]=(nums[i]+nums[i+1])%10;
            n--;
        }
        return nums[0];
    }
}
```
</details>
<details><summary>Number of Ways to Select Buildings</summary>

    Problem Statement:
    You are given a 0-indexed binary string s which represents the types of buildings along a street where:

    s[i] = '0' denotes that the ith building is an office and
    s[i] = '1' denotes that the ith building is a restaurant.
    As a city official, you would like to select 3 buildings for random inspection. 
    However, to ensure variety, no two consecutive buildings out of the selected buildings can be of the same type.
```java
class Solution {
    public long numberOfWays(String s) {
        int n=s.length();
        int[] one=new int[n];
        int[] zero=new int[n];
        if(s.charAt(0)=='0') zero[0]=1;
        else one[0]=1;
        long ans=0;
        for(int i=1;i<n;i++){
            if(s.charAt(i)=='0') {
                zero[i]=1+zero[i-1];
                one[i]=one[i-1];
            }
            else{
                zero[i]=zero[i-1];
                one[i]=1+one[i-1];
            }
        }
        for(int i=1;i<n;i++){
            if(s.charAt(i)=='0'){
                int b=one[i-1];
                int a=one[n-1]-one[i];
                ans+=b*a;
            }
            else{
                int b=zero[i-1];
                int a=zero[n-1]-zero[i];
                ans+=a*b;
            }
        }
        return ans;
    }
}
```
</details>
<details><summary>Sum of Scores of Built Strings</summary>
  
    Problem Statement:
    You are building a string s of length n one character at a time, prepending each new character to the front of the string. 
    The strings are labeled from 1 to n, where the string with length i is labeled si.

    For example, for s = "abaca", s1 == "a", s2 == "ca", s3 == "aca", etc.
    The score of si is the length of the longest common prefix between si and sn (Note that s == sn).

    Given the final string s, return the sum of the score of every si.
```java
  // Not optimized gives TLE 
class Solution {
    public long sumScores(String s) {
        long ans=0;
        int n=s.length();
		    int i=1;
		    while(i<n){
		    int j=i;
		    int k=0;
		    while(j<n && s.charAt(k)==s.charAt(j)){
		        k++;
		        j++;
		    }
            ans+=k;
		    i++;
		}
        return ans+n;
    }
}
```
  
</details>
