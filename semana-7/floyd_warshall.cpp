#include <bits/stdc++.h>

using namespace std;

const int MAXN = 1010;

int graph[MAXN][MAXN];

int main(){
  int n, m; scanf("%d %d",&n, &m);
  for(int i=0;i<m;i++){
    int a, b, w;
    scanf("%d %d %d",&a, &b, &w);
    graph[a][b] = w;
    graph[b][w] = w;
  }
  for(int k=0;k<n;k++){
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        graph[i][j] = min(graph[i][j], graph[i][k]+graph[k][j]);
      }
    }
  }
}
