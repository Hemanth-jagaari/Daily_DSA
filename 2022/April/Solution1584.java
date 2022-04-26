//Leetcode 26-April-2022
/*
-------------------------------------------1584. Min Cost to Connect All Points--------------------------------------------
Medium
You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

 

Example 1:


Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation: 

We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.
Example 2:

Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18
 

Constraints:

1 <= points.length <= 1000
-106 <= xi, yi <= 106
All pairs (xi, yi) are distinct.
*/
class Solution1584{
    public int dist(int x1,int y1,int x2,int y2){
        return Math.abs(x1-x2)+Math.abs(y2-y1);
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length,cost=0;
        PriorityQueue<int[]> que=new PriorityQueue<>((a,b)->(a[2]-b[2]));
        HashSet<Integer> visit=new HashSet<>();
        que.add(new int[]{0,0,0});
        while(!que.isEmpty() && visit.size()<n){
            int[] curr=que.poll();
            if(visit.contains(curr[1])) continue;
            cost+=curr[2];
            visit.add(curr[1]);
            for(int i=0;i<n;i++){
                if(!visit.contains(i)){
                    que.add(new int[]{curr[1],i,dist(points[curr[1]][0],points[curr[1]][1],points[i][0],points[i][1])});
                }
            }
        }
        return cost;
        
    }
}