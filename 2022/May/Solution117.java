//LeetCode 13-May-2022
/*
---------------------------------------------------117. Populating Next Right Pointers in Each Node II------------------------------------------------------
Medium
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Example 1:


Input: root = [1,2,3,4,5,null,7]
Output: [1,#,2,3,#,4,5,7,#]
Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
Example 2:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 6000].
-100 <= Node.val <= 100
*/
class Solution117 {
    public Node connect(Node root) {
        if(root==null) return root;
        Queue<Node> que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            Node curr=que.remove();
            if(curr.left!=null) que.add(curr.left);
            if(curr.right!=null) que.add(curr.right);
            for(int i=1;i<size;i++){
                Node temp=que.remove();
                curr.next=temp;
                curr=temp;
                if(temp.left!=null) que.add(temp.left);
                if(temp.right!=null) que.add(temp.right);
            }
        }
        return root;
        
    }
}