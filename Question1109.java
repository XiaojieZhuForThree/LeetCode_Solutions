
public class Question1109 {
	class Solution1 {
	    public int[] corpFlightBookings(int[][] bookings, int n) {
	        int[] ans = new int[n];
	        for (int[] bk : bookings) {
	            for (int i = bk[0]; i <= bk[1]; i++) {
	                ans[i-1] += bk[2];
	            }
	        }
	        return ans;
	    }
	}
	
	class Solution2 {
	    public int[] corpFlightBookings(int[][] bookings, int n) {
	        int[] ans = new int[n];
	        for (int[] bk : bookings) {
	            ans[bk[0]-1] += bk[2];
	            if (bk[1] < n) {
	                ans[bk[1]] -= bk[2];
	            }
	        }
	        for (int i = 1; i < n; i++) {
	            ans[i] += ans[i-1];
	        }
	        return ans;
	    }
	}
}
