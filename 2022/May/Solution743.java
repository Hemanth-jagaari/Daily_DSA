//LeetCode 14-May-2022
/*
-------------------------------------------743. Network Delay Time------------------------------------------------------------
Medium

You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
*/
class Solution743 {
    public int mindist(int[] dist,HashSet<Integer> visit){
        int index=-1;
        int min=Integer.MAX_VALUE;
        for(int i=1;i<dist.length;i++){
            if(!visit.contains(i) && dist[i]<min){
                index=i;
                min=dist[i];
            }
        }
        return index;
        
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] adj=new int[n+1][n+1];
        for(int[] a:adj) Arrays.fill(a,Integer.MAX_VALUE);
        for(int[] t:times){
            adj[t[0]][t[1]]=t[2];
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        HashSet<Integer> visited=new HashSet<>();
        dist[k]=0;
        for(int i=1;i<=n;i++){
            int minindex=mindist(dist,visited);
            if(minindex==-1) break;
            visited.add(minindex);
            for(int j=1;j<=n;j++){
                int val=adj[minindex][j];
                if(!visited.contains(j) && adj[minindex][j]!=Integer.MAX_VALUE && (dist[minindex]+val)<dist[j]){
                    dist[j]=dist[minindex]+val;
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++) max=Math.max(max,dist[i]);
        return max==Integer.MAX_VALUE?-1:max;
    }
}