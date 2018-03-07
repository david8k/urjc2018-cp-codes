#include <bits/stdc++.h>

using namespace std;

const int MAXN = 20100;

vector<int> graph[MAXN];
bool visit[MAXN];

int DFS(int node){
	if(visit[node]) return 0;
	visit[node] = true;
	int cnt = 1;
	for (int i = 0; i < (int)graph[node].size(); i++){
		int dest = graph[node][i];
		cnt += DFS(dest);
	}
	return cnt;
}

int BFS(int node){
	int nodes = 0;
	queue<int> q;
	q.push(node);
	visit[node] = true;
	while(!q.empty()){
		nodes++;
		int n = q.front(); q.pop();
		for (int i = 0; i < (int)graph[n].size(); i++){
			int dst = graph[n][i];
			if(!visit[dst]){
				visit[dst] = true;
				q.push(dst);
			}
		}
	}
	return nodes;
}

int main(){
	int t; scanf("%d",&t);
	for (int i = 0; i < t; i++){
		int v,e; scanf("%d %d",&v,&e);
		for(int j=1; j<=v; j++){
			graph[j].clear();
			visit[j] = false;
		}
		int a,b;
		for(int j=0;j<e;j++){
			scanf("%d %d",&a,&b);
			graph[a].push_back(b);
			graph[b].push_back(a);
		}
		int result = 0;
		for(int j=1;j<=v;j++){
			if(!visit[j]){
				result = max(result, BFS(j));
			}
		}
		printf("%d\n",result);
	}
	return 0;
}
