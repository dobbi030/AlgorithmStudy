import java.util.*;

class 프로그래머스_1844 {
    // 사방 탐색을 위한 배열
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    //연산 함수
    public int solution(int[][] maps) {
        //방문체크
        boolean[][] isVisit = new boolean[maps.length][maps[0].length];
        Queue<int[]> que = new ArrayDeque<>();
        //첫 시작 위치 + 시작칸 포함 거리
        que.add(new int[]{0, 0, 1});
        isVisit[0][0] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            //마지막에 도착하면 리턴
            if (now[0] == maps.length - 1 && now[1] == maps[0].length - 1) {
                return now[2];
            }
            for (int i = 0; i < 4; i++) {
                int y = now[0] + dy[i];
                int x = now[1] + dx[i];
                if (y < 0 || y >= maps.length || x < 0 || x >= maps[0].length) continue;
                if (maps[y][x] == 1 && !isVisit[y][x]) {
                    que.add(new int[]{y, x, now[2] + 1});
                    isVisit[y][x] = true;
                }
            }
        }
        //도착 못하면 -1
        return -1;
    }
}