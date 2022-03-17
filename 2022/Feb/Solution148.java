//Leetcode 24-Feb-2022
/*
--------------------------------------------------148. Sort List-----------------------------------------------------------------
Medium

Given the head of a linked list, return the list after sorting it in ascending order.

 

Example 1:


Input: head = [4,2,1,3]
Output: [1,2,3,4]
Example 2:


Input: head = [-1,5,3,4,0]
Output: [-1,0,3,4,5]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is in the range [0, 5 * 104].
-105 <= Node.val <= 105
 
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
class Solution148 {
    public ListNode mergesort(ListNode start){
        if(start==null || start.next==null) return start;
        ListNode slow=start;
        ListNode fast=start;
        ListNode prev=null;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
            
        }
        prev.next=null;
        ListNode left=mergesort(start);
        ListNode right=mergesort(slow);
        return merge(left,right);
    }
    public ListNode merge(ListNode left,ListNode right){
        if(left==null) return right;
        if(right==null) return left;
        ListNode temp=new ListNode(-1);
        ListNode res=temp;
        while(left!=null && right!=null){
            if(left.val<right.val){
                temp.next=left;
                left=left.next;
                temp=temp.next;
            }
            else{
                temp.next=right;
                right=right.next;
                temp=temp.next;
            }
        }
        if(left==null){
            temp.next=right;
        }
        if(right==null){
            temp.next=left;
        }
        return res.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        return mergesort(head);
    }
}