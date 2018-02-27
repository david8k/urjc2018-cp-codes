#include <bits/stdc++.h>

using namespace std;

const int MAXN = 100100;
const int INF = 0x3f3f3f3f;

vector<int> graph[MAXN];
bool visited[MAXN];

int a=1, b=6;
int N,E;

int DFS(int node, int target){
  if(node == target) return 0;
  if(visited[node]) return INF;
  visited[node] = true;
  int best_result = INF;
  for(int i=0;i<graph[node].size();i++){
    int dest = graph[node][i];
    best_result = min(
        best_result,
        DFS(dest, target)+1
    );
  }
  return best_result;
}

int BFS(int start, int target){
  queue<pair<int,int> > q;
  q.push(make_pair(start,0));
  visited[start] = true;
  while(!q.empty()){
    pair<int,int> current = q.front(); q.pop();
    if(current.first == target) return current.second;
    for(int i=0;i<graph[current.first].size();i++){
      int dest = graph[current.first][i];
      if(visited[dest]) continue;
      visited[dest] = true;
      q.push(make_pair(dest,current.second+1));
    }
  }
  return -1;
}

int main(){
  freopen("recorridos.in","r",stdin);
	scanf("%d %d",&N,&E);
  for(int i=1;i<=N;i++) graph[i].clear(); // limpia el grafo
	for(int i=0;i<E;i++){
    int from, to; scanf("%d %d",&from, &to);
    graph[from].push_back(to);
    graph[to].push_back(from); // borrar linea si es dirigido
	}
  memset(visited,0,sizeof(visited));
  printf("BFS de %d a %d es %d\n",a,b,BFS(a,b));
  memset(visited,0,sizeof(visited));
  printf("DFS de %d a %d es %d\n",a,b,DFS(a,b));
  return 0;
}
