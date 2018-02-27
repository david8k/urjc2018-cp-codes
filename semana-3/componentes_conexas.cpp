#include <bits/stdc++.h>

using namespace std;

const int MAXN = 100100;
const int INF = 0x3f3f3f3f;

vector<int> graph[MAXN];
bool visited[MAXN];

int N,E;

void DFS(int node){
  if(visited[node]) return;
  visited[node] = true;
  for(int i=0;i<graph[node].size();i++){
    int dest = graph[node][i];
    DFS(dest);
  }
}

int main(){
  freopen("componentes.in","r",stdin);
	scanf("%d %d",&N,&E);
  for(int i=1;i<=N;i++) graph[i].clear(); // limpia el grafo
	for(int i=0;i<E;i++){
    int from, to; scanf("%d %d",&from, &to);
    graph[from].push_back(to);
    graph[to].push_back(from); // borrar linea si es dirigido
	}
  memset(visited,0,sizeof(visited));
  int comps = 0;
  for(int i=1;i<=N;i++){
    if(!visited[i]){
      DFS(i);
      comps++;
    }
  }
  printf("Hay %d componentes\n", comps);
  return 0;
}
