import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class algo_1149 {
    static int N;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dp[0] = map[0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1] + map[i][0], dp[i - 1][2] + map[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + map[i][1], dp[i - 1][2] + map[i][1]);
            dp[i][2] = Math.min(dp[i - 1][0] + map[i][2], dp[i - 1][1] + map[i][2]);
        }

        System.out.println(Arrays.stream(dp[N - 1]).min().getAsInt());
    }
}
