//Leetcode 27-April-2022
/*
------------------------------------1202. Smallest String With Swaps----------------------------------------------
Medium

You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.

You can swap the characters at any pair of indices in the given pairs any number of times.

Return the lexicographically smallest string that s can be changed to after using the swaps.

 

Example 1:

Input: s = "dcab", pairs = [[0,3],[1,2]]
Output: "bacd"
Explaination: 
Swap s[0] and s[3], s = "bcad"
Swap s[1] and s[2], s = "bacd"
Example 2:

Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
Output: "abcd"
Explaination: 
Swap s[0] and s[3], s = "bcad"
Swap s[0] and s[2], s = "acbd"
Swap s[1] and s[2], s = "abcd"
Example 3:

Input: s = "cba", pairs = [[0,1],[1,2]]
Output: "abc"
Explaination: 
Swap s[0] and s[1], s = "bca"
Swap s[1] and s[2], s = "bac"
Swap s[0] and s[1], s = "abc"
 

Constraints:

1 <= s.length <= 10^5
0 <= pairs.length <= 10^5
0 <= pairs[i][0], pairs[i][1] < s.length
s only contains lower case English letters.
*/
class Solution1202 {
    private class UnionFind{
        int[] parent;
        private UnionFind(int n){
            parent=new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
        }
        private int getParent(int i){
            if(parent[i]==i) return i;
            parent[i]=getParent(parent[i]);
            return parent[i];
        }
        private void union(int i,int j){
            i=getParent(i);
            j=getParent(j);
            if(i!=j) parent[j]=i;
        }
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] arr=s.toCharArray();
        Map<Integer,PriorityQueue<Character>> map=new HashMap<>();
        UnionFind uf=new UnionFind(s.length());
        for(List<Integer> pair:pairs){
            uf.union(pair.get(0),pair.get(1));
        }
        for(int i=0;i<s.length();i++){
            int parent=uf.getParent(i);
            PriorityQueue<Character> que=map.getOrDefault(parent,new PriorityQueue<Character>());
            que.offer(arr[i]);
            map.putIfAbsent(parent,que);
        }
        for(int i=0;i<s.length();i++){
            int parent=uf.getParent(i);
            arr[i]=map.get(parent).poll();
            
        }
        return new String(arr);
    }
}