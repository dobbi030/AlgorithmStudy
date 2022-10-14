#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int main() {
	string s1 = "";
	string s2 = "";

	cin >> s1;
	cin >> s2;

	vector<vector<int>> dp(s1.size() + 1, vector<int>(s2.size() + 1));

	for (int i = 0; i < s1.size(); ++i) {
		for (int j = 0; j < s2.size(); ++j) {
			if (s1[i] != s2[j]) {
				dp[i + 1][j + 1] = max(dp[i][j + 1], dp[i + 1][j]);
			}
			else if (s1[i] == s2[j]) {
				dp[i + 1][j + 1] = dp[i][j] + 1;
			}
		}
	}

	cout << dp[s1.size()][s2.size()];

	return 0;
}
