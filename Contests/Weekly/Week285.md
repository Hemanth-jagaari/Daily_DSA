## Weekly Contest 285
<details><summary>Count Hills and Valleys in an Array</summary>
  
    Problem Statement:
    You are given a 0-indexed integer array nums. 
    An index i is part of a hill in nums if the closest non-equal neighbors of i are smaller than nums[i]. 
    Similarly, an index i is part of a valley in nums if the closest non-equal neighbors of i are larger than nums[i]. 
    Adjacent indices i and j are part of the same hill or valley if nums[i] == nums[j].

    Note that for an index to be part of a hill or valley, it must have a non-equal neighbor on both the left and right of the index.

    Return the number of hills and valleys in nums.
```java
class Solution {
    public int countHillValley(int[] nums) {
        int hills=0;
        int vally=0;
        int prev=nums[0];
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]) continue;
            else{
                if(nums[i]>prev && nums[i]>nums[i+1]) hills++;
                else if(nums[i]<prev && nums[i]<nums[i+1]) vally++;
                prev=nums[i];
            }
        }
        return hills+vally;
        
    }
}
```
</details>
<details><summary>Count Collisions on a Road</summary>
  
    Problem Statement:
    There are n cars on an infinitely long road. 
    The cars are numbered from 0 to n - 1 from left to right and each car is present at a unique point.

    You are given a 0-indexed string directions of length n. 
    directions[i] can be either 'L', 'R', or 'S' denoting whether the ith car is moving towards the left, towards the right, or staying at its current point               respectively. Each moving car has the same speed.

    The number of collisions can be calculated as follows:

    When two cars moving in opposite directions collide with each other, the number of collisions increases by 2.
    When a moving car collides with a stationary car, the number of collisions increases by 1.
    After a collision, the cars involved can no longer move and will stay at the point where they collided. 
    Other than that, cars cannot change their state or direction of motion.

    Return the total number of collisions that will happen on the road.
```java
class Solution {
    public int countCollisions(String directions) {
        int count=0;
        int right=0;
        boolean stat=false;
        for(int i=0;i<directions.length();i++){
            if(directions.charAt(i)=='R'){
                right++;
                stat=false;
            }
            else if(directions.charAt(i)=='L'){
                if(right>0){
                    count+=2+right-1;
                    right=0;
                    stat=true;
                }
                else if(stat==true) count++;
            }
            else if(directions.charAt(i)=='S'){
                if(right>0){
                     count+=right;
                    right=0;
                }
                stat=true;
            }
        }
        return count;
    }
}
```
  
  
</details>
<details><summary>Maximum Points in an Archery Competition</summary></details>
<details><summary>Longest Substring of One Repeating Character</summary></details>
