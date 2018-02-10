#include <bits/stdc++.h>

using namespace std;

int main(){
    set<int> S;
    S.insert(4);
    S.insert(3);
    S.insert(4);
    printf("%d\n", (int)S.size());
    S.erase(S.find(4));
    printf("%d\n", (int)S.size());
}
