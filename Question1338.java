import java.util.*;

public class Question1338 {
	class Solution {
		public int minSetSize(int[] arr) {
			if (arr == null || arr.length == 0) {
				return 0;
			}
			Map<Integer, Integer> map = new HashMap<>();
			for (int i : arr) {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return map.get(o2) - map.get(o1);
				}
			});
			for (int i : map.keySet()) {
				pq.add(i);
			}
			int ans = 0;
			int cur = 0;
			while (cur < arr.length / 2) {
				ans += 1;
				cur += map.get(pq.poll());
			}
			return ans;
		}
	}
}
