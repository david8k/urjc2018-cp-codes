#include <bits/stdc++.h>

using namespace std;

const int TARGET = 91;

int main(){
    int arr[10] = {13,24,31,40,58,62,78,81,91,100};
    int inf = 0, sup = 10;
    while(sup-inf > 1){
        int mid = (inf+sup)/2;
        if(arr[mid] < TARGET){
            inf = mid;
        }
        else{
            sup = mid;
        }
    }
    if(arr[inf] == TARGET) printf("El objetivo está en la posición %d\n", inf);
    else if(arr[sup] == TARGET) printf("El objetivo está en la posición %d\n", sup);
    else printf("El objetivo no existe\n");
}
