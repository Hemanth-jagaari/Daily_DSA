## Questions & solutions
<details><summary>Flood Fill</summary>
    
    Questoion description:
    An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
    You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
    To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
    plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels 
    with newColor.

    Return the modified image after performing the flood fill.
    Idea to solve
    Solution Aapproach:
    use dfs trversal to explore all direction of given values and make newcolor to visited cells.
[Question Link](https://leetcode.com/problems/flood-fill/)
```java
class Solution {
    public void solve(int[][] image,int i,int j,int val,int color){
        if(i<0 || i>=image.length || j<0 || j>=image[0].length  ) return ;
        if(image[i][j]!=val) return;
        image[i][j]=color;
        solve(image,i+1,j,val,color);
        solve(image,i-1,j,val,color);
        solve(image,i,j+1,val,color);
        solve(image,i,j-1,val,color);
        return;
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor) return image;
        solve(image,sr,sc,image[sr][sc],newColor);
        return image;
    }
}
```
</details>
<details><summary>Nodes at even distance</summary>

    Given a connected acyclic graph with n nodes and n-1 edges, 
    count the pair of nodes that are at even distance(number of edges) from each other.
    Solution Aapproach:
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
    Solution Aapproach:
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
<details><summary>Clone Graph</summary>
    
    Questoion description
    Given a reference of a node in a connected undirected graph.
    Return a deep copy (clone) of the graph.
    Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
    Solution Aapproach:
    Bfs traversal to trverse the grpah and use Hashmap to store the original ond newly created nodes 
    connecting new nodes based on original nodes present in hashmap

```java
    class Node {
    public int val;
    public List<Node> neighbors;
    }
```
[Question Link](https://leetcode.com/problems/clone-graph/)
```java
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Node,Node> map=new HashMap<>();
        Queue<Node> que=new LinkedList<>();
        
        que.add(node);
        Node newnode=new Node();
        newnode.val=node.val;
        map.put(node,newnode);
        while(!que.isEmpty()){
            Node curr=que.poll();
            for(Node child:curr.neighbors){
                if(!map.containsKey(child)){
                    Node temp=new Node();
                    temp.val=child.val;
                    map.put(child,temp);
                    que.add(child);
                }
                Node mapcurr=map.get(curr);
                mapcurr.neighbors.add(map.get(child));  
            }
        }
        return map.get(node);
    }
}
```
</details>
<details><summary> Number of Islands</summary>
    
    Questoion description:
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
    You may assume all four edges of the grid are all surrounded by water.
    Idea to solve
    Solution Aapproach:
    Traverse the matrix when an element is 1 means its land applyy explore(dfs) function on it 
    explore function visites the all neighbouring nodes in four directions and markes the 
    visisted nodes by this we can count number of islsnads in given 2D grid
[Question Link](https://leetcode.com/problems/number-of-islands/)
```java
class Solution {
    public void explore(int i,int j,char[][] grid,List<Integer> lst){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!='1') return;
        grid[i][j]='v';
        lst.add(1);
        explore(i+1,j,grid,lst);
        explore(i-1,j,grid,lst);
        explore(i,j+1,grid,lst);
        explore(i,j-1,grid,lst);
        return;
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    List<Integer> lst=new ArrayList<>();
                    explore(i,j,grid,lst);
                   // System.out.println(lst.size());
                    c++;
                }
            }
        }
        return c;
    }
}
```
</details>
    <details><summary>Max Area of Island</summary>
    
    Questoion description:
    You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) 
    You may assume all four edges of the grid are surrounded by water.

    The area of an island is the number of cells with a value 1 in the island.
    Return the maximum area of an island in grid. If there is no island, return 0.
    Idea to solve
    Solution Aapproach:
    Similar to number of islands but maintain count of land grids in particular island and maintaining maximum among all islands
[Question Link](https://leetcode.com/problems/max-area-of-island/)
```java
class Solution {
    public int explore(int i,int j,int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=1) return 0;
        grid[i][j]=2;
        return 1+explore(i+1,j,grid)+explore(i-1,j,grid)+explore(i,j+1,grid)+explore(i,j-1,grid);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int area=explore(i,j,grid);
                    max=Math.max(max,area);
                }
            }
        }
        return max;
    }
}
```
</details>
<details><summary>Number of Closed Islands</summary>
    
    Questoion description
    Given a 2D grid consists of 0s (land) and 1s (water).  
    An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
    Return the number of closed islands.
    Idea to solve
    Solution Aapproach:
    similar to finding number of islands but check the last elemnts are surrrounded by water (value 1) by replacing visited grid value as similar to water 
    if not water return false its not closed 
[Question Link](https://leetcode.com/problems/number-of-closed-islands/)
```java
class Solution {
    public boolean explore(int i,int j,int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return false;
        if(grid[i][j]==1) return true;
        grid[i][j]=1;
        boolean up=explore(i-1,j,grid );
        boolean down=explore(i+1,j,grid);
        boolean left=explore(i,j-1,grid);
        boolean right=explore(i,j+1,grid);
        return  up && down && left && right ;
    }
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    if(explore(i,j,grid)) c++;
                }
            }
        }
        return c;
    }
}
```
</details>
<details><summary>Word Ladder</summary>
    
    Questoion description
    Idea to solve
    Solution Aapproach:
[Question Link](https://leetcode.com/problems/word-ladder/)
```java
    class Solution{
    }
```
</details>
 <br>
<details><summary>Minimum Genetic Mutation</summary>
    
    Questoion description
    Idea to solve
    Solution Aapproach:
[Question Link](https://leetcode.com/problems/minimum-genetic-mutation/)
```java
    class Solution{
    }
```
</details>
<br>
<details><summary>Shortest Path Visiting All Nodes</summary>
    
    Questoion description
    Idea to solve
    Solution Aapproach:
[Question Link](https://leetcode.com/problems/max-area-of-island/)
```java
    class Solution{
    }
```
</details>
<br>
<details><summary>Minimum Operations to Convert Number</summary>
    
    Questoion description
    Idea to solve
    Solution Aapproach:
[Question Link](https://leetcode.com/problems/max-area-of-island/)
```java
    class Solution{
    }
```
</details>
<details><summary>Name of the Question</summary>
    
    Questoion description
    Idea to solve
    Solution Aapproach:
[Question Link](https://leetcode.com/problems/max-area-of-island/)
```java
    class Solution{
    }
```
</details>
