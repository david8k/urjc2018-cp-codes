#include <bits/stdc++.h>

using namespace std;

const int MAXN = 110;

vector<int> graph[MAXN];
stack<int> ts;
bool visit[MAXN];

void DFS(int node){
  if(visit[node]) return;
  visit[node] = true;
  for(int i=0;i<(int)graph[node].size();i++){
    int dst = graph[node][i];
    DFS(dst);
  }
  ts.push(node);
}

int main(){
  int n, m; scanf("%d %d", &n, &m);
  for(int i=0;i<m;i++){
    int a, k;
    scanf("%d %d",&a, &k);
    a--;
    for(int i=0;i<k;i++){
      int b; scanf("%d",&b);
      b--;
      graph[b].push_back(a);
    }
  }
  for(int i=0;i<n;i++){
    sort(graph[i].rbegin(), graph[i].rend());
  }
  for(int i=n-1;i>=0;i--){
    if(!visit[i]) DFS(i);
  }
  bool first = true;
  while(!ts.empty()){
    if(!first) printf(" ");
    else first = false;
    printf("%d", ts.top()+1);
    ts.pop();
  }
  printf("\n");
}
