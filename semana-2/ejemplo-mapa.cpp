#include <bits/stdc++.h>

using namespace std;

int main(){
    map<int, int> M;
    M[100] = 10;
    M[3] = 4;
    M[1e9] = 100; // se castea el double a int
    if(M.find(100) != M.end()) printf("El 100 está en el mapa\n");
    else printf("El 100 no está en el mapa\n");
    M.erase(M.find(100)); // le pasas el iterador que quieres borrar
    if(M.find(100) != M.end()) printf("El 100 está en el mapa\n");
    else printf("El 100 no está en el mapa\n");
    map<int, int>:: iterator it;
    for(it = M.begin(); it != M.end(); it++){
        printf("Key=%d, Value=%d\n",it -> first, it -> second);
    }
}
