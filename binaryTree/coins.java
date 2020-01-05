/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution{
    private int num;
    
    public int distributeCoins(TreeNode root){
        moves(root);
        return num;
    }
    
    public int moves(TreeNode root){
        if(root == null){
            return 0;
        }
        else{
            int l = moves(root.left);
            int r = moves(root.right);
            num += Math.abs(l) + Math.abs(r) + root.val - 1;
            return l + r + root.val - 1;
        }
    }
}
