
import java.util.*;

public class Grafo_Recorridos_BFS_DFS_Mapa {
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
		//Mapa<vertices,listaAdyacencia>
		Map<Integer,Set<Integer>> grafo = new HashMap<Integer,Set<Integer>>();
		//inicializar cada lista de adyacencia
		for(int k=1;k<=vertices;k++){
			grafo.put(k,new HashSet<Integer>());
		}
		
		for(int k=0;k<aristas;k++){
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			grafo.get(v1).add(v2);//obtener la lista de adyacencia de v1 y guardar v2 en ella
			grafo.get(v2).add(v1);//grafo NO dirigido, guardamos la arista de v2 a v1
		}
		
		componentesConexas(grafo);

	}

	private static void componentesConexas(Map<Integer,Set<Integer>> grafo) {
		//contaremos las componentes con un BFS
		int componentes = 0;
		boolean[] visitados = new boolean[grafo.size()];
		for(int k=1; k<=grafo.size(); k++){
			if(!visitados[k-1]){
				componentes++;
				System.out.printf("Componente %d: ", componentes);
				//bsf(k, grafo, visitados);
				dfs(k,grafo,visitados);
			}
		}
		System.out.println("Componentes totales: "+ componentes);
		
	}

	private static void bsf(int vertice, Map<Integer,Set<Integer>> grafo, boolean[] visitados) {
		//- La clase ArrayDeque está implementado como un array
		//en el que es muy eficiente eliminar al principio y al final
		//se puede utilizar como lista, pila, cola o array dinámico
		// - La interfaz Queue nos fuerza a que solo se pueda utilizar AD
		//como una cola.
		Queue<Integer> cola = new ArrayDeque<Integer>();
		cola.add(vertice);
		visitados[vertice-1]=true;
		while(!cola.isEmpty()){
			int v1=cola.poll();
			System.out.print(v1+" ");
			Set<Integer> setAdyacentesV1 = grafo.get(v1);
			for (Integer v2 : setAdyacentesV1) {
				if(!visitados[v2-1]){
					cola.add(v2);
					visitados[v2-1]=true;
				}
			}
		}
		System.out.println();
	}
	
	private static void dfs(int vertice, Map<Integer,Set<Integer>> grafo, boolean[] visitados) {
		//Para el recorrido dsf solo necesitamos utilizar una pila en
		//vez de una cola. NO usaremos la clase Stack de java porque
		//es una clase con sincronizacion (cosas para multihilo) que
		//la hacen mas lenta para el uso que le vamos a dar.
		// Tampoco existe una interfaz Stack asi como antes utilizamos Queue
		//por lo que usaremos ArrayDeque limitandonos a usar solo sus metodos
		//tipo "pila" como: push y pop

		
		ArrayDeque<Integer> pila = new ArrayDeque<Integer>();
		pila.push(vertice);
		visitados[vertice-1]=true;
		while(!pila.isEmpty()){
			int v1=pila.pop();
			System.out.print(v1+" ");
			Set<Integer> setAdyaventesV1 = grafo.get(v1);
			for (Integer v2 : setAdyaventesV1) {
				if(!visitados[v2-1]){
					pila.push(v2);
					visitados[v2-1]=true;
				}
			}
		}
		System.out.println();
	}

}
