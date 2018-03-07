#include <bits/stdc++.h>

using namespace std;

const int MAXN = 311;

vector<int> graph[MAXN];

int main(){
	int t; scanf("%d",&t);
	for (int i = 0; i < t; i++){
		for(int j = 1; j < MAXN; j++) graph[j].clear();
		int n; scanf("%d",&n);
		int a,b;
		while(scanf("%d %d",&a,&b)!=EOF && a != -1 && b != -1){
			graph[a].push_back(b);
			graph[b].push_back(a);
		}
		bool valid = true;
		int j = 1;
		while(j < MAXN && valid){
			if(graph[j].size() % 2 != 0) valid = false;
			j++;
		}
		if(!valid) printf("NO\n");
		else printf("YES\n");
	}
	
	return 0;
}
