#include <bits/stdc++.h>

using namespace std;

int main(){
    vector<int> V;
    V.push_back(4);
    V.push_back(3);
    V.push_back(2);
    int sum = 0;
    for(int i=0;i<(int)V.size();i++){
        sum += V[i];
    }
    printf("%d\n",sum);
    vector<int> W(4, 40); // reserva 4 posiciones e inicializa a 40
    sum = 0;
    for(int i=0;i<(int)W.size();i++){
        sum += W[i];
    }
    printf("%d\n",sum); // imprime 160 (40 40 40 40)
}
