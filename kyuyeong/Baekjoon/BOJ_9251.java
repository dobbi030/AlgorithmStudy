package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		int str1Len = str1.length();
		int str2Len = str2.length();
        // d[i][j] = 첫 번째 문자열의 i-1번째 인덱스까지, 두 번째 문자열의 j-1번째 인덱스까지 비교했을때
        // 찾을 수 있는 LCS의 최대 길이
		int d[][] = new int[str1Len + 1][str2Len + 1];
		int MAX = 0;
		for(int i=0; i<str1Len; i++) {
			for(int j=0; j<str2Len; j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					d[i + 1][j + 1] = d[i][j] + 1;
					MAX = Math.max(MAX, d[i + 1][j + 1]);
				} else {
                    // 일치하지 않는 경우, i나 j를 한 칸 진행시킨 것 중 최대값을 저장
					d[i + 1][j + 1] = d[i][j + 1] > d[i + 1][j] ? d[i][j + 1] : d[i + 1][j];
				}
			}
		}
		System.out.println(MAX);
	}
}


