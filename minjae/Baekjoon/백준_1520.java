import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class algo_1520 {
    static int H;
    static int W;
    static int[][] map;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {-1, 0, 1, 0};
    static int result = 0;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().trim().split(" ");
        H = Integer.parseInt(input[0]);
        W = Integer.parseInt(input[1]);
        map = new int[H][W];
        dp = new int[H][W];
        //0으로 초기화해서 탐색하면 방문했는데 길이 없어서 0인 지점도 다시 방문한다.
        for (int i = 0; i < H; i++) {
            Arrays.fill(dp[i], -1);
        }
        //도착하는 장소를 1로 지정
        dp[H - 1][W - 1] = 1;

        for (int i = 0; i < H; i++) {
            map[i] = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(dp(0, 0));
    }

    static int dp(int y, int x) {
        //방문했으면 dp 리턴
        if (dp[y][x] >= 0) {
            return dp[y][x];
        }

        //초기값 설정
        dp[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            //범위 넘어가면 패스
            if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
            //만약 다음 숫자가 지금보다 낮으면
            if (map[y][x] > map[ny][nx]) {
                dp[y][x] += dp(ny, nx);
            }
        }
        return dp[y][x];
    }
}
