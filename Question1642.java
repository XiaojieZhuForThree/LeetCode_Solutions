package com.leetcode.problems;

import java.util.PriorityQueue;

public class Question1642 {
	class Solution {
		public int furthestBuilding(int[] heights, int bricks, int ladders) {
	        PriorityQueue<Integer> pq = new PriorityQueue<>();
	        for (int i = 0; i < heights.length - 1; i++) {
	            int diff = heights[i + 1] - heights[i];
	            if (diff <= 0) {
	                continue;
	            }
	            pq.offer(diff);
	            if (pq.size() > ladders) {
	                int smallest = pq.poll();
	                if (bricks < smallest) {
	                    return i;
	                }
	                bricks -= smallest;
	            }
	        }
	        return heights.length - 1;
	    }
	}
}
