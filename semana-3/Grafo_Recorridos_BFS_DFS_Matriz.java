import java.util.*;

public class Grafo_Recorridos_BFS_DFS_Matriz {
/*
 * Grafo:
 * 
 *           2       5---6---11
 *   1      / \      |   |   |
 *         3---4     7---8---9---10    12
 * Entrada:
 * vertices/11 aristas/10
 * v1 v2
 * vi vj
 * ...

12 11
2 3
2 4
3 4
5 6
5 7
6 8
6 11
7 8
8 9
9 10
9 11
 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/** leer grafo en una matriz de booleanos */
		int vertices = sc.nextInt();
		int aristas = sc.nextInt();
		//descartar el resto de la primera linea
		sc.nextLine(); 
		boolean[][] grafo = new boolean[vertices][vertices];
		for(int k=0;k<aristas;k++){
			int v1 = sc.nextInt()-1;
			int v2 = sc.nextInt()-1;
			grafo[v1][v2] = true;
			grafo[v2][v1] = true; //grafo NO dirigido -> matriz simetrica
		}
		
		componentesConexas1(grafo);

	}

	private static void componentesConexas1(boolean[][] grafo) {
		//contaremos las componentes con un BFS
		int componentes = 0;
		boolean[] visitados = new boolean[grafo.length];
		for(int k=0; k<grafo.length; k++){
			if(!visitados[k]){
				componentes++;
				System.out.printf("Componente %d: ", componentes);
				bsf(k, grafo, visitados);
				//dfs(k,grafo,visitados);
			}
		}
		System.out.println("Componentes totales: "+ componentes);
		
	}

	private static void bsf(int vertice, boolean[][] grafo, boolean[] visitados) {
		//- La clase ArrayDeque está implementado como un array
		//en el que es muy eficiente eliminar al principio y al final
		//se puede utilizar como lista, pila, cola o array dinámico
		// - La interfaz Queue nos fuerza a que solo se pueda utilizar AD
		//como una cola.
		Queue<Integer> cola = new ArrayDeque<Integer>();
		cola.add(vertice);
		visitados[vertice]=true;
		while(!cola.isEmpty()){
			int v1=cola.poll();
			System.out.print((v1+1)+" ");
			for(int v2=0;v2<grafo.length;v2++){
				//Si es adyavente al vertice actual
				//y aun no ha sido visitado, lo visitamos
				if(!visitados[v2] && grafo[v1][v2]){
					cola.add(v2);
					visitados[v2]=true;
				}
			}
		}
		System.out.println();
	}
	
	private static void dfs(int vertice, boolean[][] grafo, boolean[] visitados) {
		//Para el recorrido dsf solo necesitamos utilizar una pila en
		//vez de una cola. NO usaremos la clase Stack de java porque
		//es una clase con sincronizacion (cosas para multihilo) que
		//la hacen mas lenta para el uso que le vamos a dar.
		// Tampoco existe una interfaz Stack asi como antes utilizamos Queue
		//por lo que usaremos ArrayDeque limitandonos a usar solo sus metodos
		//tipo "pila" como: push y pop

		
		ArrayDeque<Integer> pila = new ArrayDeque<Integer>();
		pila.push(vertice);
		visitados[vertice]=true;
		while(!pila.isEmpty()){
			int v1=pila.pop();
			System.out.print((v1+1)+" ");
			for(int v2=0;v2<grafo.length;v2++){
				//Si es adyavente al vertice actual
				//y aun no ha sido visitado, lo visitamos
				if(!visitados[v2] && grafo[v1][v2]){
					pila.push(v2);
					visitados[v2]=true;
				}
			}
		}
		System.out.println();
	}

}
