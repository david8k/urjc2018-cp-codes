import java.io.BufferedReader;
//Ver notas de las otras implementaciones.

//Aqui se utiliza PriorityQueue, que es mas
//rapido que TreeSet en este caso y se utiliza
//BufferedReader+StringBuilder para aumentar
//la velocidad de las operaciones en entrada 
//y salida.

//El tiempo de ejecucion total pasa de 4-5 segundos
//a 2 segundos. (De todas formas, lo importante es que
//de AC) La complejidad asintótica no cambia, pero si 
//los limites son muy ajustados podriamos tener un TLE.

import java.io.InputStreamReader;
import java.util.*;
public class AER_299_PriorityQueue_FastIO {
	public static int nvisitados;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(8000);
		String line = br.readLine();
		while(line != null && !line.isEmpty()) {
			//leer caso prueba
			int n = Integer.parseInt(line);
			int c = Integer.parseInt(br.readLine());
			ArrayList<Arista> grafo[] = new ArrayList[n+1];
			for(int i=1; i<n+1; i++){
				grafo[i]= new ArrayList<Arista>();
			}
			for(int i=0; i<c; i++) {
				//leer aristas
				String ls[] = br.readLine().split(" ");
				int ini = Integer.parseInt(ls[0]);
				int fin = Integer.parseInt(ls[1]);
				int coste = Integer.parseInt(ls[2]);
				Arista a1 = new Arista(fin, coste);
				Arista a2 = new Arista(ini, coste);
				grafo[ini].add(a1);
				grafo[fin].add(a2);
			}
			nvisitados=0;
			long coste = prim(1, grafo);
			if(nvisitados!=n){
				sb.append("Imposible");
			} else {
				sb.append(coste);
			}
			sb.append('\n');
			line = br.readLine();
		}
		System.out.print(sb);
		

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