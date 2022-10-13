#include <bits/stdc++.h>

using namespace std;

int r, c;
int dr[] = {-1, 1, 0, 0};
int dc[] = {0, 0, -1, 1};

pair<int, int> move(int r, int c, int dir, vector<vector<int>> &board) {
    int nr = r, nc = c;
    while(1) {
        nr += dr[dir];
        nc += dc[dir];
        if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || board[nr][nc] == -1 || board[r][c] == 7) {
            return {r, c};
        }
        r = nr;
        c = nc;
    }
    return {r, c};
}

int bfs(vector<vector<int>> &board, vector<vector<vector<bool>>> &visited) {
    int result = 1;
    queue<vector<int>> q;
    q.push({0, r, c});
    visited[0][r][c] = true;
    while(!q.empty()) {
        int size = q.size();
        for(int k=0; k<size; k++) {
            vector<int> cur = q.front();
            q.pop();
            int state = cur[0];
            int cr = cur[1];
            int cc = cur[2];
            for(int i=0; i<4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || board[nr][nc] == -1 || visited[state][nr][nc]) {
                    continue;
                }
                int nstate = state;
                if(board[nr][nc] != 0 && board[nr][nc] != 7) {
                    nstate |= 1 << (board[nr][nc]-1);
                }
                if(nstate == (1 << 6) - 1) {
                    return result;
                }
                visited[nstate][nr][nc] = true;
                q.push({nstate, nr, nc});
            }
            for(int i=0; i<4; i++) {
                pair<int, int> np = move(cur[1], cur[2], i, board);
                int nr = np.first;
                int nc = np.second;
                if((nr == cur[1] && nc == cur[2]) || visited[state][nr][nc]) {
                    continue;
                }
                int nstate = state;
                if(board[nr][nc] != 0 && board[nr][nc] != 7) {
                    nstate |= 1 << (board[nr][nc]-1);
                }
                if(nstate == (1 << 6) - 1) {
                    return result;
                }
                visited[nstate][nr][nc] = true;
                q.push({nstate, nr, nc});
            }
        }        
        result++;
    }
    return -1;
}

int main() {
    
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    vector<vector<int>> board(5, vector<int>(5));
    vector<vector<vector<bool>>> visited(1 << 6, vector<vector<bool>>(5, vector<bool>(5, false)));
    for(int i=0; i<5; i++) {
        for(int j=0; j<5; j++) {
            cin >> board[i][j];
        }
    }
    cin >> r >> c;
    cout << bfs(board, visited);
    return 0;
}