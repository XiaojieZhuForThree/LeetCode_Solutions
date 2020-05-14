import java.util.*;

public class Question939 {
	class Solution {
		public int minAreaRect(int[][] points) {
			if (points == null || points.length < 4) {
				return 0;
			}
			Map<Integer, Set<Integer>> xs = new HashMap<>();
			for (int[] pt : points) {
				int x = pt[0], y = pt[1];
				if (!xs.containsKey(x)) {
					xs.put(x, new HashSet<>());
				}
				xs.get(x).add(y);
			}
			int min = Integer.MAX_VALUE;
			for (int x1 : xs.keySet()) {
				for (int x2 : xs.keySet()) {
					Set<Integer> y1s = xs.get(x1), y2s = xs.get(x2);
					if (x1 < x2 && y1s.size() > 1 && y2s.size() > 1) {
						for (int y1 : y1s) {
							for (int y2 : y1s) {
								if (y2s.contains(y1) && y2s.contains(y2) && y1 < y2) {
									int newArea = (x2 - x1) * (y2 - y1);
									min = Math.min(newArea, min);
								}
							}
						}
					}
				}
			}
			return min == Integer.MAX_VALUE ? 0 : min;
		}
	}
}
