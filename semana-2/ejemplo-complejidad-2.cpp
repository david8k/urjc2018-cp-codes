#include <bits/stdc++.h>

using namespace std;

const int MAXN = 1000;
const int MAXM = 2500;

int mat[MAXN][MAXM];

int main(){
    int N,M;
    scanf("%d %d",&N,&M);
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            scanf("%d",&mat[i][j]);
            if(mat[i][j] % 3 == 0){
                for(int k=0;k<N;k++){
                    mat[k][j] = mat[i][j]-20;
                }
            }
            else{
                mat[i][j]++;
            }
        }
    }

}


