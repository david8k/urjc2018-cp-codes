#include <bits/stdc++.h>

using namespace std;

const int MAXN = 51;
const int INF = 10000010;

int base[MAXN];

int main(){
  int n, r;
  while(scanf("%d %d",&n,&r) != EOF){
    if(n == r && r == 0) break; 
    int best_result = 0;
    int best_index = 1;
    for(int i=0;i<n;i++){
      scanf("%d",&base[i]);
      base[i] *= 10;
    }
    for(int i=0;i<r;i++){
      int worst_pancakes = INF;
      for(int j=0;j<n;j++){
        int ingredient;
        scanf("%d",&ingredient);
        if(ingredient != 0){
          worst_pancakes = min(worst_pancakes,
            base[j] / ingredient);
        }
      }
      if(worst_pancakes > best_result){
        best_result = worst_pancakes;
        best_index = i+1;
      }
    }
    printf("%d %d\n", best_index, best_result);
  }
}
