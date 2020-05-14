
public class Question1372 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	/**
	 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
	 * = left; this.right = right; } }
	 */
	class Solution {
		int max = 0;

		public int longestZigZag(TreeNode root) {
			dfs(root, 0, 0);
			dfs(root, 1, 0);
			return max;
		}

		private void dfs(TreeNode node, int dir, int height) {
			max = Math.max(max, height);
			if (dir == 0 && node.left != null) {
				dfs(node.left, 0, 0);
				dfs(node.left, 1, height + 1);
			} else if (dir == 1 && node.right != null) {
				dfs(node.right, 0, height + 1);
				dfs(node.right, 1, 0);
			}
		}
	}
}
