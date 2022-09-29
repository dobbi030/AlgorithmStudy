#include <bits/stdc++.h>

using namespace std;

int n;

int dfs(int cur, vector<int> &ti, vector<int> &pi) {
    if(cur > n) {
        return 0;
    }
    if(cur+ti[cur] <= n+1) {
        return max(pi[cur] + dfs(cur+ti[cur], ti, pi), dfs(cur+1, ti, pi));
    } else {
        return dfs(cur+1, ti, pi);
    }
}

int main() {
    
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    vector<int> ti(n+1);
    vector<int> pi(n+1);
    int result = 0;
    for(int i=1; i<=n; i++) {
        cin >> ti[i] >> pi[i];
    }
    for(int i=1; i<=n; i++) {
        result = max(result, dfs(1, ti, pi));
    }
    cout << result;
    return 0;
}