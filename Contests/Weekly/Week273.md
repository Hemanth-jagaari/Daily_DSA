## weekly challenge 273
<details><summary>A Number After a Double Reversal</summary>
  Reversing an integer means to reverse all its digits.

For example, reversing 2021 gives 1202. Reversing 12300 gives 321 as the leading zeros are not retained.
Given an integer num, reverse num to get reversed1, then reverse reversed1 to get reversed2. Return true if reversed2 equals num. Otherwise return false.



```java
  class Solution {
    public boolean isSameAfterReversals(int num) {
        if(num<=9) return true;
        else if(num%10==0) return false;
        else return true;
        
    }
}
  ```

</details>
  <details><summary>Execution of All Suffix Instructions Staying in a Grid</summary>
  
    There is an n x n grid, with the top-left cell at (0, 0) and the bottom-right cell at (n - 1, n - 1). You are given the integer n and an integer array startPos         where startPos = [startrow, startcol] indicates that a robot is initially at cell (startrow, startcol).

    You are also given a 0-indexed string s of length m where s[i] is the ith instruction for the robot: 'L' (move left), 'R' (move right), 'U' (move up), and 'D'         (move down).

    The robot can begin executing from any ith instruction in s. It executes the instructions one by one towards the end of s but it stops if either of these                conditions is met:

    The next instruction will move the robot off the grid.
    There are no more instructions left to execute.
    Return an array answer of length m where answer[i] is the number of instructions the robot can execute if the robot begins executing from the ith instruction in s.
  
```java
    class Solution {
    public boolean isSafe(int i,int j,int n){
        if((i>=0 && i<n) &&(j>=0 && j<n)) return true;
        return false;
    }
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m=s.length();
        int[] res=new int[m];
        int c=0;
        int row=startPos[0],col=startPos[1];
        for(int i=0;i<m;i++){
            c=0;
            row=startPos[0];
            col=startPos[1];
            for(int j=i;j<m;j++){
                char ch=s.charAt(j);
                if(ch=='L'){
                    if(isSafe(row,col-1,n)){
                        col=col-1;
                    }
                    else break;
                }
                else if(ch=='R'){
                    if(isSafe(row,col+1,n)){
                        col=col+1;
                    }
                    else break;
                    
                }
                else if(ch=='U'){
                    if(isSafe(row-1,col,n)){
                        row=row-1;
                    }
                    else break;
                    
                }
                else if(ch=='D'){
                    if(isSafe(row+1,col,n)){
                        row=row+1;
                    }
                    else break;
                }
                c=c+1;
            }
            res[i]=c;
        }
        return res;
        
    }
}
 ```
</details>
    <details><summary>Intervals Between Identical Elements</summary>
    
    You are given a 0-indexed array of n integers arr.

    The interval between two elements in arr is defined as the absolute difference between their indices. More formally, 
    the interval between arr[i] and arr[j] is |i       - j|.

    Return an array intervals of length n where intervals[i] is the sum of intervals between arr[i] and each element in arr with the same value as arr[i].

    Note: |x| is the absolute value of x.
    
    
```java
      class Solution {
    public long[] getDistances(int[] arr) {
        int n=arr.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>(); 
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                map.get(arr[i]).add(i);
            }
            else{
                List<Integer> lst=new ArrayList<>();
                lst.add(i);
                map.put(arr[i],lst);
            }
        }
        long[] res=new long[n];
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            List<Integer> lst=entry.getValue();
            int size=lst.size();
            long sum=0;
            for(int val:lst){
                sum=sum+val;
            }
            long presum=0;
            for(int i=0;i<size;i++){
                int num=lst.get(i);
                presum=presum+num;
                res[num]=sum+(2*i+2-size)*(long)num-2*presum;
            }
            
        }
        return res;
        
    }
}
```
</details>
      <details><summary>Recover the Original Array</summary>
      
    Alice had a 0-indexed array arr consisting of n positive integers. She chose an arbitrary positive integer k and 
    created two new 0-indexed integer arrays lower and higher in the following manner:

    lower[i] = arr[i] - k, for every index i where 0 <= i < n
    higher[i] = arr[i] + k, for every index i where 0 <= i < n
    Unfortunately, Alice lost all three arrays. However, she remembers the integers that were present in the arrays lower and higher, 
    but not the array each integer belonged to. Help Alice and recover the original array.

    Given an array nums consisting of 2n integers, where exactly n of the integers were present in lower and the remaining in higher, 
    return the original array arr. In case the answer is not unique, return any valid array.

    Note: The test cases are generated such that there exists at least one valid array arr.
      
```java
        class Solution {
    public List<Integer> helper(int diff,int[] nums){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int num:nums){
            if(map.get(num)>0 && map.containsKey(num+diff) && map.get(num+diff)>0){
                res.add(num+ diff/2);
                map.put(num,map.get(num)-1);
                map.put(num+diff,map.get(num+diff)-1);
            }
        }
        return res;
    }
    public int[] recoverArray(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
       
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            int temp=nums[i]-nums[0];
            if(temp>0 && temp%2==0) set.add(temp);
        }
        int size=n/2;
        for(int d:set){
            List<Integer> res=helper(d,nums);
            if(res.size()==size){
                int[] ans=new int[size];
                int i=0;
                for(int val:res) ans[i++]=val;
                return ans;
            }
        }
        return new int[]{};
        
    }
}
```
      
      
      
      
</details>
