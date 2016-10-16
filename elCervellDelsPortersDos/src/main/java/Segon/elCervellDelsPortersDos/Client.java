package Segon.elCervellDelsPortersDos;

public class Client {
	
	String nom;
	int edat;
	String sexe;
	String sabates;
	int diners;
	
	// *********************** CONSTRUCTOR******************************
	public Client(String rNom, int rEdat, String rSexe, String rSabates, int rDiners){
		
		edat = rEdat;
		sexe = rSexe;
		sabates = rSabates;
		diners = rDiners;
		nom = rNom;
		
	}
	

	// ******************* GETTERS ********************
	public int getEdat(){
		return edat;
	}
	
	public String getSexe(){
		return sexe;
	}
	
	public String getSabates(){
		return sabates;
	}
	
	public int getDiners(){
		return diners;
	}

	@Override
	public String toString() {
		return nom;
	}
}
