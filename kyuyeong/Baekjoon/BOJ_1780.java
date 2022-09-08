package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1780 {
	static int minusOne, zero, plusOne;
	public static void main(String[] args) throws NumberFormatException, IOException {
		minusOne = 0;
		zero = 0;
		plusOne = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][N];
		String str[];
		for(int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		countPaper(arr, N, 0, 0);
		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(plusOne);
	}
	static void countPaper(int arr[][], int size, int startX, int startY) {
		if(size == 1) {
			switch(arr[startY][startX]) {
			case -1:
				minusOne++;
				break;
			case 0:
				zero++;
				break;
			case 1:
				plusOne++;
				break;
			}
			return;
		}
		boolean isMinusOne = false, isZero = false, isPlusOne = false, isAllSame = true;
		loop:
		for(int i=startY, ySize = startY+size; i<ySize; i++) {
			for(int j=startX, xSize = startX+size; j<xSize; j++) {
				switch(arr[i][j]) {
				case -1:
					isMinusOne = true;
					if(isZero || isPlusOne) {
						isAllSame = false;
						break loop;
					}
					break;
				case 0:
					isZero = true;
					if(isMinusOne || isPlusOne) {
						isAllSame = false;
						break loop;
					}
					break;
				case 1:
					isPlusOne = true;
					if(isMinusOne || isZero) {
						isAllSame = false;
						break loop;
					}
					break;
				}
			}
		}
		// 모든 모양이 같지않으면 size/3 * size/3 으로 조각내서 재귀
		if(!isAllSame) {
			int recSize = size/3;
			for(int i=startY, ySize = startY+size; i<ySize; i+=recSize) {
				for(int j=startX, xSize = startX+size; j<xSize; j+=recSize) {
					countPaper(arr, recSize, j, i);
				}
			}
		} else {
			if(isMinusOne) {
				minusOne++;
			} else if(isZero) {
				zero++;
			} else if(isPlusOne) {
				plusOne++;
			}
		}
		return;
	}
}
