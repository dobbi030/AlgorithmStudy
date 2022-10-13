package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_25689 {
	static class Point{
		int r, c, v;
		Point(int r, int c, int v){
			this.r = r;
			this.c = c;
			this.v = v;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 5;
		int map[][] = new int[N][N];
		boolean v[][] = new boolean[N][N];
		// [동, 서, 남, 북]
		int dc[] = { 1, -1, 0, 0 };
		int dr[] = { 0, 0, 1, -1 };
		String strArr[];
		for(int i=0; i<N; i++) {
			strArr = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(strArr[j]);
			}
		}
		strArr = br.readLine().split(" ");
		int r = Integer.parseInt(strArr[0]);
		int c = Integer.parseInt(strArr[1]);
		Queue<Point> queue = new LinkedList<Point>();
		// 모든칸을 방문할 수 없는 경우인지 탐색
		queue.offer(new Point(r, c, 0));
		v[r][c] = true;
		int visited = 0;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int i=0; i<4; i++) {
				int mr = p.r + dr[i];
				int mc = p.c + dc[i];
				if(mr >= 5 || mc >= 5 || mr < 0 || mc < 0) continue;
				if(v[mr][mc]) continue;
				int val = map[mr][mc];
				if(val == -1) continue;
				queue.offer(new Point(mr, mc, 0));
				v[mr][mc] = true;
				if(val > 0 && val < 7) {
					visited = visited | (1 << val);
				}
			}
		}
		// 탐색시 1부터 6까지 전부 탐색 불가능한 경우
		if(visited != ((1 << 7) - 2)){
			System.out.println(-1);
			return;
		}
		// 실제 탐색
		// 학생의 현재위치에는 0 적혀있음
		queue.offer(new Point(r, c, 0));
		int time = 0;
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			while(queueSize-->0) {
				Point p = queue.poll();
				// 1번칸 부터 6번칸 까지 다 밟은 경우
				if(p.v == (1<<7)-2) {
					// 시간 출력하고 종료
					System.out.println(time);
					return;
				}
				// 4방위 탐색
				for(int i=0; i<4; i++) {
					int mr = p.r + dr[i];
					int mc = p.c + dc[i];
					if(mr >= 5 || mc >= 5 || mr < 0 || mc < 0) continue;
					int val = map[mr][mc];
					// 걷는 경우
					if(val!=-1) {
						// 1~6 사이 아니면 v ( visited )에 반영 X
						queue.offer(new Point(mr, mc, (val > 6 || val < 1) ? p.v : (p.v | (1<<val))));
						// 해당 방향으로 한칸 갔을때 발판이 -1과 7이 아닌 경우
						// => 해당 방향으로 뛰면 걷는것과 차이 있는 경우
						if(val != 7) {
							int mmr = mr;
							int mmc = mc;
							// 해당 방향의 끝까지 탐색
							while(mmr < 5 && mmc < 5 && mmr >= 0 && mmc >= 0) {
								// -1이나 7 만나면 정지
								if(map[mmr][mmc] == -1) {
									mmr -= dr[i];
									mmc -= dc[i];
									break;
								} else if(map[mmr][mmc] == 7) {
									break;
								}
								mmr += dr[i];
								mmc += dc[i];
							}
							// r이나 c값이 범위 벗어난 상태 ( 해당방향 끝까지 탐색한 상태 ) 면 경계값으로 값 바꿔줌
							mmr = mmr >= 5 ? 4 : (mmr < 0 ? 0 : mmr);
							mmc = mmc >= 5 ? 4 : (mmc < 0 ? 0 : mmc);
							val = map[mmr][mmc];
							// 뛴 위치가 -1이 아니면서 걸은것 보다 더 멀리 간 경우
							if(val!=-1 && !(mmr == mr && mmc == mc)) {
								queue.offer(new Point(mmr, mmc, (val > 6 || val < 1) ? p.v : (p.v | (1<<val))));
							}
						}
					}
				}
			}
			time++;
		}
	}
}
