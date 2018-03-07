package ejemplos;

import java.util.*;

public class Potitos {
	//Si nos fijamos en los limites nos dicen que tenemos:
	//	10 potitos x 20 ingredientes (como maximo) = 200 ingredientes de 20 caracteres
	//Este problema no es muy exigente en eficiencia, sin embargo
	//el uso de conjuntos nos facilita la codificacion de la solucion.
	
	// Sobre ArrayList, LinkedList...
	//Si utililizamos estas estructuras de datos entonces
	//tendremos que controlar nosotros mismos que no haya repetidos
	//y la complejidad de sus operaciones es:
	// contains(elemento)	O(n) porque se busca el elemento comparando
	//con todos los elementos de la lista hasta encontrarlo.
	// remove(element) 	O(n) porque hay que encontrarlo antes de borrarlo
	//y ademas hay que incluir la complejidad del borrado
	// remove(indice) O(n) si borramos un elemento del que conocemos su
	//indice en la linkedList igualmente hay que buscar el nodo con dicho
	//indice O(n) y en el ArrayList al borrar un elemento hay que desplazar
	//el resto de elementos en el array para no dejar una posicion vacia.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while(n>0){
			//Nota: nextInt no termina de leer toda la linea
			//lo que queda de la linea (en este caso solo el salto de linea)
			//hay que descartarlo haciendo un nextLine.
			String line = sc.nextLine();
			Set<String> aceptados = new HashSet<String>();
			Set<String> rechazados = new HashSet<String>();
			//También podemos utilizar un conjunto ordenado
			//lo que evitará más adelante tener que ordenar
			//la salida.
			//En ese caso las operaciones que utilicemos serán log(n)
			//en vez de el coste O(1) del HashSet.
			//Set<String> rechazados = new TreeSet<String>();
			for(int i=0; i<n; i++){
				line = sc.nextLine();
				//split(regex) recibe una expresion regular
				// - Si queremos separar ignorando multiples espacios seguidos " +"
				// - Si queremos separar por puntos "\."
				// - Se puede practicar como funcionan en: www.regex101.com
				String[] ing = line.split(" ");
				if(ing[0].equals("SI:")){//aceptados
					for(int k=1;k<ing.length-1;k++){
						aceptados.add(ing[k]);
					}
				}else {//rechazados
					for(int k=1;k<ing.length-1;k++){
						rechazados.add(ing[k]);
					}
				}
			}
			//rechazados.retainAll(aceptados);//intersecion, no era lo que se pedia
			rechazados.removeAll(aceptados);//sustraccion de conjuntos o(n)
			if(rechazados.isEmpty()){
				System.out.println();
			} else {
				//ordenar el conjuno antes de mostrarlo:
				//esta parte nos la podriamos ahorrar usando un conjunto
				//ordenado para el conjunto de rechazados
				String[] array = new String[rechazados.size()]; 
				rechazados.toArray(array);
				Arrays.sort(array);//O(nlogn)

				for(int k=0; k<array.length-1; k++){
					System.out.print(array[k]+" ");
				}
				System.out.println(array[array.length-1]);
			}
			n = sc.nextInt();
		}

	}

}
