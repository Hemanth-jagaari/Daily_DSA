
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
<details><summary>Find the Maximum Flow</summary>
</details>
<details><summary>Longest substring to form a Palindrome </summary>
</details>
<details><summary>Closest Palindrome </summary>

	Problem Statement:
	Given a number num, our task is to find the closest Palindrome number whose absolute difference with given number is minimum. 
	If 2 Palindome numbers have same absolute difference from the given number, then find the smaller one.
[Practice Link](https://practice.geeksforgeeks.org/problems/closest-palindrome4519/1#)
```java
class Solution
{
    public long reverse(long n){
        long sum=0;
        while(n>0){
            sum=sum*10 + n%10;
            n=n/10;
        }
        return sum;
    }
    public long closestPalindrome(long num)
    {
        if(num<=9) return num;
        int c=0;
        long k=num;
        while(k>0){
            c++;
            k=k/10;
        }
        List<Long> ans=new ArrayList<>();
        ans.add((long)Math.pow(10,c)+1);
        ans.add((long)Math.pow(10,c)-1);
        ans.add((long)Math.pow(10,c-1)+1);
        ans.add((long)Math.pow(10,c-1)-1);
        
        long mid=(c+1)/2;
        long prefix=num/(long)Math.pow(10,c-mid);
        long[] arr=new long[]{prefix-1,,prefix,prefix+1};
        for(long val:arr){
            long sufix=val;
            if(c%2!=0) sufix=sufix/10;
            sufix=reverse(sufix);
            long res=val*(long)Math.pow(10,c-mid) +sufix;
            ans.add(res);
        }
        long mindiff=Long.MAX_VALUE;
        long min=num;
        for(long val:ans){
            if(Math.abs(num-val)<mindiff){
                mindiff=Math.abs(num-val);
                min=val;
            }
            else if(Math.abs(num-val)==mindiff){
                min=Math.min(val,min);
            }
        }
        return min;
        
    }
}
```
 
</details>
<details><summary>Word Wrap</summary></details>
<details><summary>Maximum sum Rectangle</summary></details>
<details><summary>Negative weight cycle</summary></details>
<details><summary>Geek in a Maze</summary></details>
<details><summary>Product of Primes </summary>

	Problem Statement:
	Given two numbers L and R (inclusive) find the product of primes within this range. 
	Print the product modulo 109+7. If there are no primes in that range you must print 1.
[Practice Link](https://practice.geeksforgeeks.org/problems/product-of-primes5328/1#)
```java
class Solution{
    static long primeProduct(long L, long R){
        boolean[] arr=new boolean[(int)(R-L+1)];
        
        Arrays.fill(arr,true);
        long sqrt=(long)Math.sqrt(R);
        boolean[] pre=new boolean[(int)(sqrt)+1];
        Arrays.fill(pre,true);
        pre[0]=false;
        pre[1]=false;
        for(int i=2;i<=sqrt;i++){
            if(pre[i]==true){
                for(int j=i*i;j<=sqrt;j+=i){
                    pre[j]=false;
                }
            }
        }
       // System.out.println("sqrt ="+sqrt);
        for(long i=2;i<=sqrt;i++){
            if(pre[(int)i]==true){
                long frst=(L/i)*i;
                if(frst<L) frst+=i;
                for(long j=Math.max(i*i*1L,frst);j<=R;j+=i){
                if(j-L>=0)
                arr[(int)(j-L)]=false;
            }
            }
            
        }
        long pro=1;
        long mod=1000000007;
        if(L==1) arr[0]=false;
        for(long i=L;i<=R;i++){
            if(arr[(int)(i-L)]==true){
                pro=((pro%mod)*(i%mod))%mod;
            }
        }
        
        return pro;
    }
}
```
</details>
<details><summary>Pairs of Non Coinciding Points </summary>
	
	Problem Statement:
	In a given cartesian plane, there are N points. We need to find the Number of Pairs of  points(A, B) such that

	Point A and Point B do not coincide.
	Manhattan Distance and the Euclidean Distance between the points should be equal.
	Note: Pair of 2 points(A,B) is considered same as Pair of 2 points(B ,A).
	Manhattan Distance = |x2-x1|+|y2-y1|
	Euclidean Distance   = ((x2-x1)^2 + (y2-y1)^2)^0.5, where points are (x1,y1) and (x2,y2).
[Practice Link](https://practice.geeksforgeeks.org/problems/pairs-of-non-coinciding-points4141/1#)
```java
class Solution {
    static int numOfPairs(int[] X, int[] Y, int N) {
        int c1=0;
        int c2=0;
        int c3=0;
        HashMap<Integer,Integer> a=new HashMap<>();
        HashMap<Integer,Integer> b=new HashMap<>();
        HashMap<ArrayList<Integer>,Integer> ab=new HashMap<>();
        for(int i=0;i<N;i++){
            c1+=a.getOrDefault(X[i],0);
            a.put(X[i],a.getOrDefault(X[i],0)+1);
            c2+=b.getOrDefault(Y[i],0);
            b.put(Y[i],b.getOrDefault(Y[i],0)+1);
            ArrayList<Integer> arr=new ArrayList<>();
            arr.add(X[i]);
            arr.add(Y[i]);
            
            c3+=ab.getOrDefault(arr,0);
            ab.put(arr,ab.getOrDefault(arr,0)+1);
        }
        return c1+c2-2*c3;
          
    }
}
```
</details>
<details><summary>Queries on Strings</summary>
	
	Problem Statement:
	Given a string str you have to answer several queries on that string. 
	In each query you will be provided two values L and R and you have to find the 
	number of distinct characters in the sub string from index L to index R (inclusive) of the original string.

[Practice Link](https://practice.geeksforgeeks.org/problems/queries-on-strings5636/1#)
```java
class Solution
{
    public int[] SolveQueris(String str, int[][] Query)
    {
        int n=str.length();
        int[][] dp=new int[n][26];
        for(int i=0;i<n;i++){
            if(i==0) dp[i][str.charAt(i)-'a']++;
            else{
                for(int j=0;j<26;j++) dp[i][j]=dp[i-1][j];
                dp[i][str.charAt(i)-'a']++;
            }
        }
        int m=Query.length;
        int[] ans=new int[m];
        for(int i=0;i<m;i++){
            int l=Query[i][0]-1;
            int r=Query[i][1]-1;
            int c=0;
            for(int j=0;j<26;j++){
                if(l==0) c+=dp[r][j]>0?1:0;
                else c+=(dp[r][j]-dp[l-1][j])>0?1:0;
            }
            ans[i]=c;
        }
        return ans;
        
    }
}
```
	
	

</details>
