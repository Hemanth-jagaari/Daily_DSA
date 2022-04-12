//Leetcode 12-April-2022
/*
---------------------------------------------289. Game of Life--------------------------------------------------------
Medium

According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

 

Example 1:


Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Example 2:

Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.
Solution Approach:
main challenge when we iterating we have to change the status of each value if it changes from 0 to 1 or 1 to 0
so it makes the cells calculation difficult as we change instead changing to 0 or 1 we change them to 
other values like if next state turn to 1 replace it with 3 or next state turns to 0 replace it with 2
this helps to calculate all cell neighbour living and after done with we change all 3 to 1 and all 2 to 0.
*/
class Solution289 {
    public int ones(int[][] arr,int i,int j,int n,int m){
        int one=0;
        for(int x=i-1;x<i+2;x++){
            for(int y=j-1;y<j+2;y++){
                if(x<0 || x>=n|| y<0 || y>=m ||(x==i &&  y==j )) continue;
                else{
                    if(arr[x][y]==1 || arr[x][y]==2) one++;
                }
            }
        }
        return one;
    }
    public void gameOfLife(int[][] board) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int c=ones(board,i,j,n,m);
                if(board[i][j]==1){
                    if(c<2 || c>3) board[i][j]=2;
                }
                else{
                    if(c==3) board[i][j]=3;
                }
            }
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(board[i][j]==2) board[i][j]=0;
                else if(board[i][j]==3) board[i][j]=1;

    }
}