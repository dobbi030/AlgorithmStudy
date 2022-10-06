#include <bits/stdc++.h>

using namespace std;

void chk(string num) {
    int left = 0, right = num.size()-1;
    while(left < right) {
        if(num[left++] != num[right--]) {
            cout << "no\n";
            return;
        }
    }
    cout << "yes\n";
}

int main() {
    
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string num;
    while(1) {
        cin >> num;
        if(num.compare("0") == 0) {
            break;
        }
        chk(num);
    }
    return 0;
}