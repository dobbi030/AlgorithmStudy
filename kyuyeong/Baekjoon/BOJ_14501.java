package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14501 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int counseling[][] = new int[N+1][N+2];
		for(int i=0; i<N; i++) {
			Arrays.fill(counseling[i], 0);		
		}
		String str[];
		for(int i=1; i<=N; i++) {
			str = br.readLine().split(" ");
			int day = Integer.parseInt(str[0]);
			int d = day + i; // 현재 입력받은 상담이 끝났을 때의 날짜
			int value = Integer.parseInt(str[1]);
			// 반복은 N+1일까지 진행 ( N일에 일한걸 N+1에 받는걸로 계산해서 )
			for(int j=1; j<=N+1; j++) {
				if(j == d) { // 상담이 끝났을때의 날짜와 같을 때
					// [ 현재 상담의 금액 + 현재 상담 시작하기전의 날까지의 금액 ] 과 [ 직전의 상담까지 고려한 현재 날짜의 최적해 ] 비교
					counseling[i][j] = Math.max(value + counseling[i-1][j-day], counseling[i-1][j]);	
				} else
					// 이외에는 그냥 [ 이번 상담을 고려한 전날의 최적해 ] 과 [ 직전의 상담을 고려한 현재 날짜의 최적해 ] 비교
					counseling[i][j] = Math.max(counseling[i][j-1], counseling[i-1][j]);
			}
		}
		int max = 0;
		for(int i=1; i<=N; i++) {
			max = Math.max(max,counseling[i][N+1]);
		}
		System.out.println(max);
	}
}
