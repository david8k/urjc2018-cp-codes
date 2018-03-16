#include <bits/stdc++.h>

using namespace std;

int main(){
  int n; scanf("%d",&n);
  for(int i=0;i<n;i++){
    char real_name[20], grandson[20];
    scanf("%s",real_name);
    int k; scanf("%d",&k);
    bool valid = true;
    for(int j=0;j<k && valid;j++){
      scanf("%s",grandson);
      if(strcmp(real_name, grandson) == 0 && j < k-1){
        valid = false;
      }
      else if(strcmp(real_name, grandson) != 0 && j == k-1){
        valid = false;
      }
    }
    if(k == 1 || !valid){
      printf("FALSA\n");
    }
    else{
      printf("VERDADERA\n");
    }
  }

  return 0;
}
