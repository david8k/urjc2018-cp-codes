#include <bits/stdc++.h>

using namespace std;

int main(){
  int num, den;
  while(scanf("%d %d",&num,&den)!=EOF && num>=den){
    long long int res = 1;
    for(int i=den+1; i<=num;i++) res *= i;
    printf("%lld\n",res);
  }
  return 0;
}
