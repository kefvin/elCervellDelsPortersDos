package Segon.elCervellDelsPortersDos;

public class Porter {

	int edat = 0;
	String sexe = "";
	String sabates = "";
	int diners = 0;
	
	public Porter(int edatEntrada, String sexeEntrada, String sabatesEntrada , int dinersEntrada){
		edat = edatEntrada;
		sexe = sexeEntrada;
		sabates = sabatesEntrada;
		diners = dinersEntrada;
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
	
	// **************** CHECK ORDRES *********************
	public boolean check(Client client){
		if(edat <= client.getEdat() &&
		  (sexe.equals(client.getSexe()) || sexe.equals("")) && 
		  (sabates.equals(client.getSabates()) || sabates.equals("")) &&
		  (diners <= client.getDiners())){
			return true;
		}else{
			return false;
		}
	}
	
	
}
