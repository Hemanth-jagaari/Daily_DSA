//Leetcode 11-March-2022
/*  
--------Rotate List-------
Given the head of a linked list, rotate the list to the right by k places.

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:


Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
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
class Solution61 {
    public ListNode rotate(ListNode head){
        ListNode start=head;
        ListNode temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        ListNode last=temp.next;
        temp.next=null;
        last.next=start;
        return last;
    } 
    public ListNode rotateRight(ListNode head, int k) {
        int n=0;
        if(head==null) return null;
        ListNode temp=head;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        temp=head;
        k=k%n;
        for(int i=0;i<k;i++){
           head=rotate(temp);
            temp=head;
        }
        return head;
    }
}