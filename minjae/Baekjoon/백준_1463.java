import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 백준_1463 {
    static final int MAX = 1000001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //도착값
        int N = Integer.parseInt(br.readLine().trim());

        //결과 출력
        System.out.println(bfs(N));
    }

    //bfs를 활용해서 풀이
    static int bfs(int end) {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{1, 0});
        boolean[] isVisit = new boolean[MAX];
        isVisit[1] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();

            if (now[0] == end) return now[1];

            if ((now[0] * 2) < MAX && !isVisit[now[0] * 2]) {
                que.add(new int[]{now[0] * 2, now[1] + 1});
                isVisit[now[0] * 2] = true;
            }
            if ((now[0] * 3) < MAX && !isVisit[now[0] * 3]) {
                que.add(new int[]{now[0] * 3, now[1] + 1});
                isVisit[now[0] * 3] = true;
            }
            if ((now[0] + 1) < MAX && !isVisit[now[0] + 1]) {
                que.add(new int[]{now[0] + 1, now[1] + 1});
                isVisit[now[0] + 1] = true;
            }
        }
        return -1;
    }
}
