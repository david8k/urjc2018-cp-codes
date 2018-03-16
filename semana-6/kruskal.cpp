#include <bits/stdc++.h>

using namespace std;

const int MAXN = 100100;
const int INF = 0x3f3f3f3f;

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

struct UF{
    int parents[MAXN];
    int sz[MAXN];
    int components;
    int mst_sum;
    UF(int n){
        for(int i=0;i<n;i++){
            parents[i] = i; sz[i] = 1;
        }
        components = n;
        mst_sum = 0;
    }
    int find(int n){
        return n == parents[n] ? n : find(parents[n]);
    }
    bool isConnected(int a, int b){
        return find(a) == find(b);
    }
    void connect(int a, int b, int weight){
        if(isConnected(a, b)) return;
        int A,B; A = find(a); B = find(b);
        if(sz[A] > sz[B]){
            parents[B] = A;
            sz[A] += sz[B];
        }
        else{
            parents[A] = B;
            sz[B] += sz[A];
        }
        mst_sum += weight;
        components--;
    }
};

int a=1;
int N,E;

int main(){
  freopen("mst.in","r",stdin);
	scanf("%d %d",&N,&E);
  vector<edge> edges;
  UF uf = UF(N);
	for(int i=0;i<E;i++){
    int from, to, weight; scanf("%d %d %d",&from, &to, &weight);
    edges.push_back(edge(from,to,weight));
	}
  sort(edges.begin(), edges.end());
  for(int i=0;i<E;i++) uf.connect(edges[i].from, edges[i].to, edges[i].weight);
  printf("Kruskal de %d es %d\n",a,uf.mst_sum);
  return 0;
}

