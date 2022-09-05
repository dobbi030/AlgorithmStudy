#include <bits/stdc++.h>

using namespace std;

int main() {

    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int n, result = 0;
    cin >> n;
    int w[n];
    for(int i=0; i<n; i++) {
        cin >> w[i];
    }
    sort(w, w+n);
    for(int i=0; i<n; i++) {
        result = max(result, w[i]*(n-i));
    }
    cout << result;
	return 0;
}