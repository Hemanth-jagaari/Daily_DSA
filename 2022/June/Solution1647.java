//Leetcode 28-June-2022
/*
-----------------------------------------1647. Minimum Deletions to Make Character Frequencies Unique---------------------------------------
Medium

A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example, in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1.

 

Example 1:

Input: s = "aab"
Output: 0
Explanation: s is already good.
Example 2:

Input: s = "aaabbbcc"
Output: 2
Explanation: You can delete two 'b's resulting in the good string "aaabcc".
Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
Example 3:

Input: s = "ceabaacb"
Output: 2
Explanation: You can delete both 'c's resulting in the good string "eabaab".
Note that we only care about characters that are still in the string at the end (i.e. frequency of 0 is ignored).
 

Constraints:

1 <= s.length <= 105
s contains only lowercase English letters.
*/
class Solution1647 {
    class Pair{
        char ch;
        int count;
        Pair(char c,int n){
            ch=c;
            count=n;
        }
    }
    public int minDeletions(String s) {
        int[] arr=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            arr[s.charAt(i)-'a']++;
        }
        ArrayList<Pair> lst=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(arr[i]>0){
                lst.add(new Pair((char)(arr[i]+'a'),arr[i]));
            }
        }
        Collections.sort(lst,(a,b)->{
            return b.count-a.count;
        });
        HashSet<Integer> set=new HashSet<>();
        int count=0;
        for(int i=0;i<lst.size();i++){
            char c=lst.get(i).ch;
            int m=lst.get(i).count;
            if(set.contains(m)){
               // count+=1;
                int freq=m;
                while(freq!=0 && set.contains(freq)){
                    count+=1;
                    freq--;
                }
                if(freq!=0) set.add(freq);
            }
            else  set.add(m);
        }
        return count;
    }
}