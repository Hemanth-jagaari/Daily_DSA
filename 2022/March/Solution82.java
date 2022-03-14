//Leetcode 9-March-2022
/*
Problem Statement:
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list. Return the linked list sorted as well.

Leetcode Daily challenge March-9-2022

Example 1:


Input: head = [1,2,3,3,4,4,5]
1->2->3->3->4->4->5
Output: [1,2,5]
Example 2:

Input: head = [1,1,1,2,3]
1->1->1->2->3
Output: [2,3]
 

Constraints:

The number of nodes in the list is in the range [0, 300].
-100 <= Node.val <= 100
The list is guaranteed to be sorted in ascending order.

Link:https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
idea: idea is to think like condiser current element compare its value with previous and next node it not equlas to previous and next node values
add to the ans list we are building 



**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode lastprev=new ListNode(-1);
        ListNode ans=lastprev;
        ListNode prev=head;
        ListNode temp=head;
       
        prev=new ListNode(-1);
        while(temp.next!=null){
            if(prev.val!=temp.val && temp.val!=temp.next.val){
                ListNode nxt=temp.next;
                lastprev.next=temp;
                lastprev=temp;
                
                prev=temp;
                temp.next=null;
                temp=nxt;
            }
            else{
                prev=temp;
                temp=temp.next;
            }
        }
        if(prev.val!=temp.val){
            lastprev.next=temp;
        }
        if(head.val==-1 && head.next.val!=-1){
            return ans;
        }
        return ans.next;
        
    }
}