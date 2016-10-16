package Git;

import java.util.Scanner;

public class Git {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Git git = new Git();
		Scanner lector = new Scanner(System.in);
		// System.out.println("Escribe una frase.");
		// String fras = lector.nextLine();
		// String frase=fras.toLowerCase();
		String comprova = "";
		
		String frase ="abcabd";
		
		comprova = git.Comprovar(comprova, frase);
		
		System.out.println("Eliminats:" + comprova);
		
		git.Compta(comprova, frase);
		
			
		}
	
	public String Comprovar(String comprova, String frase){
				
		
		for(int i=0; i < frase.length();i++){
										
				if (comprova.indexOf(frase.charAt(i)) == -1) {
					comprova = comprova+frase.charAt(i);
				}
			
		}
		return comprova;
	}
	
	public void Compta(String comprova, String frase){
		int count=0;
		
		for(int i=0; i < comprova.length();i++){
			
			count = comptaVegades(comprova.charAt(i), frase);			
			System.out.println("La letra "+comprova.charAt(i)+" se repite "+count+" veces.");
			
		}
		
		
	}
	
	public int comptaVegades(char lletra, String frase) {
		
		return 0;
	}
	
}


