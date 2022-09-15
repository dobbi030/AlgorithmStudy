#include <bits/stdc++.h>

using namespace std;

int main() {

    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int n, r, g, b;
    cin >> n;
    int cost[n][3];
    cin >> cost[0][0] >> cost[0][1] >> cost[0][2];
    for(int i=1; i<n; i++) {
        cin >> r >> g >> b;
        cost[i][0] = r + min(cost[i-1][1], cost[i-1][2]);
        cost[i][1] = g + min(cost[i-1][0], cost[i-1][2]);
        cost[i][2] = b + min(cost[i-1][0], cost[i-1][1]);
    }
    cout << *min_element(cost[n-1], cost[n-1]+3);
	return 0;
}