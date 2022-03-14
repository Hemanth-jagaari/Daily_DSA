//Leetcode 10-March-2022
/*
----------------------------------add to numbers-------------------------------
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode start=new ListNode(-1);
        ListNode ans=start;
        ListNode first=l1;
        ListNode second=l2;
        while(first!=null && second!=null){
            int sum=first.val+second.val+carry;
            ListNode newnode=new ListNode(sum%10);
            carry=sum/10;
            start.next=newnode;
            start=newnode;
            first=first.next;
            second=second.next;
        }
        
        while(first!=null){
            int sum=first.val+carry;
            ListNode newnode=new ListNode(sum%10);
            carry=sum/10;
            start.next=newnode;
            start=newnode;
            first=first.next;
        }
        while(second!=null){
            int sum=second.val+carry;
            ListNode newnode=new ListNode(sum%10);
            carry=sum/10;
            start.next=newnode;
            start=newnode;
            second=second.next;
        }
        if(carry!=0){
            ListNode newnode=new ListNode(carry);
            start.next=newnode;
        }
        return ans.next;
    }
}