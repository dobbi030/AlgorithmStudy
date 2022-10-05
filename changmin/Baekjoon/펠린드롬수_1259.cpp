#include <iostream>
#include <string>
#include <stack>
#include <algorithm>

using namespace std;

int main()
{
    while (true)
    {
        string input;
        cin >> input;
        if (input == "0")
            return 0;

        if (input[0] == '0')
        {
            cout << "no" << '\n';
            continue;
        }

        if (input.size() == 2)
        {
            if (input[0] == input[1])
                cout << "yes" << '\n';
            else
                cout << "no" << '\n';
            continue;
        }

        stack<char> s;

        for (int i = 0; i < input.size() / 2; ++i)
        {
            s.push(input[i]);
        }

        int plus = 0;

        if (input.size() % 2 != 0)
        {
            plus = 1;
        }

        for (int i = input.size() / 2 + plus; i < input.size(); ++i)
        {
            if (s.top() == input[i])
            {
                s.pop();
                continue;
            }
            else
            {
                s.push(input[i]);
            }
        }

        if (s.size() == 1 || s.size() == 0)
        {
            cout << "yes" << '\n';
        }
        else
        {
            cout << "no" << '\n';
        }
    }
}