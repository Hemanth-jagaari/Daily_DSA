# Recursion and Backtracking practice questions
<details><summary>1.Sort Array using recursion(insertion sort)</summary>
  
    Problem Statement:
    Sort the given array using Recursion
    Solution Approach:
    Think of solving smaller input 
    ex: consider array of size n sort(arr 0 to n-1) the arr till n-1 and insert the nth elemnt in the correct place
    think insert also can be done recursively as array sorted till n-1 the nth element can be inserted at particular position by reducing size 
    comparing last elemnt stop when last elemnt is less than equal to nth number it can be clear from code below 
    the approch is only to understand recursion time complexity is more than nlogn in this 
[Practice Link](https://practice.geeksforgeeks.org/problems/sort-the-array0055/1)
```java
public class Main {
    
    public static void sort(int[] arr,int n){
        if(n==-1){
            return;
        }
        int temp=arr[n];
        sort(arr,n-1);
        insert(arr,n-1,temp);
        
    }
    public static void insert(int[] arr,int n,int temp){
        if(n==-1 || arr[n]<=temp){
            arr[n+1]=temp;
            return;
        }
        int val=arr[n];
        insert(arr,n-1,temp);
        arr[n+1]=val;
    }
     public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String[] s=br.readLine().split(" ");
        int[] arr=new int[n];
        int i=0;
        for(String val:s){
            arr[i++]=Integer.parseInt(val);
        }
        sort(arr,n-1);
     }                           
 }
```
</details>
<details><summary>2.Sort a stack using recursion</summary>
  
    Problem Statement:
    Sort given Stack using recursion
    Solution Approach:
    Think of solving by reducing size and insert the top elemnt  in correct order
    similar to above sort array problem.
[Practice Link](https://practice.geeksforgeeks.org/problems/sort-a-stack/1)
```java
public class Main {
    public static void sort_stk(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int temp=stack.peek();
        stack.pop();
        sort_stk(stack);
        insert_stk(stack,temp);
    }
    public static void insert_stk(Stack<Integer> stack,int temp){
        if(stack.isEmpty() || stack.peek()<=temp){
            stack.push(temp);
            return;
        }
        int val=stack.peek();
        stack.pop();
        insert_stk(stack,temp);
        stack.push(val);
        
    }
  }
```
</details>
<details><summary>3.Delete middle element of stack</summary>
  
    Problem Statement:
    Given stack delete the middle element of stack using recursion 
    middle element k=size/2 +1
    Solution Approach:
    reduce the size untill k=1 and pop the element and add all the elements
[Practice Link](https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1/)
```java
class Main{
  public static void delete_middle(Stack<Integer> stack,int k){
        if(k==1){
            stack.pop();
            return;
        }
        int temp=stack.peek();
        stack.pop();
        delete_middle(stack,k-1);
        stack.push(temp);
        return;
    }
  }
```

</details>
<details><summary>4.Reverse stack</summary>
  
    Problem Statement:
    Reverse the Stack using recursion
    Solution Approach:
    similar to above problems reduce input and place the current elemnt  to last of reversed stack 
    insert_last also recursion
[Practice Link](https://practice.geeksforgeeks.org/problems/reverse-a-stack/1/)
```java
class Main{
      public static void reverse(Stack<Integer> stack){
        if(stack.size()==1){
            return;
        }
        int temp=stack.peek();
        stack.pop();
        reverse(stack);
        insert_last(stack,temp);
        return;
    }
    public static void insert_last(Stack<Integer> stack,int val){
        if(stack.isEmpty()){
            stack.push(val);
            return;
        }
        int temp=stack.peek();
        stack.pop();
        insert_last(stack,val);
        stack.push(temp);
        return;
    }
  }
```
</details>
<details><summary>5.Kth symbol in grammer</summary>
</details>
<details><summary>6.Towers of hanoi</summary>
</details>
<details><summary>7.print subsets/subsequences(string)</summary>
</details>
<details><summary>8.unique subsets</summary>
</details>
<details><summary>9.permutations</summary>
</details>
<details><summary>10.permutation with space</summary>
</details>
<details><summary>11.permutations with case change</summary>
</details>
<details><summary>12.Letter case  permutations</summary>
</details>
<details><summary>13.Generate all balanced parenthesis</summary>
</details>
<details><summary>14.N bit binary numbers</summary>
</details>
<details><summary>15.Josephus problem</summary>
</details>
<details><summary>16.Combination sum</summary>
</details>
<details><summary>17.Combination sum 2</summary>
</details>
<details><summary>18.Subset Sum 1</summary>
</details>
<details><summary>19.Subset sum 2</summary>
</details>
<details><summary>20.Palindrome partitioning</summary>
</details>
<details><summary>21.Rat in maze</summary>
</details>
<details><summary>22.N-Queens</summary>
</details>
<details><summary>23. Sudoko Solver</summary>
</details>
<details><summary>24.M-Coloring Problem</summary>
</details>
<details><summary>25.Permutation Sequence</summary>
</details>
