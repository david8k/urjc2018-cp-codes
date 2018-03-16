#include <bits/stdc++.h>

using namespace std;

const int MAXN = 200100;

pair<int,int> arr[MAXN];

int main(){
  int n;
  while(scanf("%d",&n)!=EOF){
    for(int i=0;i<n;i++){
      scanf("%d %d",&arr[i].first, &arr[i].second);
    }
    sort(arr, arr+n);
    priority_queue<int> pq;
    pq.push(0);
    for(int i=0;i<n;i++){
      int early_finish = -pq.top();
      if(arr[i].first >= early_finish){
        pq.pop();
      }
      pq.push(-arr[i].second);
    }
    printf("%d\n",(int)pq.size()-1);
  }
  return 0;
}
