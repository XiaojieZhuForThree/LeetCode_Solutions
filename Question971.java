import java.util.*;

class TreeNode {
	int val;
	TreeNode left, right;

	public TreeNode(int x) {
		val = x;
	}
}

public class Question971 {
	class Solution1 {
		public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
			List<Integer> ans = new ArrayList<>();
			if (root == null) {
				return ans;
			}
			Stack<TreeNode> stack = new Stack<>();
			stack.push(root);
			int i = 0;
			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				if (node.val != voyage[i++]) {
					return Arrays.asList(-1);
				}
				if (node.right != null && node.right.val == voyage[i]) {
					if (node.left != null) {
						ans.add(node.val);
						stack.add(node.left);
						stack.add(node.right);
					} else {
						stack.add(node.right);
					}
				} else {
					if (node.right != null) {
						stack.add(node.right);
					}
					if (node.left != null) {
						stack.add(node.left);
					}
				}
			}
			return ans;
		}
	}

	class Solution2 {
		int i = 0;
		List<Integer> ans = new ArrayList<>();

		public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
			List<Integer> ans = new ArrayList<>();
			return dfs(root, voyage, ans, new int[] { 0 }) ? ans : Arrays.asList(-1);
		}

		private boolean dfs(TreeNode root, int[] voyage, List<Integer> ans, int[] i) {
			if (root == null) {
				return true;
			}
			if (root.val != voyage[i[0]++]) {
				return false;
			}
			if (root.left != null && root.left.val != voyage[i[0]]) { 	
				ans.add(root.val);
				return dfs(root.right, voyage, ans, i) && dfs(root.left, voyage, ans, i);
			}
//			or you can write:
//			if (root.right != null && root.right.val == voyage[i[0]]) {
//				if (root.left != null) {
//					ans.add(root.val);
//				}
//				return dfs(root.right, voyage, ans, i) && dfs(root.left, voyage, ans, i);
//			}
			return dfs(root.left, voyage, ans, i) && dfs(root.right, voyage, ans, i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
