package algorithm.programmers;
import java.util.ArrayDeque;
import java.util.Queue;

public class PRG_30_1844 {

	class Solution {
	    public int solution(int[][] maps) {
	        int answer = 0;
	        boolean v[][] = new boolean[maps.length][maps[0].length];
	        int dx[] = new int[] { 1, -1, 0, 0 };
			int dy[] = new int[] { 0, 0, 1, -1 };
			Queue<int[]> queue = new ArrayDeque<>();
			queue.offer(new int[] {0, 0});
	        v[0][0] = true;
			boolean isArrived = false;
	        while(!queue.isEmpty()) {
				int queueSize = queue.size();
				while(queueSize-->0) {
					int now[] = queue.poll();
					if(now[1] == maps.length-1 && now[0] == maps[0].length-1) {
						queue.clear();
						isArrived = true;
						break;
					}
					for(int i=0; i<4; i++) {
						int mx = now[0] + dx[i];
						int my = now[1] + dy[i];
						if(mx < 0 || my < 0 || mx >= maps[0].length || my >= maps.length) continue;
						if(v[my][mx]) continue;
						if(maps[my][mx] == 0) continue;
						queue.offer(new int[] {mx, my});
						v[my][mx] = true;
					}
				}
				answer++;
			}
			if(!isArrived) answer = -1;
	        return answer;
	    }
	}
}
