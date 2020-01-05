/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findTilt(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 0;
        }
        // if(root.left == null){
        //     int sum = 0;
        //     sum += findTiltNum(root) + findTiltNum(root.left);
        //     return sum;
        // }
        // if(root.right == null){
        //     int sum = 0;
        //     sum += findTiltNum(root) + findTiltNum(root.right);
        //     return sum;
        // }
        else{
            int sum = 0;
            sum += findTiltNum(root) + findTiltNum(root.left) + findTiltNum(root.right);
            return sum;
        }
    }   
    
    public int findTiltNum(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.right == null && root.left == null){
            return 0;
        }
        if(root.left == null){
            return root.right.val + sum(root.right);
        }
        else if(root.right == null){
            return root.left.val + sum(root.left);
        }
        else{
            return Math.abs((root.right.val + sum(root.right)) - (sum(root.left) + root.left.val));
        }
    }

    public int sum(TreeNode root){
    	if(root == null){
    		return 0;
    	}
    	if(root.left == null && root.right == null){
    		return 0;
    	}
    	if(root.left == null){
    		return root.right.val + sum(root.right);
    	}
    	if(root.right == null){
    		return root.left.val + sum(root.left);
    	}
    	else{
    		return root.left.val + sum(root.left) + root.right.val + sum(root.right);
    	}
    }
}
