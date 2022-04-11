## Weekly Contest 288
<details><summary>Largest Number After Digit Swaps by Parity</summary>
  
    You are given a positive integer num. You may swap any two digits of num that have the same parity 
    (i.e. both odd digits or both even digits).

    Return the largest possible value of num after any number of swaps.
```java
class Solution {
    public int largestInteger(int num) {
        List<Integer> even=new ArrayList<>();
        List<Integer> odd=new ArrayList<>();
        int k=num;
        while(k>0){
            int r=k%10;
            if(r%2==0) even.add(r);
            else odd.add(r);
            k=k/10;
        }
        Collections.sort(even);
        Collections.sort(odd);
        int i=0,j=0;
        int sum=0;
        k=num;
        while(k>0){
            int r=k%10;
            if(r%2==0){
                sum=sum*10+even.get(j++);
            }
            else{
                sum=sum*10+odd.get(i++);
            }
            k=k/10;
        }
        k=sum;
        //System.out.println("sum="+sum);
        sum=0;
        while(num>0){
            sum=sum*10+k%10;
            k=k/10;
            num=num/10;
        }
        return sum;
        
    }
}
```


</details>
<details><summary>Minimize Result by Adding Parentheses to Expression</summary></details>
<details><summary>Maximum Product After K Increments</summary>
  
    You are given an array of non-negative integers nums and an integer k. 
    In one operation, you may choose any element from nums and increment it by 1.

    Return the maximum product of nums after at most k operations. 
    Since the answer may be very large, return it modulo 109 + 7.
```java
class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> que=new PriorityQueue<>();
        int mod=1000000007;
        for(int val:nums){
            que.add(val);
        }
        while(k>0){
            int top=que.poll();
            que.add(top+1);
            k--;
        }
        long multi=1;
        while(!que.isEmpty()){
            multi=((multi%mod)*que.poll())%mod;
        }
        return (int)multi%mod;
    }
}
```
</details>
<details><summary>Maximum Total Beauty of the Gardens</summary></details>
