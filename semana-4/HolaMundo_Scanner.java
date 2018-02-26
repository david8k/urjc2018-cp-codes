import java.util.*;

public class HolaMundo_Scanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//String linea = sc.nextLine();//leer lineas
		//String cadena = sc.next();//leer cadenas de caracteres
		//mirad que mas cosas permite leer directamente Scanner
		int n = sc.nextInt();//leer un entero (lo convierte a int automaticamente)
		for(int i=0; i<n;i++){
			System.out.println("Hola mundo.");
		}
		
		/*
		 * Podemos comprobar que podemos seguir leyendo
		 * de la entrada con:
		 * - sc.hasNext();
		 * devuelve true si queda algo que leer (false si hemos
		 * llegado al fin de fichero)
		 * - sc.hasNextInt();
		 * devuelve true si lo siguiente que leamos es un numero
		 * (false si lo siquiente no es un numero entero o si hemos
		 * llegado a fin de fichero) 
		 * - has mas metodos como hasNextLine, hasNextBoolean, hasNextFloat...
		 */

	}

}
