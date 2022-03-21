## Biweekly Contest 74

<details><summary>Divide Array Into Equal Pairs</summary>
    
    You are given an integer array nums consisting of 2 * n integers.
    You need to divide nums into n pairs such that:
    Each element belongs to exactly one pair.
    The elements present in a pair are equal.
    Return true if nums can be divided into n pairs, otherwise return false.
 ```java
  class Solution {
    public boolean divideArray(int[] nums) {
        Set<Integer>set=new HashSet<>();
        int n=nums.length;
        int c=0;
        for(int i=0;i<n;i++){
            if(set.contains(nums[i])){
                c++;
                set.remove(nums[i]);
            }
            else{
                set.add(nums[i]);
            }
        }
       // System.out.println("count ="+c);
        if(c==n/2) return true;
        return false;
    }
}
```
</details>
<details><summary>Maximize Number of Subsequences in a String</summary>
      
      You are given a 0-indexed string text and another 0-indexed string pattern of length 2, both of which consist of only lowercase English letters.

      You can add either pattern[0] or pattern[1] anywhere in text exactly once. Note that the character can be added even at the beginning or at the end of text.

      Return the maximum number of times pattern can occur as a subsequence of the modified text.

      A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

```java
  class Solution {
    public long countseq(String temp,String pattern){
        long one=0;
        long sum=0;
        for(int i=0;i<temp.length();i++){
            if(pattern.charAt(0)==pattern.charAt(1) && temp.charAt(i)==pattern.charAt(0)){
                sum+=one;
                one++;
            }
            else if(temp.charAt(i)==pattern.charAt(0)) one++;
            else if(temp.charAt(i)==pattern.charAt(1)){
                sum+=one;
            }
        }
        return sum;
    }
    public long maximumSubsequenceCount(String text, String pattern) {
        long count1=0;
        long count2=0;
        long one=0;
        String temp1=pattern.charAt(0)+text;
        String temp2=text+pattern.charAt(1);
        return Math.max(countseq(temp1,pattern),countseq(temp2,pattern));
        
    }
}
```







</details>
<details><summary>Minimum Operations to Halve Array Sum</summary>
  
    You are given an array nums of positive integers. In one operation, you can choose any number from nums and reduce it to exactly half the number. 
    (Note that you may choose this reduced number in future operations.)

    Return the minimum number of operations to reduce the sum of nums by at least half.
```java
  class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> que=new PriorityQueue<>((a,b) ->  -1 * Double.compare(a, b));
        double sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            que.add(nums[i]*1.0);
            sum+=nums[i]*1.0;
        }
        double half=sum/2;
       // System.out.println("sum ="+sum);
        while(sum>half){
            double curr=que.poll();
            double temp=curr/2;
            sum=sum-curr+temp;
            que.add(temp);
            count++;
           // System.out.println("sum ="+sum);
        }
        return count;
        
        
    }
}
```
  
  
  
  
</details>
<details><summary>Minimum White Tiles After Covering With Carpets</summary>
    
    You are given a 0-indexed binary string floor, which represents the colors of tiles on a floor:
    floor[i] = '0' denotes that the ith tile of the floor is colored black.
    On the other hand, floor[i] = '1' denotes that the ith tile of the floor is colored white.
    You are also given numCarpets and carpetLen. You have numCarpets black carpets, each of length carpetLen tiles. Cover the tiles with the given carpets 
    such that the number of white tiles still visible is minimum. Carpets may overlap one another.
    Return the minimum number of white tiles still visible.
```java
  class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        
    }
}
```
  
</details>
