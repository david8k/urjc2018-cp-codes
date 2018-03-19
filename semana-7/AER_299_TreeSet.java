import java.util.*;
//Solucion que utiliza TreeSet
// - El TreeSet nos permite mantener el orden
//y actualizar/eliminar elementos en cualquier posicion
//de forma eficiente. (algo que no permite PriorityQueue)
// - El TreeSet al ser un conjunto ordenado requiere:
//    * Que el elemento a ordenar sea Comparable, o que
//    pasemos un Comparator para que pueda establecer un
//    orden.
//    * Al ser un Set no admite repetidos, tendremos que
//    tener cuidado de que nuestro método de comparacion
//    no identifique elementos distintos como "iguales"
//    e.g.: Si solo comparamos el coste de las aristas 
//    entonces (A 11) y (B 11) apareceran iguales y una
//    de ellas no sera incluida en el conjunto.

//NOTA: He utilizado un TreeSet para "ahorrar" en memoria
//y no tener en mi "lista" de aristas multiples aristas hacia
//el mismo nodo. Aunque este enfoque da AC es mas lento que
//utilizar una PriorityQueue (y mantener aristas redundantes)
// y esta ultima tambien da AC.


public class AER_299_TreeSet {
	public static int nvisitados;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			//leer caso prueba
			int n = sc.nextInt();
			int c = sc.nextInt();
			ArrayList<Arista> grafo[] = new ArrayList[n+1];
			for(int i=1; i<n+1; i++){
				grafo[i]= new ArrayList<Arista>();
			}
			for(int i=0; i<c; i++) {
				//leer aristas
				int ini = sc.nextInt();
				int fin = sc.nextInt();
				int coste = sc.nextInt();
				Arista a1 = new Arista(fin, coste);
				Arista a2 = new Arista(ini, coste);
				grafo[ini].add(a1);
				grafo[fin].add(a2);
			}
			nvisitados=0;
			long coste = prim(1, grafo);
			if(nvisitados!=n){
				System.out.println("Imposible");
			} else {
				System.out.println(coste);
			}
			
			
		}
		

	}
	private static long prim(int v, ArrayList<Arista>[] grafo) {
		long coste = 0;
		boolean visit[] = new boolean[grafo.length];//(n+1)
		int dmax[] = new int[grafo.length];
		for(int i=1; i<grafo.length; i++) {
			dmax[i] = Integer.MAX_VALUE;//infinito
		}
		
		Arista a = new Arista(v, 0);
		
		TreeSet<Arista> set = new TreeSet<Arista>();
		set.add(a);
		while(!set.isEmpty()) {
			Arista a1 = set.pollFirst();
			if(!visit[a1.dest]) {
				nvisitados++;
				coste += a1.coste;
				visit[a1.dest]=true;
				for(Arista adj : grafo[a1.dest]) {
					if(!visit[adj.dest] && adj.coste < dmax[adj.dest]) {
						Arista actualizar = new Arista(adj.dest, dmax[adj.dest]);
						if(set.contains(actualizar)) {
							set.remove(actualizar);
						}
						dmax[adj.dest] = adj.coste;
						actualizar.coste = adj.coste;
						set.add(actualizar);
					}
				}
			}
		}
		return coste;
	}

}

class Arista implements Comparable<Arista>{
	int dest;
	int coste;
	 public Arista(int d, int c) {
		 dest = d;
		 coste = c;
	 }
	 //B 11
	 //B 7
	@Override
	public int compareTo(Arista o) {
		if(this.coste!=o.coste)
			return Integer.compare(this.coste, o.coste);
		return Integer.compare(this.dest, o.dest);
	}
	
	
}
/*
5
7
1 2 7
1 3 6
3 2 1
1 4 10
3 4 15
3 5 3
4 5 12
4
3
1 3 2
1 4 3
3 4 5
*/
