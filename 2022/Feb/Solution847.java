//Leetcode 26-Feb-2022
/*
-------------------------------------------------------------847. Shortest Path Visiting All Nodes------------------------------------------
Hard


You have an undirected, connected graph of n nodes labeled from 0 to n - 1. You are given an array graph where graph[i] is a list of all the nodes connected with node i by an edge.

Return the length of the shortest path that visits every node. You may start and stop at any node, you may revisit nodes multiple times, and you may reuse edges.

 

Example 1:


Input: graph = [[1,2,3],[0],[0],[0]]
Output: 4
Explanation: One possible path is [1,0,2,0,3]
Example 2:


Input: graph = [[1],[0,2,4],[1,3,4],[2],[1,2]]
Output: 4
Explanation: One possible path is [0,1,4,2,3]
 

Constraints:

n == graph.length
1 <= n <= 12
0 <= graph[i].length < n
graph[i] does not contain i.
If graph[a] contains b, then graph[b] contains a.
The input graph is always connected.
*/
class Solution847 {
    public int shortestPathLength(int[][] graph) {
         int n=graph.length;
        if(n==1) return 0;
        int finalans=(1<<n) -1;
       // System.out.println("finalstate="+finalans);
        Queue<int[]> que=new LinkedList<>();
        int[][] visited=new int[n][finalans+1];
        for(int i=0;i<n;i++){
            que.add(new int[]{i,(1<<i)});
            
        }
        
        int shortpath=0;
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                int[] curr=que.poll();
                int node=curr[0];
                int state=curr[1];
                for(int nextnode:graph[node]){
                    
                    int nextstate=state|(1 << nextnode);
                    
                    if(visited[nextnode][nextstate]==1) continue;
                    if(nextstate==finalans) return shortpath+1;
                    que.add(new int[]{nextnode,nextstate});
                    visited[nextnode][nextstate]=1;
                }
                
            }
            shortpath++;
        }
        return -1;
    }
}