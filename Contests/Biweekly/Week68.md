## Biweekly Contest 68
<details><summary>Maximum Number of Words Found in Sentences</summary>

    A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
    You are given an array of strings sentences, where each sentences[i] represents a single sentence.
    Return the maximum number of words that appear in a single sentence.
```java
  class Solution {
    public int mostWordsFound(String[] sentences) {
        int max=0;
        for(String s:sentences){
            String[] srr=s.split(" ");
            if(srr.length>max){
                max=srr.length;
            }
        }
        return max;
    }
}
```

</details>
<details><summary>Find All Possible Recipes from Given Supplies</summary>
  You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. 
  The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. 
  Ingredients to a recipe may need to be created from other recipes, i.e., ingredients[i] may contain a string that is in recipes.

  You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.
  Return a list of all the recipes that you can create. You may return the answer in any order.

  Note that two recipes may contain each other in their ingredients.

```java
  class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n=recipes.length;
        List<String> ans=new ArrayList<>();
        Set<String> set=new HashSet<>();
        for(String val:supplies) set.add(val);
        int[] mark=new int[n];
        boolean loop=true;
        while(loop==true){
            loop=false;
            for(int i=0;i<n;i++){
            if(mark[i]==1) continue;
            int flag=1;
            for(String val:ingredients.get(i)){
                if(!set.contains(val)){
                    flag=0;
                    break;
                }
            }
            if(flag==1) {
                mark[i]=1;
                set.add(recipes[i]);
                loop=true;
            }
        }
        }
        for(int i=0;i<n;i++){
            if(mark[i]==1) ans.add(recipes[i]);
        }
        
        return ans;
    }
}
```


</details>
<details><summary>Check if a Parentheses String Can Be Valid</summary>
  A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the following conditions is true:
  It is ().
  It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
  It can be written as (A), where A is a valid parentheses string.
  You are given a parentheses string s and a string locked, both of length n. locked is a binary string consisting only of '0's and '1's. For each index i of locked,

  If locked[i] is '1', you cannot change s[i].
  But if locked[i] is '0', you can change s[i] to either '(' or ')'.
  Return true if you can make s a valid parentheses string. Otherwise, return false.
```java
  class Solution {
    public boolean canBeValid(String s, String locked) {
        int n=s.length();
        if(n%2==1) return false;
        int open=0;
        int close=0;
        for(int i=0;i<n;i++){
            if(locked.charAt(i)=='0' || s.charAt(i)=='(') open++;
            else close++;
            if(close>open) return false;
        }
        open=0;
        close=0;
        for(int i=n-1;i>=0;i--){
            if(locked.charAt(i)=='0' || s.charAt(i)==')') open++;
            else close++;
            if(close>open) return false;
        }
        return true;
    }
}
```



</details>
<details><summary>Abbreviating the Product of a Range</summary>
  Soon 
</details>
