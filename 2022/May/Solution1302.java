//LeetCode 15-May-2022
/*
--------------------------------------------1302. Deepest Leaves Sum-----------------------------------------------------------------------------------
Medium

Given the root of a binary tree, return the sum of values of its deepest leaves.
 

Example 1:


Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
Example 2:

Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
Output: 19
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
1 <= Node.val <= 100
*/
class Solution1302 {
    public int deepestLeavesSum(TreeNode root) {
        int sum=0;
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            sum=0;
            for(int j=0;j<size;j++){
                TreeNode curr=que.poll();
                if(curr.left!=null) que.add(curr.left);
                if(curr.right!=null) que.add(curr.right);
                sum+=curr.val;
            }
        }
        return sum;
        
    }
}