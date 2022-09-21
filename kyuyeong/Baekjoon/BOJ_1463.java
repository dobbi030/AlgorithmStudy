package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1463_BFS {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		boolean V[] = new boolean[X+1];
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(X);
		loop:
		while(!queue.isEmpty()) {
			int qSize = queue.size();
			while(qSize-->0) {
				int now = queue.poll();
				if(now == 1) {
					break loop;
				}
				if(now%3 == 0 && !V[now/3]) {
					queue.offer(now/3);
					V[now/3] = true;
				}
				if(now%2 == 0 && !V[now/2]) {
					queue.offer(now/2);
					V[now/2] = true;
				}
				if(now-1 > 0 && !V[now-1]) {
					queue.offer(now-1);
					V[now-1] = true;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
