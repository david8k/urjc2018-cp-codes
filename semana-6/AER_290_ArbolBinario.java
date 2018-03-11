import java.util.*;

public class AER_290_ArbolBinario {

	//utilizamos una variable global porque en Java
	//no podemos pasar valores por referencia. Y necesitamos
	//que cualquier modificacion en indice se mantenga de
	//forma global en todas las llamadas recursivas.
	//Otras opciones serian:
	// - declarar un array de una posicion
	//int[] indice = new int[1];
	// - declarar una clase que contenga el entero
	// class Indice{ int i;}
	//y pasarlos como parámetros de "rec". Cualquier
	//modificacion se mantendria.
	static int indice;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i=0 ; i<n; i++){
			String arbol = sc.next();
			indice=0;
			int h = rec(0, arbol);
			System.out.println(h);
		}

	}
	private static int rec(int nodo, String arbol) {
		indice++;
		if(arbol.charAt(nodo)=='.')
			return 0;
		return 1 + Math.max(rec(indice, arbol),rec(indice, arbol));
	}

}

