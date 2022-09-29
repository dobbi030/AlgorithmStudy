#include <bits/stdc++.h>
#define INF 987654321

using namespace std;

int main() {
    
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    int dist[n+1];
    fill(dist, dist+n+1, INF);
    dist[n] = 0;
    for(int i=n; i>=2; i--) {
        dist[i/3] = i%3 == 0 ? min(dist[i/3], dist[i]+1) : dist[i/3];
        dist[i/2] = i%2 == 0 ? min(dist[i/2], dist[i]+1) : dist[i/2];
        dist[i-1] = min(dist[i-1], dist[i]+1);
    }
    cout << dist[1];
    return 0;
}