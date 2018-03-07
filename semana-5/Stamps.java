package semana4.practica;
import java.util.*;
public class Stamps {

	public static void main(String[] args) {
		Scanner l = new Scanner(System.in);
		
		int scenarios = l.nextInt();
		l.nextLine(); //Evitar \n
		
		for(int i=0; i < scenarios; i++){
			int needed = l.nextInt();
			int friends = l.nextInt();
			//String line = l.nextLine();
			//String aux[] = line.split(" ");
			l.nextLine();
			int list [] = new int[friends];
			int suma = 0;
			
			for(int j=0; j < friends; j++){
				int k = l.nextInt();
				list[j] = k;
				suma +=k;
			}
			l.nextLine();
			
			if(suma<needed){
				System.out.println("Scenario #"+(i+1)+":\nimpossible");
			}else if (suma==needed){
				System.out.println("Scenario #"+(i+1)+":\n"+friends);
			}else{
				Arrays.sort(list);
				for(int j=0; j<list.length/2; j++){
					int temp = list[list.length-1-j];
					list[list.length-1-j] = list[j];
					list[j] = temp;
				}
				
				suma = 0;
				int n = 0;
				
				while(suma<needed){
					suma += list[n];
					n++;
				}
				
				System.out.println("Scenario #"+(i+1)+":\n"+n);
			}
			
		}
	}

}
