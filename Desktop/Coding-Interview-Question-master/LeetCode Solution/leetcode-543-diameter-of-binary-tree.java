/*
  Video explanation: https://youtu.be/zvT2iiDzpuk
*/
class Solution {
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans;
    }
    public int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L + R);
        return 1 + Math.max(L, R);
    }
}
