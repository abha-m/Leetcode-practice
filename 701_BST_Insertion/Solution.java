// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
 
class Solution {
    // Recursive
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        if(val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    // Iterative
    public TreeNode iterativeInsertion(TreeNode root, int val) {
        TreeNode node = root;
        TreeNode r = new TreeNode(val);
        while (true) {
            if(val < node.val) {
                if(node.left != null) {
                    node = node.left;
                }
                else {
                    node.left = r;
                    break;
                }
            }
            else {
                if(node.right != null) {
                    node = node.right;
                }
                else {
                    node.right = r;
                    break;
                }
            }
        }
        return root;
    }

    private void inorderTraversal(TreeNode root) {
        if(root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val);
            inorderTraversal(root.right);
        }
    }

    public static void main(String args[]) {
        // TreeNode t = new TreeNode(5);
        // Solution s = new Solution();
        // s.insertIntoBST(t, 6);
        // s.inorderTraversal(t);
        // System.out.println();
        // s.insertIntoBST(t, 7);
        // s.inorderTraversal(t);

        TreeNode t = new TreeNode(5);
        Solution s = new Solution();
        s.iterativeInsertion(t, 6);
        s.inorderTraversal(t);
        System.out.println();
        s.iterativeInsertion(t, 7);
        s.inorderTraversal(t);
    }

}