import java.util.HashMap;
import java.util.Map;

public class Question1001 {
	class Solution {
		public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
			int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 0, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
					{ -1, -1 } };
			Map<Integer, Integer> row = new HashMap<>();
			Map<Integer, Integer> col = new HashMap<>();
			Map<Integer, Integer> upper = new HashMap<>();
			Map<Integer, Integer> lower = new HashMap<>();
			Map<Integer, Integer> lighton = new HashMap<>();

			for (int[] lamp : lamps) {
				int x = lamp[0], y = lamp[1];
				row.put(x, row.getOrDefault(x, 0) + 1);
				col.put(y, col.getOrDefault(y, 0) + 1);
				upper.put(x + y, upper.getOrDefault(x + y, 0) + 1);
				lower.put(x - y, lower.getOrDefault(x - y, 0) + 1);
				lighton.put(x * N + y, 1);
			}
			int[] ans = new int[queries.length];
			for (int i = 0; i < queries.length; i++) {
				int x = queries[i][0], y = queries[i][1];
				ans[i] = row.getOrDefault(x, 0) > 0 || col.getOrDefault(y, 0) > 0 || upper.getOrDefault(x + y, 0) > 0
						|| lower.getOrDefault(x - y, 0) > 0 ? 1 : 0;
				for (int[] dir : dirs) {
					int x1 = x + dir[0], y1 = y + dir[1];
					if (lighton.containsKey(x1 * N + y1) && lighton.get(x1 * N + y1) == 1) {
						row.put(x1, row.getOrDefault(x1, 1) - 1);
						col.put(y1, col.getOrDefault(y1, 1) - 1);
						upper.put(x1 + y1, upper.getOrDefault(x1 + y1, 1) - 1);
						lower.put(x1 - y1, lower.getOrDefault(x1 - y1, 1) - 1);
						lighton.put(x1 * N + y1, 0);
					}
				}
			}
			return ans;
		}
	}
}
