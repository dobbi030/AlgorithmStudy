#include <bits/stdc++.h>

using namespace std;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int bfs(vector<vector<int>> &maps) {
    if(maps[0].size() == 1 && maps.size() == 1) {
        return 1;
    }
    int dist = 2;
    queue<pair<int, int>> q;
    q.push({0, 0});
    maps[0][0] = 0;
    while(!q.empty()) {
        int size = q.size();
        for(int i=0; i<size; i++) {
            int x = q.front().first;
            int y = q.front().second;
            for(int i=0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx < 0 || nx >= maps[0].size() || ny < 0 || ny >= maps.size()) {
                    continue;
                }
                if(maps[ny][nx] == 0) {
                    continue;
                }
                if(nx == maps[0].size()-1 && ny == maps.size()-1) {
                    return dist;
                }
                maps[ny][nx] = 0;
                q.push({nx, ny});
            }
            q.pop();
        }
        dist++;
    }
    return -1;
}

int solution(vector<vector<int>> maps) {
    return bfs(maps);
}