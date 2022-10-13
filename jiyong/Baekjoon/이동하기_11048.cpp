#include <bits/stdc++.h>

using namespace std;

int main() {
    
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int n, m;
    cin >> n >> m;
    vector<vector<int>> num(n+1, vector<int>(m+1, 0));
    for(int i=1; i<=n; i++) {
        for(int j=1; j<=m; j++) {
            cin >> num[i][j];
        }
    }
    vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
    for(int i=1; i<=n; i++) {
        for(int j=1; j<=m; j++) {
            dp[i][j] = max({num[i][j] + dp[i-1][j-1], num[i][j] + dp[i][j-1], num[i][j] + dp[i-1][j]});
        }
    }
    cout << dp[n][m];
    return 0;
}