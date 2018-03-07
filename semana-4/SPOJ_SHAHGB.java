import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SPOJ_SHAHGB {

	//IMPORTANTE: Este problema puede dar TLE en java
    //muy facilmente solo por utilizar:
	// - using PrintWriter
	// - using scanner
	public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder(8000);

    //Algoritmo O(n): Se realizan operaciones O(1) por cada persona que llega.
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(in.readLine());
		String[] indices = in.readLine().split(" ");
		//declaramos el array con posiciones extra para no preocuparnos
        //de los limites. Las personas van de 1 <= Q <= 20000
        int posiciones[] = new int[20000+2];
		int grupos=0;
		for(int i=0;i<n;i++){
			int pi = Integer.parseInt(indices[i]);
			posiciones[pi]=1;
			int pleft=posiciones[pi-1];
			int pright=posiciones[pi+1];
			//Si no hay nadie a izq-der suma -1 y disminuye
			//Si hay alguien suma cero y se queda igual
			//Si no hay nadie cerca suma 1 y aumenta
			grupos +=1-pleft-pright;
			sb.append(grupos).append('\n');
		}
		sb.append("Justice\n");
		System.out.print(sb);
	}

}
