package semana3;
import java.util.*;
import java.io.*;

public class SPOJ_SGAME {
	//En este problema realmente no hace falta
	//almacenar todo el grafo. El problema se ajusta
	//a la definicion de ciclo euleriano
	//https://es.wikipedia.org/wiki/Ciclo_euleriano#Historia
	// - debe ser conexo (enunciado)
	// - los grados de todos los nodos debe ser pares
	//Si es asi podemos realizar el ciclo. Ademas, no
	//importa el vertice de inicio, lo podemos ignorar.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for(int c=0;c<t;c++){
			sc.nextInt(); //no importa el punto de inicio
			int grados[] = new int[301];
			while(sc.hasNext()){
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				if(v1<1  && v2<1)
					break;
				grados[v1]++;
				grados[v2]++;
			}
			//comprobar que los grados son pares
			boolean pares=true;
			for(int i=1;i<grados.length && pares;i++){
				pares = grados[i]%2 == 0;
			}
			if(pares)
				System.out.println("YES");
			else{
				System.out.println("NO");
			}
		}

	}

}
