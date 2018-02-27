#include <bits/stdc++.h>

using namespace std;

const int MAXN = 1000;

int N,E;

struct edge{
  int from, to;
  edge(){}
  edge(int a, int b){
    from = a;
    to = b;
  }
};

vector<edge> graph[MAXN]; // listas de adyacencia
int graph_m[MAXN][MAXN]; // matriz de adyacencia

int main(){
  freopen("declaracion.in","r",stdin);
	scanf("%d %d",&N,&E);
  for(int i=1;i<=N;i++) graph[i].clear(); // limpia el grafo
	for(int i=0;i<E;i++){
    int from, to, weight; scanf("%d %d",&from, &to);
    graph[from].push_back(edge(from,to));
    graph[to].push_back(edge(to,from)); // borrar linea si es dirigido
	}
	return 0;
}
