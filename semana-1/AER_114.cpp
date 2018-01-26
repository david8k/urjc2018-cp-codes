#include <bits/stdc++.h>

using namespace std;

int fact(int n){
  if(n <= 1) return 1;
  return fact(n-1)*n;
}

int main(){
  int t; scanf("%d",&t);
  for(int i=0;i<t;i++){
    int n; scanf("%d",&n);
    if(n <= 4){
      printf("%d\n",fact(n)%10);
    }
    else{
      printf("0\n");
    }
  }
  return 0;
}
