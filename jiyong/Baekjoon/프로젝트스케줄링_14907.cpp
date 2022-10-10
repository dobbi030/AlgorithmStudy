#include <bits/stdc++.h>

using namespace std;

int main() {
    
    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);

    int result = 0;
    string s;
    vector<vector<int>> graph(26, vector<int>());
    vector<int> time(26);
    vector<int> in_counter(26, 0);
    vector<int> start(26, 0);
    while(1) {
        getline(cin, s);
        if(cin.eof()) {
            break;
        }
        stringstream ss(s);
        char node;
        int t;
        string adj;
        ss >> node >> t >> adj;
        time[node - 'A'] = t;
        for(int i=0; i<adj.size(); i++) {
            graph[adj[i] - 'A'].push_back(node - 'A');
        }
    }
    for(int i=0; i<26; i++) {
        for(int j=0; j<graph[i].size(); j++) {
            in_counter[graph[i][j]]++;
        }
    }
    queue<int> q;
    for(int i=0; i<26; i++) {
        if(in_counter[i] == 0) {
            q.push(i);
        }
    }
    while(!q.empty()) {
        int size = q.size();
        for(int i=0; i<size; i++) {
            int cur = q.front();
            q.pop();
            for(int j=0; j<graph[cur].size(); j++) {
                int next = graph[cur][j];
                in_counter[next]--;
                start[next] = max(start[next], start[cur] + time[cur]);
                if(in_counter[next] == 0) {
                    q.push(next);
                }
            }
            result = max(result, start[cur] + time[cur]);
        }
    }
    cout << result;
    return 0;
}