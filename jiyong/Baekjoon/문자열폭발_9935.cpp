#include <bits/stdc++.h>

using namespace std;

int main(){

    cin.tie(NULL);
    cout.tie(NULL);
    ios::sync_with_stdio(false);
    
    string s, bomb;
    cin >> s >> bomb;
    string result = "";
    string st;
    map<char, int> m;
    for(int i=0; i<bomb.size(); i++) {
        m[bomb[i]] = i;
    }
    int idx = 0;
    for(int i=0; i<s.size(); i++) {
        if(s[i] == bomb[idx]) {
            st.push_back(s[i]);
            if(++idx == bomb.size()) {
                while(idx > 0) {
                    st.pop_back();
                    idx--;
                }
                if(!st.empty()) {
                    idx = m[st.back()]+1;
                }
            }
        } else if(s[i] == bomb[0]){
            st.push_back(s[i]);
            idx = 1;
        } else {
            result += st;
            result.push_back(s[i]);
            idx = 0;
            st.clear();
        }
    }
    result += st;
    if(result.empty()) {
        cout << "FRULA";
    } else {
        cout << result;
    }
    return 0;
}