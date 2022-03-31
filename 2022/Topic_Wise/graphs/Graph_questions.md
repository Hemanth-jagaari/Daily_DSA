## Questions & solutions
<details><summary>Nodes at even distance</summary>

    Given a connected acyclic graph with n nodes and n-1 edges, 
    count the pair of nodes that are at even distance(number of edges) from each other.
    Idea:
    by using BFS traversal 
    count the nodes in even and odd levels even length possible with same level elements so count elements in in odd and even levels
    number of pairs equals to (oddCount*(oddCount-1)/2) + evenCount*(evenCount-1)/2
    
[Question Link](https://practice.geeksforgeeks.org/problems/nodes-at-even-distance0532/1#)

    
```java
class Solution
{
    int countOfNodes(ArrayList<ArrayList<Integer>> graph, int n) 
    {
        Queue<Integer> que=new LinkedList<>();
        boolean[] visited=new boolean[n+1];
        visited[1]=true;
        que.add(1);
        int level=0;
        int a=0,b=0;
        while(!que.isEmpty()){
            int size=que.size();
            if(level%2==0) a+=size;
            else b+=size;
            for(int i=0;i<size;i++){
                int curr=que.poll();
                for(int child:graph.get(curr)){
                    if(!visited[child]){
                        que.add(child);
                        visited[child]=true;
                    }
                }
            }
            level++;
            
        }
        int count=(a*(a-1)/2)+(b*(b-1)/2);
        return count;
    }
}
 ```
</details>
<details><summary>Steps by Knight</summary>

    Given a square chessboard, the initial position of Knight and position of a target. 
    Find out the minimum steps a Knight will take to reach the target position.

    Note:
    The initial and the target position coordinates of Knight have been given according to 1-base indexing.
    Idea:
    by using BFS traversal 
    Use level wise BFS , as we need minimum steps or level to find target.
    
[Question Link](https://practice.geeksforgeeks.org/problems/steps-by-knight5927/1)

    
```java
class Solution
{
  //Function to find out minimum steps Knight needs to reach target position
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        boolean[][] visited=new boolean[N][N];
        int[][] position=new int[][]{{2,-1},{2,1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
        Queue<int[]> que=new LinkedList<>();
        que.add(new int[]{KnightPos[0]-1,KnightPos[1]-1});
        visited[KnightPos[0]-1][KnightPos[1]-1]=true;
        int steps=0;
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=size;i>0;i--){
                int[] curr=que.remove();
                if(curr[0]==TargetPos[0]-1 && curr[1]==TargetPos[1]-1) return steps;
                for(int j=0;j<8;j++){
                    int a=curr[0]+position[j][0];
                    int b=curr[1]+position[j][1];
                    if(a>=0 && a<N && b>=0 && b<N && visited[a][b]==false){
                        que.add(new int[]{a,b});
                        visited[a][b]=true;
                    }
                }
            }
            steps=steps+1;
        }
        return -1;
         
    }
    
}
 ```
</details>
