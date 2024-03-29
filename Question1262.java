public class Question1262 {
	class Solution {
	    public int maxSumDivThree(int[] nums) {
	        int[][] dp = new int[nums.length][3];
	        int start = nums[0];
	        int pos = start % 3;
	        dp[0][pos] = start;
	        for (int i = 1; i < nums.length; i++) {
	            for (int k = 0; k < 3; k++) {
	                dp[i][k] = dp[i-1][k];
	            }
	            for (int m = 0; m < 3; m++) {
	                int base = dp[i-1][m] + nums[i];
	                int mod = base % 3;
	                dp[i][mod] = Math.max(dp[i][mod], base);
	            }
	        }
	        return dp[nums.length-1][0];
	    }
	}
}
