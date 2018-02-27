#include <bits/stdc++.h>

using namespace std;

const int MAXN = 20010;

bool arr[MAXN];

int main(){
  int q; scanf("%d",&q);
  for(int i=0;i<q;i++) arr[i] = false;
  //cin >> q;
  int groups = 0;
  for(int i=0;i<q;i++){
    int p; scanf("%d",&p);
    // cin >> p;
    arr[p] = true;
    if(arr[p-1] == false && arr[p+1] == false){
      groups++;
    }
    else if(arr[p-1] == true && arr[p+1] == true){
      groups--;
    }
    printf("%d\n",groups);
  }
  printf("Justice\n");
}
