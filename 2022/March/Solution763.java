//Leetcode 21-March-2022
/*
-------------------------------------------------------------763. Partition Labels-----------------------------------------------------
Medium

6965

261

Add to List

Share
You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

 

Example 1:

Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
Example 2:

Input: s = "eccbbbbdec"
Output: [10]
 

Constraints:

1 <= s.length <= 500
s consists of lowercase English letters.
*/
// idea is to store the last occurence or each Character and iterate through each Character and calculate max index of character
//whenever the maxrange equals to current index add the length to list and mak start= index+1 contine iteration
class Solution763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans=new ArrayList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }
        int maxrange=map.get(s.charAt(0));
        int start=0;
        for(int i=0;i<s.length();i++){
            maxrange=Math.max(maxrange,map.get(s.charAt(i)));
            if(maxrange==i){
                ans.add(maxrange-start+1);
                start=i+1;
            }
        }
        
        return ans;
    }
}