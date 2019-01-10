class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] dp = new int[n + 1];
        dp[n]  = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int health = 0;
                if (i == m - 1) health = dp[j + 1] - dungeon[i][j];
                else if (j == n - 1) health = dp[j] - dungeon[i][j];
                else health = Math.min(dp[j + 1], dp[j]) - dungeon[i][j];
                dp[j] = health <= 0 ? 1 : health;
            }
        }
        return dp[0];                  
    }
}
