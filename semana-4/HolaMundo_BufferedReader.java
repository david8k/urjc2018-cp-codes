
//la mayoria de clases que utilizamos esta
//en util o io, asi que importamos todo lo que
//tengan estas bibliotecas
import java.util.*;
import java.io.*;

public class HolaMundo_BufferedReader {

	// en general no necesitaremos controlar excepciones
	// por eso simplemente las lanzamos con throws Exception
	// si hay algun error nuestro programa fallara con
	// RTE (RunTimeException) o NZEC (NonZeroErrorCode)
	// Si por el contrario capturamos las excepciones no
	// sabremos que nuestor programa falla por un error
	// de ejecucion y el veredicto sera solamente WA (Wrong Answer)
	public static void main(String[] args) throws Exception {
		//creamos el objeto BR para leer de entrada estandar
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// leer todo hasta encontrar salto de linea
		String line = br.readLine();
		//convertir la cadena de caracteres a un numero
		int n = Integer.parseInt(line);
		for (int i = 0; i < n; i++)
			System.out.println("Hola mundo.");

		//Nota: el metodo readLine() devuelve null si llega a
		//fin de fichero (EOF)
	}

}
