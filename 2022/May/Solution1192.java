//LeetCode 18-May-2022
/*
------------------------------------------1192. Critical Connections in a Network-------------------------------------------------------------------
Hard

There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:


Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
Example 2:

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]
 

Constraints:

2 <= n <= 105
n - 1 <= connections.length <= 105
0 <= ai, bi <= n - 1
ai != bi
There are no repeated connections.
*/
class Solution1192 {
    public int id=0;
    public void dfs(List<Integer>[] graph,int previd,int node,int[] memid,boolean[] visited,List<List<Integer>> ans){
        visited[node]=true;
        memid[node]=id;
        id++;
        int currid=memid[node];
        for(int neighbour:graph[node]){
            if(neighbour==previd) continue;
            if(!visited[neighbour]){
                dfs(graph,node,neighbour,memid,visited,ans);
                
            }
            memid[node]=Math.min(memid[node],memid[neighbour]);
            if(currid<memid[neighbour]){
                ans.add(Arrays.asList(node,neighbour));
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> ans=new ArrayList<>();
        int[] memid=new int[n];
        boolean[] visited=new boolean[n];
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
        for(List<Integer> lst:connections){
            graph[lst.get(0)].add(lst.get(1));
            graph[lst.get(1)].add(lst.get(0));
        }
        dfs(graph,-1,0,memid,visited,ans);
        return ans;
        
    }
}