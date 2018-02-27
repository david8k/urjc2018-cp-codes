#include <bits/stdc++.h>

using namespace std;

const int MAXN = 100100;
const int INF = 0x3f3f3f3f;

vector<int> graph[MAXN];
bool visited[MAXN];
stack<int> topological_order;

int N,E;

void DFS(int node){
  if(visited[node]) return;
  visited[node] = true;
  for(int i=0;i<graph[node].size();i++){
    int dest = graph[node][i];
    DFS(dest);
  }
  topological_order.push(node);
}

int main(){
  freopen("topological.in","r",stdin);
	scanf("%d %d",&N,&E);
  for(int i=1;i<=N;i++) graph[i].clear(); // limpia el grafo
	for(int i=0;i<E;i++){
    int from, to; scanf("%d %d",&from, &to);
    graph[from].push_back(to);
	}
  printf("Ordenamiento topologico:");
  //Asumo que el nodo 1 no es dependiente de nadie
  DFS(1);
  while(!topological_order.empty()){
    printf(" %d",topological_order.top());
    topological_order.pop();
  }
  printf("\n");
  return 0;
}
