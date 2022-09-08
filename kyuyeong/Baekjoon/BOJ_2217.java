package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2217 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		// 각 로프의 하중을 입력받아 배열에 저장
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		// 최대 하중 오름차순으로 정렬
		Arrays.sort(arr);
		int avg = 0;
		int cnt = 1;
		// 최대 하중이 큰 순으로 ( 인덱스 역순으로 탐색 )
		for(int i=N-1; i>=0; i--) {
			// 현재 로프의 최대하중을 w/k로 잡고, k ( 현재까지의 로프 갯수 = cnt ) 를 곱해줌.
			// 그 값이 현재 까지의 w값 중 가장 높은 경우 값 교체함.
			if(arr[i]*cnt > avg) {
				avg = arr[i]*cnt;
			}
			cnt++;
		}
		System.out.println(avg);
	}
}
