//Leetcode 13-April-2022
/*
--------------------------------------------------------59. Spiral Matrix II-------------------------------------------------------
Medium

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

Example 1:


Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]
Example 2:

Input: n = 1
Output: [[1]]
 

Constraints:

1 <= n <= 20
Solution Approach:
need to move in four direction d=0 left to right d=1 top to bottom and d=2 right to left and d=3 bottom to top 
maintain corresponding values of left right top left and change of each direction.
*/
class Solution59{
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int top=0,bottom=n-1,left=0,right=n-1;
        int dir=0;
        int num=1;
        while(top<=bottom && left<=right){
             if(dir==0){
                for(int i=left;i<=right;i++){
                    matrix[top][i]=num++;
                }
                top++;
            }
            else if(dir==1){
                for(int i=top;i<=bottom;i++){
                    matrix[i][right]=num++;
                }
                right--;
            }
            else if(dir==2){
                for(int i=right;i>=left;i--){
                    matrix[bottom][i]=num++;
                }
                bottom--;
            }
            else if(dir==3){
                for(int i=bottom;i>=top;i--){
                    matrix[i][left]=num++;
                }
                left++;
            }
            dir=(dir+1)%4;
        }
        return matrix;
    }
}