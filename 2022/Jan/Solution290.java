//Leetcode 17-Jan-2022
/*
----------------------------------------------------------------290. Word Pattern-----------------------------------------------------------
Easy

3391

388

Add to List

Share
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

 

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false
 

Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
*/
class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] arr=s.split(" ");
        HashMap<Character,String> map=new HashMap<>();
        if(arr.length!=pattern.length()) return false;
        for(int i=0;i<pattern.length();i++){
            char ch=pattern.charAt(i);
            //System.out.println("ch ="+ch+"string ="+arr[i]);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(arr[i])) return false;   
            }
            else{
                if(map.containsValue(arr[i])) return false;
                map.put(ch,arr[i]);
                
            }
        }
        return true;
    }
}