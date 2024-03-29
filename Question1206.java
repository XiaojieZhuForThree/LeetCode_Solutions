import java.util.Random;

public class Question1206 {
	class SLNode {
		int val;
		SLNode left, right, up, down;

		public SLNode(int val) {
			this.val = val;
		}
	}

	class Skiplist {
		SLNode head, tail;
		Random rand;
		int level;

		public Skiplist() {
			head = new SLNode(Integer.MIN_VALUE);
			tail = new SLNode(Integer.MAX_VALUE);
			rand = new Random();
			head.right = tail;
			tail.left = head;
		}

		public boolean search(int target) {
			SLNode node = bottomFind(target);
			return node.val == target;
		}

		public void add(int num) {
			SLNode pre = bottomFind(num);
			SLNode node = new SLNode(num);
			connect(pre, node);
			int i = 0;
			while (rand.nextDouble() < 0.5) {
				if (i == level) {
					addNewLevel();
				}
				while (pre.up == null) {
					pre = pre.left;
				}
				pre = pre.up;
				SLNode nNode = new SLNode(num);
				connect(pre, nNode);
				nNode.down = node;
				node.up = nNode;
				node = nNode;
				i++;
			}
		}

		public boolean erase(int num) {
			SLNode node = bottomFind(num);
			if (node.val != num) {
				return false;
			}
			while (node != null) {
				node.left.right = node.right;
				node.right.left = node.left;
				node = node.up;
			}
			return true;
		}

		private SLNode bottomFind(int target) {
			SLNode node = head;
			while (true) {
				while (node.right.val <= target) {
					node = node.right;
				}
				if (node.down == null) {
					break;
				}
				node = node.down;
			}
			return node;
		}

		private void connect(SLNode a, SLNode b) {
			SLNode c = a.right;
			c.left = b;
			b.right = c;
			a.right = b;
			b.left = a;
		}

		private void addNewLevel() {
			SLNode a = new SLNode(Integer.MIN_VALUE), b = new SLNode(Integer.MAX_VALUE);
			a.right = b;
			b.left = a;
			a.down = head;
			head.up = a;
			b.down = tail;
			tail.up = b;
			head = a;
			tail = b;
			level++;
		}
	}

	/**
	 * Your Skiplist object will be instantiated and called as such: Skiplist obj =
	 * new Skiplist(); boolean param_1 = obj.search(target); obj.add(num); boolean
	 * param_3 = obj.erase(num);
	 */
}
