//Leetcode 4-Aprol-2022
/*
--------------------------------------------------1721. Swapping Nodes in a Linked List-------------------------------------------------
Medium

You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
 

Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
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
class Solution1721 {
    public ListNode swapNodes(ListNode head, int k) {
        int n=0;
        ListNode first=null;
        ListNode temp=head;
        while(temp!=null){
            n+=1;
            if(n==k){
                first=temp;
            }
            temp=temp.next;
        }
        int c=0;
        temp=head;
        while(temp!=null && c<(n-k)){
            c++;
            temp=temp.next;
        }
        int v=first.val;
        first.val=temp.val;
        temp.val=v;
        return head;
    }
}