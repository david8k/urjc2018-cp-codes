package semana3;
import java.util.*;
import java.io.*;

public class AER_352_Amigos {
	//Se dice que la amistad es transitiva (y se intuye que reflexiva)
	//Si A es amigo de B (viceversa) y B es amigo de C => A amigo de C
	//Se pide encontrar el grupo de amigos más grande (componentes conexas)
	// - lanzar un recorrido bfs/dfs desde cada nodo no visitado
	
	//En este caso podemos utilizar ArrayList para tener una 
	//lista de adyacencia. No necesitamos acceso aleatorio a
	//una arista determinada. Siempre recorremos todas las aristas
	//adyacentes a un vertice.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		for(int c=0;c<k;c++){
			//casos de prueba
			int n = sc.nextInt();
			int m = sc.nextInt();
			ArrayList<Integer> grafo[] = new ArrayList[n+1];
			for(int i=1;i<n+1;i++ ){//indices desde 1! (ignorar pos 0)
				grafo[i] = new ArrayList<Integer>();
			}
			for(int i=0; i<m;i++){
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				grafo[a1].add(a2);
				grafo[a2].add(a1);
			}
			
			int max=0;
			boolean visitados[] = new boolean[n+1];
			for(int i=1; i<n+1;i++){
				if(!visitados[i]){
				int miembros = bfs(grafo,i, visitados);
				if(miembros>max)
					max=miembros;
				}
			}
			System.out.println(max);
		}
	}


	public static int bfs(ArrayList<Integer>[] grafo, int v, boolean[] visitados){
		Queue<Integer> cola = new ArrayDeque<Integer>();
		cola.add(v);
		visitados[v]=true;
		int nvisitados = 1;
		while(!cola.isEmpty()){
			v = cola.poll();
			ArrayList<Integer> adyacentes = grafo[v];
			for (Integer v2 : adyacentes) {
				if(!visitados[v2]){
					visitados[v2]=true;
					cola.add(v2);
					nvisitados++;
				}
			}
		}
		return nvisitados;
	}

}
