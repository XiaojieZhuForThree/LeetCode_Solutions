
public class Question1290 {

	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	class Solution {
		public int getDecimalValue(ListNode head) {
			int i = 0;
			while (head != null) {
				i = i * 2 + head.val;
				head = head.next;
			}
			return i;
		}
	}
}
