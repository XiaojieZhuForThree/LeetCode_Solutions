public class Question1339 {
	class Solution {
	    long maxVal = Integer.MIN_VALUE;
	    public int maxProduct(TreeNode root) {
	        getSum(root);
	        long total = root.val;
	        helper(root, total);
	        return (int)(maxVal % (int)(1e9 + 7));
	    }
	    private void helper(TreeNode node, long total) {
	        if (node == null) {
	            return;
	        }
	        if (node.left == null && node.right == null) {
	            return;
	        }
	        if (node.left != null) {
	            helper(node.left, total);
	            maxVal = Math.max(maxVal, (total - node.left.val) * node.left.val);
	        }
	        if (node.right != null) {
	            helper(node.right, total);
	            maxVal = Math.max(maxVal, (total - node.right.val) * node.right.val);
	        }
	    }
	    private void getSum(TreeNode node) {
	        if (node == null) {
	            return;
	        }
	        if (node.left == null && node.right == null) {
	            return;
	        }
	        getSum(node.left);
	        getSum(node.right);
	        if (node.left != null) {
	            node.val += node.left.val;
	        }
	        if (node.right != null) {
	            node.val += node.right.val;
	        }
	    }
	}
}
