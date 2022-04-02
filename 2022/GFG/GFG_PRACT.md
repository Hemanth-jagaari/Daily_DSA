
## GFG Problem of the Day<br>
# It contains some interesting pracice questions of MEdium and HaRd LEvel.
<details><summary>Smaller on Left</summary>
	
	Problem Statement:
	Given an array arr[ ] of N positive integers, 
	the task is to find the greatest element on the left of every element in the array which is strictly smaller than itself, 
	if this element does not exist for an index print "-1".
	22-March-2022
[Practice Link](https://practice.geeksforgeeks.org/problems/smaller-on-left20360700/1)
```java
class Complete{
    
   
    // Function for finding maximum and value pair
    public static int[] Smallestonleft (int arr[], int n) {
        int[] ans=new int[n];
        ans[0]=-1;
        TreeSet<Integer> set=new TreeSet<>();
        set.add(arr[0]);
        for(int i=1;i<n;i++){
            if(set.floor(arr[i]-1)!=null){
                ans[i]=set.floor(arr[i]-1);
            }
            else{
                ans[i]=-1;
            }
            set.add(arr[i]);
        }
        return ans;
    }
}

```


</details>

<details><summary>Swap Kth nodes from ends</summary>
	
		Problem Statement:
		Given a singly linked list of size N, and an integer K. 
		You need to swap the Kth node from the beginning and Kth node from the end of the linked list.
		Swap the nodes through the links. Do not change the content of the nodes.
[Practice Link](https://practice.geeksforgeeks.org/problems/swap-kth-node-from-beginning-and-kth-node-from-end-in-a-singly-linked-list/1)
```java
class GFG
{
    //Function to swap Kth node from beginning and end in a linked list.
    Node swapkthnode(Node head, int num, int K)
    {
        int N=num;
        
        if(K>N) return head;
        if((N-K+1)<K) K=N-K+1;
        Node fprev=null;
        Node first=null;
        Node lprev=null;
        Node last=null;
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            if(count<=K){
                fprev=first;
                first=temp;
                
            }
            if(count<=(N-K+1)){
                lprev=last;
                last=temp;
            }
            temp=temp.next;
        }
        if(fprev==null){
            fprev=new Node(-1);
            fprev.next=first;
        }
        if(first.next==last){
            Node lnext=last.next;
            last.next=first;
            first.next=lnext;
            fprev.next=last;
        }
        else{
            Node fnext=first.next;
            Node lnext=last.next;
            first.next=lnext;
            last.next=fnext;
            fprev.next=last;
            lprev.next=first;
        }
        
        if(K==1) return fprev.next;
        
        //System.out.println(first.data+" "+last.data);
        return head;
        
    }
}

```

</details>

<details><summary>Form a palindrome</summary>
	
		Problem Statement:
		Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
		For Example:
		ab: Number of insertions required is 1. bab or aba
		aa: Number of insertions required is 0. aa
		abcd: Number of insertions required is 3. dcbabcd
[Practice Link](https://practice.geeksforgeeks.org/problems/form-a-palindrome2544/1)

```java
class Solution{
    int solve(String a,String b,int i,int j,int[][] dp){
        if(i==0 || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i-1)==b.charAt(j-1)){
            dp[i][j]=1+solve(a,b,i-1,j-1,dp);
            
        }
        else
        dp[i][j]=Math.max(solve(a,b,i,j-1,dp),solve(a,b,i-1,j,dp));
        return dp[i][j];
    }
    int findMinInsertions(String S){
        String s="";
        int n=S.length();
        int[][] dp=new int[n+1][n+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        for(int i=S.length()-1;i>=0;i--){
            s=s+S.charAt(i);
        }
        return S.length()-solve(S,s,n,n,dp);
    }
}
```

</details>
<details><summary>Adventure in a Maze </summary>
	
		Problem Statement:
		You have got a maze, which is a n*n Grid. Every cell of the maze contains these numbers 1, 2 or 3. 
		If it contains 1 : means we can go Right from that cell only.
		If it contains 2 : means we can go Down from that cell only.
		If it contains 3 : means we can go Right and Down to both paths from that cell.
		We cant go out of the maze at any time.
		Initially, You are on the Top Left Corner of The maze(Entry). And, You need to go to the Bottom Right Corner of the Maze(Exit).
		You need to find the total number of paths from Entry to Exit Point.
		There may be many paths but you need to select that path which contains the maximum number of Adventure.
		The Adventure on a path is calculated by taking the sum of all the cell values thatlies in the path.

[Practice Link](https://practice.geeksforgeeks.org/problems/adventure-in-a-maze2051/1)
```java
class Solution
{
    public int mod=1000000007;
    public boolean isPossible(int[][] matrix,int i,int j){
        if(i>=0 && i<matrix.length && j>=0 && j<matrix.length){
            return true;
        }
        return false;
    }
    public int solve(int[][] matrix,int i,int j,int[][] dp){
        if(!isPossible(matrix,i,j)) return Integer.MIN_VALUE;
        if(i==matrix.length-1 && j==matrix.length-1){
            return matrix[i][j];
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(matrix[i][j]==1){
            dp[i][j]=solve(matrix,i,j+1,dp)+1;
        }
        else if(matrix[i][j]==2){
            dp[i][j]=solve(matrix,i+1,j,dp)+2;
        }
        else {
            dp[i][j]=Math.max(solve(matrix,i+1,j,dp),solve(matrix,i,j+1,dp))+3;
        }
        return dp[i][j];
        
        
    }
    public int count(int[][] matrix,int i,int j,int[][] dp){
        if(!isPossible(matrix,i,j)) return 0;
        if(i==matrix.length-1 && j==matrix.length-1) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(matrix[i][j]==1){
            dp[i][j]=count(matrix,i,j+1,dp)%mod;
        }
        else if(matrix[i][j]==2){
            dp[i][j]=count(matrix,i+1,j,dp)%mod;
        }
        else{
            dp[i][j]=(count(matrix,i,j+1,dp)%mod+count(matrix,i+1,j,dp)%mod)%mod;
        }
        return dp[i][j];
    }
    public int[] FindWays(int[][] matrix)
    {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        int max=solve(matrix,0,0,dp);
        int[][] dp2=new int[n][n];
        for(int[] d:dp2){
            Arrays.fill(d,-1);
        }
        int count=count(matrix,0,0,dp2);
        if(max<0) max=0;
        return new int[]{count,max};
        
    }
}
```
</details>
<details><summary>Nodes at even distance </summary>
	
		Problem Statement:
		Given a connected acyclic graph with n nodes and n-1 edges,
		count the pair of nodes that are at even distance(number of edges) from each other.
		Medium
[Practice Link](https://practice.geeksforgeeks.org/problems/nodes-at-even-distance0532/1)
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
       // System.out.println("a ="+a+" b="+b);
        int count=(a*(a-1)/2)+(b*(b-1)/2);
        return count;
    }
}
```
</details>
<details><summary>Maximum Product of Increasing Subsequence of Size 3</summary>
	
	Problem Statement:
	Given a sequence of non-negative integers, find the subsequence of length 3 having maximum product, 
  	with the elements of the subsequence being in increasing order.
	April-1-2022
	Medium
	
[Practice Link](https://practice.geeksforgeeks.org/problems/maximum-product-of-increasing-subsequence-of-size-32027/1)
```java
class Solution{
    
   
    public static ArrayList<Integer> maxProductSubsequence (int arr[], int n) {
       
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(-1);
        int[] right=new int[n];
        long max=0;
        TreeSet<Integer> set=new TreeSet<>();
        right[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            right[i]=Math.max(arr[i],right[i+1]);
        }
        set.add(arr[0]);
        for(int i=1;i<n-1;i++){
            Integer val=set.floor(arr[i]-1);
            if(val!=null && right[i+1]>arr[i] && ((long)arr[i])*val*right[i+1]>max){
                max=((long)arr[i])*val*right[i+1];
                ans.clear();
                ans.add(val);
                ans.add(arr[i]);
                ans.add(right[i+1]);
            }
            set.add(arr[i]);
        }
        return ans;
    }
}

```

</details>

