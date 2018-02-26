import java.util.*;
/*
 * Algunos problemas tiene limites de tiempo
 * muy ajustados. En java esto es una dificultad
 * extra porque problemas como SHAHGB y Pancakes
 * pueden dar TLE a pesar de usar un algoritmo
 * eficiente. Esto ocurre porque imprimir la salida
 * con System.out.println() es muy lento y llamar
 * varias veces a ese metodo provocara que nos
 * pasemos de tiempo.
 * 
 * Una solucion es utilizar la clase StringBuilder
 * para acumular la salida y llamar a System.out.println()
 * una vez con la salida acumulada.
 */

public class SPOJ_TEST_StringBuilder {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while(sc.hasNextInt()){
			int n= sc.nextInt();
			if(n==42)
				break;
			//añadimos al StringBuilder el numero
			//y luego un salto de linea
			sb.append(n).append('\n');
			
			//Nota: no hacer algo como:
			//sb.append(n+"\n"); porque seria
			//mas lento.
		}
		//imprimimos una vez toda la salida acumulada
		System.out.println(sb);
	}
}
