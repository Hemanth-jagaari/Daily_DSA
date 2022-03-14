//Leetcode 10-Jan-2022
/*
--------------------------------------------------67. Add Binary------------------------------------------------------------------
Easy

Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
*/
class Solution67 {
    public String addBinary(String a, String b) {
        String res="";
        int carry=0;
        int i=a.length()-1;
        int j=b.length()-1;
        while(i>=0 && j>=0){
            
            int x=a.charAt(i)-'0';
            int y=b.charAt(j)-'0';
            x=x+y+carry;
            if(x==0){
                res='0'+res;
                carry=0;
            }
            else if(x==1){
                res='1'+res;
                carry=0;
            }
            else if(x==2){
                res='0'+res;
                carry=1;
            }
            else if(x==3){
                res='1'+res;
                carry=1;
            }
            i--;
            j--;
        }
        while(i>=0){
            int x=a.charAt(i)-'0';
            x=x+carry;
            if(x==0){
                res='0'+res;
                carry=0;
            }
            else if(x==1){
                res='1'+res;
                carry=0;
            }
            else if(x==2){
                res='0'+res;
                carry=1;
            }
            else if(x==3){
                res='1'+res;
                carry=1;
            }
            i--;
            
        }
         while(j>=0){
            int x=b.charAt(j)-'0';
            x=x+carry;
            if(x==0){
                res='0'+res;
                carry=0;
            }
            else if(x==1){
                res='1'+res;
                carry=0;
            }
            else if(x==2){
                res='0'+res;
                carry=1;
            }
            else if(x==3){
                res='1'+res;
                carry=1;
            }
            j--;
            
        }
        if(carry==1) res='1'+res;
        return res;
        
    }
}