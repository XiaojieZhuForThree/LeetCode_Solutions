public class Question704 {
	class Solution {
		public int search(int[] nums, int target) {
			int l = 0, r = nums.length;
			while (l < r) {
				int m = (l + r) / 2;
				if (target == nums[m]) {
					return m;
				} else if (target < nums[m]) {
					r = m;
				} else {
					l = m + 1;
				}
			}
			return -1;
		}
	}
}
