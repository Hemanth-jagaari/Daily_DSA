//Leetcode 23-Jan-2022
/*
--------------------------------------------------1291. Sequential Digits------------------------------------------------------------
Medium

1574

98

Add to List

Share
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]
Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]
 

Constraints:

10 <= low <= high <= 10^9
*/
class Solution1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> res=new ArrayList<>();
        String s="123456789";
        String a=low+"";
        String b=high+"";
        for(int i=a.length();i<=b.length();i++){
            for(int j=0;j+i<s.length()+1;j++){
                String sub=s.substring(j,j+i);
                //System.out.println("string ="+sub);
                int temp=Integer.parseInt(s.substring(j,j+i));
                if(temp<low) continue;
                else if(temp>=low && temp<=high){
                    res.add(temp);
                }
                else break;
            }
        }
        return res;
        
    }
}
