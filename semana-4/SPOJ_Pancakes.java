package semana1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Problemas:
 * 	- Se puede elaborar una receta o una fracción de ella
 * es decir que hacer 6,6 veces una receta (66 pankakes) es valido.
 * 	- Los valores de una receta pueden ser cero (división por cero)
 * aunque en java da infinity si se usa float, si se usa integer
 * saltará una excepción de división por cero.
 */
public class SPOJ_Pancakes {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringBuilder sb = new StringBuilder(8000);
	public static void main(String[] args) throws IOException {
		do{
			String[] line = br.readLine().split(" ");
			int ni = Integer.parseInt(line[0]);
			int nr = Integer.parseInt(line[1]);
			if(ni==0 || nr ==0){
				break;
			}
			int k[] = new int[ni];
			line = br.readLine().split(" ");
			//leer ingredientes en k[]
			for(int i=0;i<ni;i++)
				k[i]=Integer.parseInt(line[i]);
			int r = 1;
			int max=0;
			for(int i=0;i<nr;i++){
				//leer recetas
				line = br.readLine().split(" ");
				int min=Integer.MAX_VALUE;
				for(int j=0;j<ni;j++){
					//para cada ingrediente
					float f = Float.parseFloat(line[j]);
					f= k[j]*10/f;
					int nf = (int) f;
					if(nf<min)
						min=nf;//ingrediente mas restrictivo
				}
				//receta menos restrictiva
				if(min>max){//se busca el mayor de todos los minimos
					r=i+1;
					max=min;
				}
			}
			br.readLine();
			//En problemas muy restrictivos de tiempo no se recomienda hacer
			//sb.appen(r+' '+max+'\n'); //la concatenacion de Strings es muy
			//costosa porque son inmutables (se crea uno nuevo por cada concatenacion)
			sb.append(r).append(' ').append(max).append('\n');
		}while(true);
		System.out.println(sb);

	}

}
