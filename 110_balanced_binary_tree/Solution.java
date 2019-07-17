class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
 

class Solution {
    private int calculateHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int height = Math.max(calculateHeight(root.left), calculateHeight(root.right));
        return height+1;
    }

    private int calculateDifference(TreeNode node) {
        int height_leftTree = calculateHeight(node.left);
        int height_rightTree = calculateHeight(node.right);
        int diff = Math.abs(height_leftTree - height_rightTree);
        return diff;
    }

    public boolean isBalanced(TreeNode root) {

        if(root == null) {
            return true;
        }

        if(calculateDifference(root)<=1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;

    }

    public static void main(String args[]) {
        TreeNode t = new TreeNode(0);
        t.left = new TreeNode(2);
        t.right = new TreeNode(4);
        t.left.left = new TreeNode(1);
        t.left.left.left = new TreeNode(5);
        t.left.left.right = new TreeNode(1);
        t.right.left = new TreeNode(3);
        t.right.left.right = new TreeNode(6);
        t.right.right = new TreeNode(-1);
        t.right.right.right = new TreeNode(8);

        Solution s = new Solution();
        System.out.print(s.isBalanced(t));

    }

}