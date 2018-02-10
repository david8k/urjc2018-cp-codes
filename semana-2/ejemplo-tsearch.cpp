#include <bits/stdc++.h>

using namespace std;

const int TARGET = 62;

int main(){
    int arr[10] = {13,24,31,40,58,62,54,32,12,2};
    int inf = 0, sup = 10;
    while(sup-inf > 2){
        int m1 = (inf+inf+sup)/3;
        int m2 = (inf+sup+sup)/3;
        if(arr[m1] < arr[m2]){
            inf = m1;
        }
        else{
            sup = m2;
        }
    }
    bool found = false;
    for(int i=(inf+inf+sup)/3; i<=(inf+sup+sup)/3; i++){
        if(arr[i] == TARGET){
            printf("El objetivo está en la posición %d\n", inf);
            found = true;
        }
    }
    if(!found) printf("El objetivo no existe\n");
}
