import java.util.Stack;

public class Question946 {
	class Solution {
		public boolean validateStackSequences(int[] pushed, int[] popped) {
			if (pushed.length == 0) {
				return true;
			}
			Stack<Integer> stack = new Stack<>();
			stack.push(pushed[0]);
			int pt1 = 1, pt2 = 0;
			while (pt2 < popped.length) {
				if (!stack.isEmpty() && popped[pt2] == stack.peek()) {
					pt2++;
					stack.pop();
				} else if (pt1 < pushed.length) {
					stack.push(pushed[pt1++]);
				} else {
					return false;
				}
			}
			return true;
		}
	}
}
