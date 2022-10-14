#include <iostream>
#include <algorithm>

using namespace std;

int main() {
	int board[1001][1001];
	int dp[1001][1001];
	int N, M;
	cin >> N >> M;

	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= M; ++j) {
			cin >> board[i][j];
		}
	}

	for (int i = 1; i <= N; ++i) {
		for (int j = 1; j <= M; ++j) {
			int case1 = 0, case2 = 0, case3 = 0;

			if (i == 1 && j == 1) { // 시작점일 경우 원형 값을 그대로 가져온다.
				dp[i][j] = board[i][j];
				continue;
			}
			if (i - 1 > 0) { // 아래쪽으로 이동하는 케이스
				case1 = dp[i-1][j] + board[i][j];
			}
			if (j - 1 > 0) { // 오른쪽으로 이동하는 케이스
				case2 = dp[i][j-1] + board[i][j];
			}
			if (i - 1 > 0 && j - 1 > 0) { // 대각선 아래로 이동하는 케이스
				case3 = dp[i-1][j-1] + board[i][j];
			}

			dp[i][j] = max(max(case1, case2), case3); // 모든 케이스 중 가장 큰 값을 저장한다.
		}
	}

	cout << dp[N][M];

	return 0;
}
