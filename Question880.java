public class Question880 {
	class Solution {
	    public String decodeAtIndex(String S, int K) {
	        long len = 0;
	        for (char c : S.toCharArray()) {
	            if (Character.isDigit(c)) {
	                len *= c - '0';
	            } else {
	                len++;
	            }
	        }
	        for (int i = S.length() - 1; i >= 0; i--) {
	            char c = S.charAt(i);
	            if (Character.isDigit(c)) {
	                len /= (c - '0');
	                K %= len;
	            } else if (K == 0 || K == len) {
	                return Character.toString(c);
	            } else {
	                len--;
	            }
	        }
	        return "";
	    }
	}
}
