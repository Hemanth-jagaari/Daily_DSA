//Leetcode 14-July-2022
/*
-----------------------------------------------------105. Construct Binary Tree from Preorder and Inorder Traversal ------------------------------------------------
Medium


Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, 
construct and return the binary tree.

 

Example 1:


Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]
Example 2:

Input: preorder = [-1], inorder = [-1]
Output: [-1]
 

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.
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
class Solution105 {
    public TreeNode solve(int[] pre,int s1,int e1,int[] inord,int s2,int e2,HashMap<Integer,Integer> map){
        if(s1>e1) return null;
        TreeNode root=new TreeNode(pre[s1]);
        int index=map.get(pre[s1]);
        int len=index-s2;
        root.left=solve(pre,s1+1,s1+len,inord,s2,index-1,map);
        root.right=solve(pre,s1+len+1,e1,inord,index+1,e2,map);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return solve(preorder,0,n-1,inorder,0,n-1,map);
    }
}