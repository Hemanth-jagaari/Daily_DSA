
## GFG Problem of the Day<br>
# It contains some interesting pracice questions of MEdium and HaRd LEvel.
<details><summary>Maximum Product of Increasing Subsequence of Size 3</summary>
	
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
