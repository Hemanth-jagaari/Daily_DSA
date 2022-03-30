//Leetcode 30-March-2022
/*
----------------------------------------74. Search a 2D Matrix---------------------------------------------------------------------------
Medium

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104

Idea: think the matrix is sorted when flatten it it form single soted array and binary search on it find row and coulum by dividing with no of cols 
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        Method-1
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            if(target>=matrix[i][0] && target<=matrix[i][m-1]){
                int l=0;
                int r=m-1;
                while(l<=r){
                    int mid=l+(r-l)/2;
                    if(matrix[i][mid]==target) return true;
                    else if(matrix[i][mid]<target){
                        l=mid+1;
                    }
                    else{
                        r=mid-1;
                    }
                }
            }
        }
        return false;
        */
        /*
        Method-2
        int i=0,j=m-1;
        while(i<n && j>=0){
            if(matrix[i][j]==target) return true;
            else if(matrix[i][j]>target) j--;
            else i++;
        }
        return false;
        */
        //Method-3
        int n=matrix.length;
        int m=matrix[0].length;
        int left=0,right=n*m-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            int val=matrix[mid/m][mid%m];
            if(val==target) return true;
            else if(val>target) right=mid-1;
            else left=mid+1;
        }
        return false;
    }
}