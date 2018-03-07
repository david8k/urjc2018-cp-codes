package semana4.practica;
import java.util.*;
import java.io.*;


public class Partituras {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//Usar BufferedReader si nos da TLE por la lectura
		PriorityQueue<Grupo> cola = new PriorityQueue<Grupo>(8000);
		while(sc.hasNextInt()){
			//leer caso de prueba
			int p = sc.nextInt();
			int n = sc.nextInt();
			
			for(int i=0; i<n; i++){
				int g = sc.nextInt();
				cola.add(new Grupo(g));
			}
			
			p = p - n;
			while(p>0){
				Grupo g = cola.poll();
				g.darPartitura();
				cola.add(g);
				p--;
			}
			//StringBuilder
			System.out.println(cola.peek().max);
			cola.clear();
			
		}
	}

}

//Implementar la interfac Comparable define su orden natural
//y permite que las estructuras de datos ordenadas puedan compararlos
//automaticamente
class Grupo implements Comparable<Grupo> {
	int n, p, max;
	
	public Grupo(int n){
		this.n = n;
		this.p = 1;
		this.max = n;
	}
	//Para mantener el orden
	//- Comparable
	//- Comparator
	
	public void darPartitura(){
		this.p++;
		this.max = n/p;
		if(n%p != 0)
			max++;
	}

	@Override
	public int compareTo(Grupo o) {
		//Se cambia el signo del compare por defecto
		//para invertir el orden natural (menor a mayor -> mayor a menor)
		return -Integer.compare(this.max, o.max);
	}
}
