## Weekly Contest 287
<details><summary>Minimum Number of Operations to Convert Time</summary>
  
    Problem Statement:
    You are given two strings current and correct representing two 24-hour times.

    24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. 
    The earliest 24-hour time is 00:00, and the latest is 23:59.

    In one operation you can increase the time current by 1, 5, 15, or 60 minutes. 
    You can perform this operation any number of times.

    Return the minimum number of operations needed to convert current to correct.
```java
class Solution {
    public int convertTime(String current, String correct) {
        int h1=Integer.parseInt(current.substring(0,2));
        int m1=Integer.parseInt(current.substring(3,5));
        int h2=Integer.parseInt(correct.substring(0,2));
        int m2=Integer.parseInt(correct.substring(3,5));
        int diff=Math.abs(h1-h2)*60+m2-m1;
        int count=0;
        count+=diff/60;
        diff=diff%60;
        count+=diff/15;
        diff=diff%15;
        count+=diff/5;
        diff=diff%5;
        count+=diff;
        return count;
    }
}
```

</details>
<details><summary>Find Players With Zero or One Losses</summary>
  
    Problem Statement:
    you are given an integer array matches 
    where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.

    Return a list answer of size 2 where:

    answer[0] is a list of all players that have not lost any matches.
    answer[1] is a list of all players that have lost exactly one match.
    The values in the two lists should be returned in increasing order.
```java
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> loss=new HashSet<>();
        Set<Integer> won=new HashSet<>();
        Set<Integer> onloss=new HashSet<>();
        for(int[] m:matches){
            won.add(m[0]);
            if(won.contains(m[1])) won.remove(m[1]);
            
            if(onloss.contains(m[1])){
                onloss.remove(m[1]);
                loss.add(m[1]);
            }
            else if(!onloss.contains(m[1]) && !loss.contains(m[1])){
                onloss.add(m[1]);
                
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ans1=new ArrayList<>();
        List<Integer> ans2=new ArrayList<>();
        for(int val:won){
            if(!onloss.contains(val) && !loss.contains(val)) ans1.add(val);
        }
        for(int val:onloss){
            ans2.add(val);
        }
        Collections.sort(ans1);
        Collections.sort(ans2);
        ans.add(ans1);
        ans.add(ans2);
        return ans;
    }
}
```
</details>
<details><summary>Maximum Candies Allocated to K Children</summary>
  
    Problem Statement:
    You are given a 0-indexed integer array candies. 
    Each element in the array denotes a pile of candies of size candies[i]. 
    You can divide each pile into any number of sub piles, but you cannot merge two piles together.

    You are also given an integer k. 
    You should allocate piles of candies to k children such that each child gets the same number of candies. 
    Each child can take at most one pile of candies and some piles of candies may go unused.

    Return the maximum number of candies each child can get.
```java
class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low=1,high=1;
        for(int val:candies){
            high=Math.max(high,val);
        }
        while(low<high){
            int mid=(low+high)/2;
            if(isPossible(candies,k,mid)){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        //System.out.println("low="+low+" high="+high);
        return isPossible(candies,k,low)?low:low-1;
    }
    public boolean isPossible(int[] arr,long k,int mid){
        long count=0;
        for(int val:arr){
            count+=val/mid;
            if(count>=k) return true;
        }
        
        return false;
    }
}
```
  
  
</details>
<details><summary>Encrypt and Decrypt Strings</summary>
  
    Problem Statement:
    You are given a character array keys containing unique characters and a string array values containing strings of length 2. 
    You are also given another string array dictionary that contains all permitted original strings after decryption. 
    You should implement a data structure that can encrypt or decrypt a 0-indexed string.

    A string is encrypted with the following process:

    For each character c in the string, we find the index i satisfying keys[i] == c in keys.
    Replace c with values[i] in the string.
    Note that in case a character of the string is not present in keys, the encryption process cannot be carried out, and an empty string "" is returned.

    A string is decrypted with the following process:

    For each substring s of length 2 occurring at an even index in the string, we find an i such that values[i] == s. 
    If there are multiple valid i, we choose any one of them. This means a string could have multiple possible strings it can decrypt to.
    Replace s with keys[i] in the string.
    Implement the Encrypter class:

    Encrypter(char[] keys, String[] values, String[] dictionary) Initializes the Encrypter class with keys, values, and dictionary.
    String encrypt(String word1) Encrypts word1 with the encryption process described above and returns the encrypted string.
    int decrypt(String word2) Returns the number of possible strings word2 could decrypt to that also appear in dictionary.
```java
```
</details>
