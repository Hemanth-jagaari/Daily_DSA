//Leetcode 15-Jan-2022
/*
---------------------------------------------------------1345. Jump Game IV-----------------------------------------------
Hard

1748

69

Add to List

Share
Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

 

Example 1:

Input: arr = [100,-23,-23,404,100,23,23,23,3
0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.
Example 2:

Input: arr = [7]
Output: 0
Explanation: Start index is the last index. You do not need to jump.
Example 3:

Input: arr = [7,6,9,6,9,6,9,7]
Output: 1
Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 

Constraints:

1 <= arr.length <= 5 * 104
-108 <= arr[i] <= 108
*/
class Solution1345 {
    public int minJumps(int[] arr) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int n=arr.length;
        int[] visited=new int[n];
        Queue<Integer> que=new LinkedList<>();
        que.add(0);
        visited[0]=1;
        int count=0;
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
        
        while(!que.isEmpty()){
            for(int k=que.size();k>0;k--){
            int curr=que.remove();
            if(curr==n-1) return count;
            List<Integer> nextmove=map.get(arr[curr]);
            nextmove.add(curr+1);
            nextmove.add(curr-1);
            for(int val:nextmove){
                if(val>=0 && val<n && visited[val]==0){
                    que.add(val);
                    visited[val]=1;
                }
            }
            map.get(arr[curr]).clear();
            }
            count++;
        }
        return count;
        
    }
}