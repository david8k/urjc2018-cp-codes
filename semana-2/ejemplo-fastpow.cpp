#include <bits/stdc++.h>

using namespace std;

long long int fast_pow(int base, int exponent){
    if(exponent == 0) return 1;
    if(exponent == 1) return base;
    long long int tmp = fast_pow(base, exponent / 2);
    if(exponent % 2 == 1)
        return tmp*tmp*base;
    return tmp*tmp;
}

int main(){
    printf("%lld\n", fast_pow(2, 10));
}
