//Leetcode 21-July-2022
/*
--------------------------------------------------------92. Reverse Linked List II ---------------------------------------------------
Medium


Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
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
class Solution92 {
    public ListNode reverse(ListNode start,ListNode end){
        ListNode prev=null;
        ListNode curr=start;
        while(curr!=end){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || head.next==null || left==right) return head;
        ListNode first=null;
        ListNode second=null;
        ListNode temp=head;
        int c=0;
        while(temp!=null){
            c++;
            if(c+1==left){
                first=temp;
            }
            if(c==right+1){
                second=temp;
            }
            temp=temp.next;
        }
        if(left==1 && right==c){
            ListNode prev=reverse(head,null);
            return prev;
        }
        if(left==1){
            temp=reverse(head,second);
            head=temp;
        }
        else{
            temp=reverse(first.next,second);
            first.next=temp;
        }
        
        while(temp.next!=null){
            temp=temp.next;
            
        }
        temp.next=second;
        return head;
    }
}