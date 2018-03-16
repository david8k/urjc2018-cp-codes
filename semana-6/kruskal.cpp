#include <bits/stdc++.h>

using namespace std;

const int MAXN = 100100;

struct edge{
  int from, to; int weight;
  edge(){}
  edge(int a, int b, int c){
    from = a; to = b; weight = c;
  }
  const bool operator<(const edge &other)const{
    return weight < other.weight;
  }
};

struct UF{
  int sizes[MAXN];
  int parents[MAXN];
  UF(){}
  UF(int n){
    for(int i=0;i<n;i++){
      sizes[i] = 1;
      parents[i] = i;
    }
  }
  int find(int x){
    return x == parents[x] ? x : find(parents[x]);
  }
  bool isConnected(int a, int b){
    return find(a) == find(b);
  }
  bool connect(int a, int b){
    if(isConnected(a,b)) return false;
    int A, B;
    A = find(a); B = find(b);
    if(sizes[A] > sizes[B]){
      sizes[A] += sizes[B];
      parents[B] = A;
    }
    else{
      sizes[B] += sizes[A];
      parents[A] = B;
    }
    return true;
  }
};

vector<edge> graph;

int main(){
  int n, m; scanf("%d %d",&n, &m);
  UF uf = UF(n);
  for(int i=0;i<m;i++){
    int a, b, w;
    scanf("%d %d %d",&a, &b, &w);
    graph.push_back(edge(a, b, w));
  }
  sort(graph.begin(), graph.end());
  int result = 0;
  for(int i=0;i<(int)graph.size();i++){
    bool connected = uf.connect(graph[i].from, graph[i].to);
    if(connected){
      result += graph[i].weight;
    }
  }
  printf("%d\n", result);
}
