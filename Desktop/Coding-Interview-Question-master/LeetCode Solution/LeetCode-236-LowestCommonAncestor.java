/*
    Contributed by Md. A. Barik
    Video explanation: https://youtu.be/5NXfhnnJIP0
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pathToP = pathToX(root, p);
        Stack<TreeNode> pathToQ = pathToX(root, q);
        if (pathToP == null || pathToQ == null) {
            return null;
        }

        TreeNode lcaToReturn = null;

        while (!pathToP.isEmpty() && !pathToQ.isEmpty()) {
            TreeNode pPop = pathToP.pop();
            TreeNode qPop = pathToQ.pop();
            if (pPop == qPop) {
                lcaToReturn = pPop;
            } else {
                break;
            }
        }
        return lcaToReturn;
    }

    private Stack<TreeNode> pathToX(TreeNode root, TreeNode x) {
        if (root == null) {
            return null;
        }

        if (root.val == x.val) {
            Stack<TreeNode> path = new Stack<TreeNode>();
            path.push(root);
            return path;
        }

        Stack<TreeNode> leftPath = pathToX(root.left, x);
        if (leftPath != null) {
            leftPath.push(root);
            return leftPath;
        }

        Stack<TreeNode> rightPath = pathToX(root.right, x);
        if (rightPath != null) {
            rightPath.push(root);
            return rightPath;
        }

        return null;
    }   
}