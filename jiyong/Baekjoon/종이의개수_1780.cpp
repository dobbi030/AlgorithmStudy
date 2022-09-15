#include <bits/stdc++.h>

using namespace std;

int color[3] = {0, 0, 0};

bool cut(vector<vector<int>> &pa) {
    int num = pa[0][0];
    for(int i=0; i<pa.size(); i++) {
        for(int j=0; j<pa.size(); j++) {
            if(pa[i][j] != num) {
                return true;
            }
        }
    }
    return false;
}

vector<vector<int>> piece(vector<vector<int>> &pa, pair<int, int> start, pair<int, int> end) {
    vector<vector<int>> result;
    for(int i=start.second; i<=end.second; i++) {
        vector<int> tmp;
        tmp.assign(pa[i].begin()+start.first, pa[i].begin()+end.first+1);
        result.push_back(tmp);
    }
    return result;
}

void count(vector<vector<int>> pa) {
    if(cut(pa)) {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                count(piece(pa, make_pair(j*pa.size()/3, i*pa.size()/3), make_pair((j+1)*pa.size()/3-1, (i+1)*pa.size()/3-1)));
            }
        }
    } else {
        color[pa[0][0]+1]++;
    }
}

int main() {
    
    ios::sync_with_stdio(false);
	cin.tie(NULL);
    cout.tie(NULL);
    
    int n;
    cin >> n;
    vector<vector<int>> pa(n, vector<int>(n, 0));
    for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            cin >> pa[i][j];
        }
    }
    count(pa);
    for(int i=0; i<3; i++) {
        cout << color[i] << "\n";
    }
}