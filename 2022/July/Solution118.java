//Leetcode 19-July-2022
/*
--------------------------------------118. Pascal's Triangle -------------------------------------------------------------------
Easy


Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30
*/
class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> one=new ArrayList<>();
        one.add(1);
        res.add(one);
        for(int i=1;i<numRows;i++){
            List<Integer> temp=new ArrayList<>();
            temp.add(1);
            List<Integer> prev=res.get(i-1);
            for(int j=1;j<prev.size();j++){
                temp.add(prev.get(j-1)+prev.get(j));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }
}