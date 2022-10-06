#include <bits/stdc++.h>
#define INF 987654321

using namespace std;

string s;

bool chk(int start, int end, vector<vector<bool>> &is_pal) {
    if(s[start] == s[end] && is_pal[start+1][end-1]) {
        return true;
    }
    return false;
}

int pal(vector<int> &dp, int idx, vector<vector<bool>> &is_pal) {
    if(is_pal[idx][s.size()-1]) {
        return 1;
    }
    int result = INF;
    for(int i=idx; i<s.size(); i++) {
        if(!is_pal[idx][i]) {
            continue;
        }
        int right_num;
        if(dp[i] == -1) {
            right_num = pal(dp, i+1, is_pal);
            dp[i] = right_num;
        }
        right_num = dp[i];
        result = min(result, 1 + right_num);
    }
    return result;
}

int main() {
    
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> s;
    vector<int> dp(s.size()+1, -1);
    vector<vector<bool>> is_pal(s.size(), vector<bool>(s.size(), false));
    for(int i=0; i<s.size(); i++) {
        for(int j=0; j<=i; j++) {
            is_pal[i][j] = true;
        }
    }
    for(int i=1; i<s.size(); i++) {
        for(int j=0; j+i<s.size(); j++) {
            if(chk(j, j+i, is_pal)) {
                is_pal[j][j+i] = true;
            }
        }
    }

    cout << pal(dp, 0, is_pal);

    return 0;
}