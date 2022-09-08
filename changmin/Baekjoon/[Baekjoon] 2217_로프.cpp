#include <iostream>
#include <algorithm>

using namespace std;

int n;
int input[100000];
int answer;

int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);

	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> input[i];
	}

	// 오른차순 정렬한다.
	sort(input, input + n);

	// 로프를 많이 쓰려면 작은 것들 우선으로 맞춰야한다.
	for (int i = 0; i < n; i++)
	{
		answer = max(answer, (n - i) * input[i]);
	}

	cout << answer;

	return 0;
}