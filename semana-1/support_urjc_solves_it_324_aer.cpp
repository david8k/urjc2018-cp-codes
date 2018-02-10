#include <bits/stdc++.h>

using namespace std;

void rec(int choco_left, int vaini_left, string res){
  if(choco_left == 0 && vaini_left == 0) printf("%s\n",res.c_str()); // Imprimir
  else{
    if(choco_left > 0)
      rec(choco_left-1, vaini_left, res + "C"); // Poner Choco
    if(vaini_left > 0)
      rec(choco_left, vaini_left-1, res + "V"); // Poner Vainilla
  }
}

int main(){
  string A = "PEPE";
  string B = "PEPA";
  if(A < B){
    printf("%s es lexicograficamente menor que %s\n", A.c_str(), B.c_str());
  }
  else{
    printf("%s es lexicograficamente mayor que %s\n", A.c_str(), B.c_str());
  }
  return 0;
}
