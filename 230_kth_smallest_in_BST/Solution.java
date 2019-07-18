class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    int count = 0;
    private int countNodes(TreeNode root) {
        if(root != null) {
            countNodes(root.left);
            count++;
            countNodes(root.right);
        }
        return count;
    }

    int answer = 0;
    public void computeKthSmallest(TreeNode root, int k) {
        if(root != null) {
            count = 0;
            int num_left_nodes = countNodes(root.left);
            if(num_left_nodes+1 == k) {
                answer = root.val;
            }
            else if(num_left_nodes < k) {
                computeKthSmallest(root.right, k-num_left_nodes-1);
            }
            else {
                kthSmallest(root.left, k);
            }
        }
    }

    
    public int kthSmallest(TreeNode root, int k) {
        computeKthSmallest(root, k);
        return answer;    
    }

    public static void main(String args[]) {
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(3);
        t.right = new TreeNode(6);
        t.left.left = new TreeNode(2);
        t.left.right = new TreeNode(4);
        t.left.left.left = new TreeNode(1);
        

        Solution s = new Solution();
        System.out.println(s.kthSmallest(t, 5));
    }
}