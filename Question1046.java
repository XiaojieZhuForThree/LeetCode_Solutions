import java.util.*;

public class Question1046 {
	class Solution {
		public int lastStoneWeight(int[] stones) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
				
				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}

			});
			for (int i : stones) {
				pq.add(i);
			}
			while (!pq.isEmpty()) {
				if (pq.size() == 1) {
					return pq.poll();
				}
				int a = pq.poll(), b = pq.poll();
				pq.add(Math.abs(a - b));
			}
			return 0;
		}
	}
}
