public class Question988 {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class NewTreeNode {
		char chr;
		NewTreeNode parent, left, right;

		public NewTreeNode(int i) {
			chr = (char) ('a' + i);
		}
	}

	class Solution {
		StringBuilder sb = new StringBuilder();
		public String smallestFromLeaf(TreeNode root) {
			if (root == null) {
				return "";
			}
			NewTreeNode rt = new NewTreeNode(root.val);
			generateNewNode(rt, 0, root.left);
			generateNewNode(rt, 1, root.right);
			dfs(rt);
			return sb.toString();
		}

		private void generateNewNode(NewTreeNode rt, int dir, TreeNode child) {
			if (child == null) {
				return;
			}
			NewTreeNode cd = new NewTreeNode(child.val);
			cd.parent = rt;
			if (dir == 0) {
				rt.left = cd;
			} else {
				rt.right = cd;
			}
			generateNewNode(cd, 0, child.left);
			generateNewNode(cd, 1, child.right);
		}

		private void dfs(NewTreeNode node) {
			if (node == null) {
				return;
			}
			if (node.left == null && node.right == null) {
				StringBuilder nsb = new StringBuilder();
				while (node != null) {
					nsb.append(node.chr);
					node = node.parent;
				}
				if (sb.length() == 0) {
					sb = nsb;
					return;
				}
				int i = 0;
				while (i < sb.length() && i < nsb.length()) {
					if (nsb.charAt(i) < sb.charAt(i)) {
						sb = nsb;
						return;
					} else if (nsb.charAt(i) > sb.charAt(i)) {
						return;
					}
					i++;
				}
				if (sb.length() >= nsb.length()) {
					sb = nsb;
					return;
				}
			}
			dfs(node.left);
			dfs(node.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((char) ('a' + 3));
	}

}
