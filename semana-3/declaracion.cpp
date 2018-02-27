#include <bits/stdc++.h>

using namespace std;

const int MAXN = 1000;

int N,E;

struct edge{
  int from, to, weight;
  edge(){}
  edge(int a, int b, int c){
    from = a;
    to = b;
    weight = c;
  }
  bool operator<(const edge &other)const{ // sobrecarga de operadores para ordenar
    return weight < other.weight;
  }
};

vector<edge> graph[MAXN]; // listas de adyacencia
int graph_m[MAXN][MAXN]; // matriz de adyacencia

int main(){
  freopen("declaracion.in","r",stdin);
	scanf("%d %d",&N,&E);
  for(int i=1;i<=N;i++) graph[i].clear(); // limpia el grafo
	for(int i=0;i<E;i++){
    int from, to, weight; scanf("%d %d %d",&from, &to, &weight);
    graph[from].push_back(edge(from,to,weight));
    graph[to].push_back(edge(to,from,weight)); // borrar linea si es dirigido
    graph_m[from][to] = graph_m[to][from] = weight;
	}
	return 0;
}
