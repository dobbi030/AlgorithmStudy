
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RGB거리_1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] costs = new int[N][3];
		int[][] dp = new int[N][3];

		for (int i = 0; i < N; i++) {
			costs[i][0] = sc.nextInt();
			costs[i][1] = sc.nextInt();
			costs[i][2] = sc.nextInt();
		}

		dp[0][0] = costs[0][0];
		dp[0][1] = costs[0][1];
		dp[0][2] = costs[0][2];

		for (int i = 1; i < N; i++) {
			dp[i][0] = Integer.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
			dp[i][1] = Integer.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
			dp[i][2] = Integer.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
		}

		System.out.println(Integer.min(Integer.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
	}
}
