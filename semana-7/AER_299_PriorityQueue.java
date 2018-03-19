import java.util.*;
//Ver las notas de la implementacion con TreeSet.

//Esta implementacion es mas rápida que la version
//con TreeSet y al menos en este problema evitar el
//uso de memoria extra dedicado a aristas redundantes
//no es relevante.
//Utilizar un array de distancias en este problema
//para filtrar aristas peores que alguna que ya tenga
//en la cola de prioridad tiene un leve impacto en el
//tiempo, pero tampoco es critica para obtener AC.

//En este caso no importa que el comparador que utilicemos
//solo compare por coste, ya que a la PriorityQueue no le afecta
//que sean iguales aristas como (A 11) y (B 11) ya que admite
//repetidos y tampoco nos importa a nosotros porque no actualizamos
//el valor de las aristas.

public class AER_299_PriorityQueue {
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
		PriorityQueue<Arista> pq = new PriorityQueue<Arista>();
		//TreeSet<Arista> set = new TreeSet<Arista>();
		pq.add(a);
		while(!pq.isEmpty()) {
			Arista a1 = pq.poll();
			if(!visit[a1.dest]) {
				nvisitados++;
				coste += a1.coste;
				visit[a1.dest]=true;
				for(Arista adj : grafo[a1.dest]) {
					if(!visit[adj.dest] && adj.coste < dmax[adj.dest]) {
						dmax[adj.dest] = adj.coste;
						pq.add(adj);
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
		return Integer.compare(this.coste, o.coste);
		//En esta implementacion (con PQ) no nos afecta
		//negativamente que el metodo compareTo no sea
		//coherente con el metodo equals(). Es decir, que
		//haya elementos distintos (A 11) y (B 11) que
		//a pesar de ser diferentes, parezcan iguales
		//al metodo compareTo.
		
		//Comparador coherente con equals (para treeset)
		//		if(this.coste!=o.coste)
		//			return Integer.compare(this.coste, o.coste);
		//		return Integer.compare(this.dest, o.dest);
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