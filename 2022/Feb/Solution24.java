//Leetcode 16-Feb-2022
/*
-------------------------------------------------------24. Swap Nodes in Pairs--------------------------------------------
Medium

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
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
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode temp=head;
        ListNode start=new ListNode(-1);
        ListNode res=start;
        while(temp!=null && temp.next!=null){
            ListNode next=temp.next.next;
            temp.next.next=null;
            start.next=temp.next;
            start=start.next;
            temp.next=null;
            start.next=temp;
            start=start.next;
            temp=next;
        }
        if(temp!=null) start.next=temp;
        return res.next;
    }
}