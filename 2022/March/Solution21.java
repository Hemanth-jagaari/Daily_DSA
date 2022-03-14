//Leetcode 7-March-2022
/*
---------------------------------------------------------Merge two sorted linked list-------------------------------
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

 

Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
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
class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res=new ListNode();
        ListNode temp=res;
        ListNode a=list1;
        ListNode b=list2;
        while(a!=null && b!=null){
            if(a.val<=b.val){
                ListNode newnode=new ListNode(a.val);
                res.next=newnode;
                res=newnode;
                a=a.next;
            }
            else{
                ListNode newnode=new ListNode(b.val);
                res.next=newnode;
                res=newnode;
                b=b.next;
            }
        }
        if(a!=null){
            res.next=a;
        }
        if(b!=null){
            res.next=b;
        }
        return temp.next;
    }
}