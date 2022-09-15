import java.util.*;

public class BJ1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, n = sc.nextInt();
        int dp[][] = new int[n + 1][3];
        int cost[][] = new int[n + 1][3];

        for (i = 1; i <= n; i++)
            for (j = 0; j < 3; j++)
                cost[i][j] = sc.nextInt();

        dp[0][0] = dp[0][1] = dp[0][2] = cost[0][0] = cost[0][1] = cost[0][2] = 0;

        for (i = 1; i <= n; i++) {
            dp[i][0] = Min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }

        System.out.println(Min(Min(dp[n][0], dp[n][1]), dp[n][2]));
    }

    public static int Min(int a, int b) {
        return a < b ? a : b;
    }
}