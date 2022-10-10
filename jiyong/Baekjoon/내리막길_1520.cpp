#include <bits/stdc++.h>

using namespace std;

int m, n;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int search(int x, int y, vector<vector<int>> &board, vector<vector<int>> &dp) {
    
    if(dp[y][x] != -1) {
        return dp[y][x];
    }
    int result = 0;
    for(int i=0; i<4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
            continue;
        }
        if(board[y][x] > board[ny][nx]) {
            result += search(nx, ny, board, dp);
        }
    }
    dp[y][x] = result;
    return result;
}

int main() {
    
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    cin >> m >> n;
    vector<vector<int>> board(m, vector<int>(n));
    vector<vector<int>> dp(m, vector<int>(n, -1));
    dp[m-1][n-1] = 1;
    for(int i=0; i<m; i++) {
        for(int j=0; j<n; j++) {
            cin >> board[i][j];
        }
    }
    cout << search(0, 0, board, dp);
    return 0;
}