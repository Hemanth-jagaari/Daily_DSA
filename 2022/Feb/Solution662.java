//Leetcode 27-Feb-2022
/*
---------------------------------------------------------------662. Maximum Width of Binary Tree----------------------------------------
Medium
Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.

It is guaranteed that the answer will in the range of 32-bit signed integer.

 

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:


Input: root = [1,3,null,5,3]
Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:


Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
 

Constraints:

The number of nodes in the tree is in the range [1, 3000].
-100 <= Node.val <= 100
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        Map<TreeNode,Integer> map=new HashMap<>();
        map.put(root,0);
        que.add(root);
        int max=0;
        while(!que.isEmpty()){
            int size=que.size();
            int left=map.get(que.peek());
            for(int i=0;i<size;i++){ 
                TreeNode curr=que.poll();
                max=Math.max(max,map.get(curr)-left+1);
                if(curr.left!=null){
                    que.add(curr.left);
                    map.put(curr.left,2*map.get(curr));
                }
                if(curr.right!=null){
                    que.add(curr.right);
                    map.put(curr.right,2*map.get(curr)+1);
                }
            }
        }
        return max;
    }
}