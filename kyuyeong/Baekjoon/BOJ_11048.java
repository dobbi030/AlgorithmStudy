package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11048 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// (r+1, c), (r, c+1), (r+1, c+1)
		int dr[] = { 1, 0, 1};
		int dc[] = { 0, 1, 1};
		String strArr[] = br.readLine().split(" ");
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		int map[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			strArr = br.readLine().split(" ");
			for(int j=0;j<M; j++) {
				map[i][j] = Integer.parseInt(strArr[j]);
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int now = map[i][j];
				if(i>0) {
					map[i][j] = Math.max(map[i-1][j] + now, map[i][j]);
				} if(j>0) {
					map[i][j] = Math.max(map[i][j-1] + now, map[i][j]);
				} if(i>0 && j>0) {
					map[i][j] = Math.max(map[i-1][j-1] + now, map[i][j]);
				}
			}
		}
		System.out.println(map[N-1][M-1]);
	}
}
