/*
    Video explanation: https://youtu.be/8By2IvqOhMI
*/


class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {        
        if (root == null) {
            return new TreeNode(val);
        }
        
        if (val > root.val) {
            root.right = insertIntoBST(root.right,val);
        }
        else if (val < root.val) {
            root.left = insertIntoBST(root.left,val);            
        }
        
        return root;
    }
}

